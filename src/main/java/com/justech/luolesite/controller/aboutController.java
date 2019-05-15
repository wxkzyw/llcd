package com.justech.luolesite.controller;

import com.justech.luolesite.service.frontWebService;
import com.thinkgem.jeesite.modules.cms.entity.ArticleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: WangXiaoKun
 * @Date: 2019/4/22 17:06
 * 关于我们Controller
 */
@Controller
@RequestMapping("${frontPath}")
public class aboutController {

    @Autowired
    private frontWebService frontWebService;

    /**
     * 简体版
     * @return
     */
    @RequestMapping("/cnSimpleAbout")
    public ModelAndView aboutCNSimple(){
        ModelAndView modelAndView=new ModelAndView();

        ArticleData indexCompanyIntroduce=frontWebService.getCompanyContent("简体");//首页公司简介

        modelAndView.addObject("indexCompanyIntroduce",indexCompanyIntroduce);
        modelAndView.setViewName("luolePages/cn-simple/about");
        return modelAndView;
    }

    /**
     * 繁体版
     * @return
     */
    @RequestMapping("/cnComplexAbout")
    public ModelAndView aboutCNComplex(){
        ModelAndView modelAndView=new ModelAndView();

        ArticleData indexCompanyIntroduce=frontWebService.getCompanyContent("繁体");//首页公司简介

        modelAndView.addObject("indexCompanyIntroduce",indexCompanyIntroduce);
        modelAndView.setViewName("luolePages/cn-complex/about");
        return modelAndView;
    }

    /**
     * 英文版
     * @return
     */
    @RequestMapping("/englishAbout")
    public ModelAndView englishAbout(){
        ModelAndView modelAndView=new ModelAndView();

        ArticleData indexCompanyIntroduce=frontWebService.getCompanyContent("英文");//首页公司简介

        modelAndView.addObject("indexCompanyIntroduce",indexCompanyIntroduce);
        modelAndView.setViewName("luolePages/english/about");
        return modelAndView;
    }
}
