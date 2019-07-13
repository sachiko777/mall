package com.mall.controller;

import com.mall.pojo.Paper;
import com.mall.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PaperController {
    @Autowired
    private PaperService paperService;

    @RequestMapping("/paper/{paperid}")
    @ResponseBody
    public Paper getPaperById(@PathVariable long paperid){
        Paper paper=paperService.queryById(paperid);
        System.out.print(paper.getPaper_id());
        return paper;
    }

}
