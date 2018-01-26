package com.github.wxz.controller;

import com.github.wxz.common.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xianzhi.wang
 * @date 2018/1/26 -15:07
 */
@RestController
@RequestMapping("netease")
public class NetEaseController {
    private static Logger LOGGER = LoggerFactory.getLogger(NetEaseController.class);

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public Response search(Model model, @RequestParam("musicSearch") String musicSearch) {

        return Response.FAIL;
    }
}
