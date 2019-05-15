package com.justech.luolesite.controller;

import com.justech.luolesite.entity.imgEntity;
import com.justech.luolesite.service.frontWebService;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.ArticleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @Author: WangXiaoKun
 *  @Date: 2019/4/15 8:42
 */
@Controller
@RequestMapping("${frontPath}")
public class frontWebController {

    @Autowired
    private frontWebService frontWebService;

    private static final String cnSimpleHomePagePath="/userfiles/1/images/homePage-cn-simple/";
    private static final String cnComplexHomePagePath="/userfiles/1/images/homePage-cn-complex/";
    private static final String englishHomePagePath="/userfiles/1/images/homePage-english/";
    private static final String productCenterPath="/userfiles/1/images/ProductCenter/";
    private static final String productscategoryid="e258a4ba24a74581bb799f53df5e4b54";//产品中心栏目id


    //简体版
    @RequestMapping("/cnSimpleIndex")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();

        List<imgEntity> imgUrls=frontWebService.getIndexImgs(request,cnSimpleHomePagePath);//首页轮播图片
        ArticleData indexCompanyIntroduce=frontWebService.getCompanyContent("简体");//首页公司简介


        Map<String,Object> mapproduct=new HashMap<String, Object>();
        mapproduct.put("keywords","简体");
        mapproduct.put("categoryid",productscategoryid);
        List<Article> articles=frontWebService.getSmallArticles(mapproduct);//首页产品中心图片
        List<Article> TSUNTIENproducts=frontWebService.TSUNTIENproducts(mapproduct);//TSUNTIEN产品系列
        /*List<imgEntity> products=frontWebService.getProuctsImg(request,productCenterPath);*/

        Map<String,Object> map=new HashMap<String, Object>();
        String newscategoryid="bb415331f2c54121ab388a234e5792fb";//新闻中心栏目id
        String keywords="简体";
        int limit=3;
        map.put("categoryid",newscategoryid);
        map.put("keywords",keywords);
        map.put("limit",limit);
        List<Article> news=frontWebService.getNewsContent(map);//新闻列表

        modelAndView.addObject("indexImgs",imgUrls);
        modelAndView.addObject("indexCompanyIntroduce",indexCompanyIntroduce);
        modelAndView.addObject("TSUNTIENproducts",TSUNTIENproducts);
        modelAndView.addObject("products",articles);
        modelAndView.addObject("news",news);

        modelAndView.setViewName("luolePages/cn-simple/homePage");
        return modelAndView;
    }


    //繁体版
    @RequestMapping("/cnComplexIndex")
    public ModelAndView complexindex(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();

        List<imgEntity> imgUrls=frontWebService.getIndexImgs(request,cnComplexHomePagePath);//首页轮播图片
        ArticleData indexCompanyIntroduce=frontWebService.getCompanyContent("繁体");//首页公司简介


        Map<String,Object> mapproduct=new HashMap<String, Object>();
        mapproduct.put("keywords","繁体");
        mapproduct.put("categoryid",productscategoryid);
        List<Article> articles=frontWebService.getSmallArticles(mapproduct);//首页产品中心图片
        List<Article> TSUNTIENproducts=frontWebService.TSUNTIENproducts(mapproduct);//TSUNTIEN产品系列
        /*List<imgEntity> products=frontWebService.getProuctsImg(request,productCenterPath);*/

        Map<String,Object> map=new HashMap<String, Object>();
        String newscategoryid="bb415331f2c54121ab388a234e5792fb";//新闻中心栏目id
        String keywords="繁体";
        int limit=3;
        map.put("categoryid",newscategoryid);
        map.put("keywords",keywords);
        map.put("limit",limit);
        List<Article> news=frontWebService.getNewsContent(map);//新闻列表

        modelAndView.addObject("indexImgs",imgUrls);
        modelAndView.addObject("indexCompanyIntroduce",indexCompanyIntroduce);
        modelAndView.addObject("TSUNTIENproducts",TSUNTIENproducts);
        modelAndView.addObject("products",articles);
        modelAndView.addObject("news",news);

        modelAndView.setViewName("luolePages/cn-complex/homePage");
        return modelAndView;
    }

    //英文版
    @RequestMapping("/englishIndex")
    public ModelAndView englishindex(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();

        List<imgEntity> imgUrls=frontWebService.getIndexImgs(request,englishHomePagePath);//首页轮播图片
        ArticleData indexCompanyIntroduce=frontWebService.getCompanyContent("英文");//首页公司简介


        Map<String,Object> mapproduct=new HashMap<String, Object>();
        mapproduct.put("keywords","英文");
        mapproduct.put("categoryid",productscategoryid);
        List<Article> articles=frontWebService.getSmallArticles(mapproduct);//首页产品中心图片
        List<Article> TSUNTIENproducts=frontWebService.TSUNTIENproducts(mapproduct);//TSUNTIEN产品系列
        /*List<imgEntity> products=frontWebService.getProuctsImg(request,productCenterPath);*/

        Map<String,Object> map=new HashMap<String, Object>();
        String newscategoryid="bb415331f2c54121ab388a234e5792fb";//新闻中心栏目id
        String keywords="英文";
        int limit=3;
        map.put("categoryid",newscategoryid);
        map.put("keywords",keywords);
        map.put("limit",limit);
        List<Article> news=frontWebService.getNewsContent(map);//新闻列表

        modelAndView.addObject("indexImgs",imgUrls);
        modelAndView.addObject("indexCompanyIntroduce",indexCompanyIntroduce);
        modelAndView.addObject("TSUNTIENproducts",TSUNTIENproducts);
        modelAndView.addObject("products",articles);
        modelAndView.addObject("news",news);

        modelAndView.setViewName("luolePages/english/homePage");
        return modelAndView;
    }
}
