package com.github.wxz.action;

import com.github.wxz.common.response.Response;
import com.github.wxz.domain.UserAuthDO;
import com.github.wxz.framework.file.FilesUtilCommon;
import com.github.wxz.service.HeadPrinter;
import com.github.wxz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

/**
 * @author xianzhi.wang
 * @date 2018/1/18 -16:48
 */
@RestController
@RequestMapping("image")
public class ImageAction {
    private static final String MULTIPART = "multipart/";
    private static Logger LOGGER = LoggerFactory.getLogger(ImageAction.class);

    @Autowired
    public FilesUtilCommon filesUtilCommon;
    @Autowired
    public UserService userService;
    @Autowired
    private HeadPrinter headPrinter;

    @RequestMapping(value = "changePic", method = RequestMethod.POST)
    public Response changePic(HttpServletRequest httpRequest, Model model) {
        UserAuthDO userAuthDO = headPrinter.printHead(model);
        String imagePath =
                getImgPath(httpRequest);
        LOGGER.info("changePic id {} ,imgPath {} ", userAuthDO.getId(), imagePath);
        int status = userService.updatePic(userAuthDO.getId(), imagePath);
        if (status == 1) {
            return Response.SUCCESS;
        }
        return Response.FAIL;
    }

    private String getImgPath(HttpServletRequest httpRequest) {
        String contentType = httpRequest.getContentType();
        String imagePath = "";
        if (contentType != null && contentType.toLowerCase().startsWith(MULTIPART)) {
            MultipartHttpServletRequest multipartRequest =
                    WebUtils.getNativeRequest(httpRequest, MultipartHttpServletRequest.class);
            Iterator<String> itr = multipartRequest.getFileNames();
            CommonsMultipartFile multipartFile;
            while (itr.hasNext()) {
                String str = itr.next();
                multipartFile = (CommonsMultipartFile) multipartRequest.getFile(str);
                //原文件名
                String fileName = multipartFile.getOriginalFilename();
                MultipartFile file = multipartRequest.getFile(fileName);
                if (file == null) {
                    file = multipartFile;
                }
                imagePath = filesUtilCommon.getPath(file);
            }
        }
        return imagePath;
    }
}
