package com.github.wxz.controller;

import com.github.wxz.common.response.Response;
import com.github.wxz.common.util.DateUtil;
import com.github.wxz.common.util.PaginationManage;
import com.github.wxz.domain.ArticleDO;
import com.github.wxz.domain.UserAuthDO;
import com.github.wxz.domain.leave.message.LeaveMessageDO;
import com.github.wxz.entity.*;
import com.github.wxz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -12:33
 */
@Controller
public class IndexController {

    @Autowired
    public UserService userService;

    @Autowired
    public ArticleService articleService;

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @Autowired
    private ArticleTagService articleTagService;

    @Autowired
    private ArticleAccessLogService articleAccessLogService;

    @Autowired
    private ArticleMemoService articleMemoService;

    @Autowired
    private TimeLineService timeLineService;

    @Autowired
    private HeadPrinter headPrinter;

    /**
     * home
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "home")
    public String home(Model model) {
        headPrinter.printHead(model);
        User user = userService.getUserById(6);
        model.addAttribute("user", user);
        PaginationManage<ArticleDO> articlePaginationManage = articleService.getArticlesByPage(1, PaginationManage.DEFAULT_SIZE_5);
        List<Article> chosenArticleList = articleService.getChosenArticles();

        model.addAttribute("chosenArticleList", chosenArticleList);

        model.addAttribute("article", articlePaginationManage);
        return "home/home";
    }

    /**
     * article
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "article")
    public String article(Model model) {
        headPrinter.printHead(model);

        List<ArticleCategory> articleCategoryList = articleCategoryService.getAllArticleCateGory();

        List<Article> chosenArticleList = articleService.getChosenArticles();
        List<Article> topArticleList = articleService.getTopArticles();

        model.addAttribute("articleCategoryList", articleCategoryList);

        model.addAttribute("chosenArticleList", chosenArticleList);
        model.addAttribute("topArticleList", topArticleList);
        return "article/article";
    }

    @RequestMapping(value = "detail")
    public String detail(Model model, @RequestParam("a") Integer id) {
        UserAuthDO userAuthDO = headPrinter.printHead(model);
        if (id == null || id == 0) {
            return "home/home";
        }
        Article article = articleService.getArticleByArticleId(id);

        if (article == null) {
            return "home/home";
        }

        articleAccessLogService.addArticleAccessLog(userAuthDO == null ? 0 : userAuthDO.getId(), id);

        ArticleDO articleDO = articleService.convertArticleToArticleDO(article);
        List<ArticleCategory> articleCategoryList = articleCategoryService.getAllArticleCateGory();

        List<Article> chosenArticleList = articleService.getChosenArticles();

        model.addAttribute("articleDO", articleDO);

        model.addAttribute("articleCategoryList", articleCategoryList);

        model.addAttribute("chosenArticleList", chosenArticleList);

        return "detail/detail";
    }

    /**
     * about
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "about")
    public String about(Model model) {

        headPrinter.printHead(model);
        LeaveMessageDO leaveMessageDO = articleMemoService.getLeaveMessage();
        model.addAttribute("leaveMessageDO", leaveMessageDO);

        return "about/about";
    }

    @RequestMapping(value = "resource")
    public String resource(Model model) {
        headPrinter.printHead(model);
        return "resource/resource";
    }

    @RequestMapping(value = "timeline")
    public String timeline(Model model) {
        headPrinter.printHead(model);
        return "timeline/timeline";
    }


    @RequestMapping("timelineAjax")
    public @ResponseBody
    Response timelineAjax(@RequestParam("pageNo") Integer pageNo) {
        PaginationManage<TimeLine> timeLinePaginationManage = timeLineService.getTimeLineByPage(pageNo, 30);
        List<TimeLine> timeLineList = timeLinePaginationManage.getDataList();
        Map<String, Map<String, List<TimeLine>>> stringListMap = new TreeMap<>(Comparator.reverseOrder());
        timeLineList.stream().forEach(timeLine -> {
            String year = DateUtil.getYear(timeLine.getCreate()) + "";
            //月份
            String month = year + "" + DateUtil.getMonth(timeLine.getCreate());
            Map<String, List<TimeLine>> map = stringListMap.get(year);
            if (CollectionUtils.isEmpty(map)) {
                List<TimeLine> timeLines = new ArrayList<>();
                timeLines.add(timeLine);
                map = new TreeMap<>(Comparator.reverseOrder());
                map.put(month, timeLines);
                stringListMap.put(year, map);
            } else {
                List<TimeLine> lineList = map.get(month);
                if (CollectionUtils.isEmpty(lineList)) {
                    List<TimeLine> timeLines = new ArrayList<>();
                    timeLines.add(timeLine);
                    map.put(month, timeLines);
                } else {
                    lineList.add(timeLine);
                    map.put(month, lineList);
                }
                stringListMap.put(year, map);
            }
        });

        return Response.successResponse(stringListMap);
    }

    @RequestMapping(value = "edit")
    public String edit(Model model) {
        headPrinter.printHead(model);

        List<ArticleCategory> articleCategoryList = articleCategoryService.getAllArticleCateGory();
        List<ArticleTag> articleTagList = articleTagService.getAllArticleTag();

        model.addAttribute("articleCategoryList", articleCategoryList);
        model.addAttribute("articleTagList", articleTagList);
        return "edit/edit";
    }
}
