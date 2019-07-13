package com.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面管理控制器
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String requeseIndex(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String requesePage(@PathVariable String page){
        return page;
    }


}
