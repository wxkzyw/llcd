package com.justech.luolesite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: WangXiaoKun
 * @Date: 2019/4/24 19:00
 * 联系我们Controller
 */
@Controller
@RequestMapping("${frontPath}")
public class contactController {

	/**
	 * 简体版 联系我们
	 * @return
	 */
	@RequestMapping("contact")
	public ModelAndView contact(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("luolePages/cn-simple/contact");
		return modelAndView;
	}

	/**
	 * 繁体版 联系我们
	 * @return
	 */
	@RequestMapping("complexcontact")
	public ModelAndView complexcontact(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("luolePages/cn-complex/contact");
		return modelAndView;
	}

	/**
	 * 英文版 联系我们
	 * @return
	 */
	@RequestMapping("englishcontact")
	public ModelAndView englishcontact(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("luolePages/english/contact");
		return modelAndView;
	}
}
