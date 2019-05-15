package com.justech.luolesite.controller;

import com.justech.luolesite.service.frontWebService;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: WangXiaoKun
 * @Date: 2019/4/22 17:43
 * 新闻Controller
 */
@Controller
@RequestMapping("${frontPath}")
public class newsController {

    @Autowired
    private frontWebService frontWebService;

	private String newscategoryid="bb415331f2c54121ab388a234e5792fb";//新闻中心栏目id

    //简体版 新闻列表
    @RequestMapping("/cnSimpleNewsList")
    public ModelAndView newslist(String currentPageStr){
        ModelAndView modelAndView=new ModelAndView();

		int start=0;//页面查询起点
		int pageone=1;
		int pagetwo=2;
		int pagethree=3;
		int pagefour=4;
		int pagefive=5;
		int currentPage=1;//默认当前页
		if (currentPageStr!=null){
			currentPage=Integer.parseInt(currentPageStr);
		}

        Map<String,Object> map=new HashMap<String, Object>();
        String keywords="简体";
        int pageSize=5;//新闻列表展示数量限制
        int totalPage=0;//总页数
		map.put("categoryid",newscategoryid);
		map.put("keywords",keywords);
        int newsCount=frontWebService.getArticleCount(map);
        if (newsCount>0) {
			if (newsCount % pageSize == 0) {
				totalPage = newsCount / pageSize;
			} else {
				totalPage = newsCount / pageSize + 1;
			}
		}else {
			totalPage=1;
		}

		if (currentPage>1){
			modelAndView.addObject("prev",currentPage-1);//上一页
		}
		if (currentPage<totalPage){
			modelAndView.addObject("next",currentPage+1);//下一页
		}

		//获取指定页
		if (totalPage>0){
              if (totalPage<=5){
				  modelAndView.addObject("pageone",pageone);
				  modelAndView.addObject("pagetwo",pagetwo);
				  modelAndView.addObject("pagethree",pagethree);
				  modelAndView.addObject("pagefour",pagefour);
				  modelAndView.addObject("pagefive",pagefive);
			  }else if(totalPage>5){
              	if(currentPage<3){
					modelAndView.addObject("pageone",pageone);
					modelAndView.addObject("pagetwo",pagetwo);
					modelAndView.addObject("pagethree",pagethree);
					modelAndView.addObject("pagefour",pagefour);
					modelAndView.addObject("pagefive",pagefive);
				}else if (totalPage-currentPage==1){
					modelAndView.addObject("pageone",currentPage-3);
					modelAndView.addObject("pagetwo",currentPage-2);
					modelAndView.addObject("pagethree",currentPage-1);
					modelAndView.addObject("pagefour",currentPage);
					modelAndView.addObject("pagefive",currentPage+1);
				}else if (totalPage==currentPage){
					modelAndView.addObject("pageone",currentPage-4);
					modelAndView.addObject("pagetwo",currentPage-3);
					modelAndView.addObject("pagethree",currentPage-2);
					modelAndView.addObject("pagefour",currentPage-1);
					modelAndView.addObject("pagefive",currentPage);
				}else {
					modelAndView.addObject("pageone",currentPage-2);
					modelAndView.addObject("pagetwo",currentPage-1);
					modelAndView.addObject("pagethree",currentPage);
					modelAndView.addObject("pagefour",currentPage+1);
					modelAndView.addObject("pagefive",currentPage+2);
				}
			  }
		}

		start=pageSize*(Integer.valueOf(currentPage)-1);
        map.put("start",start);
        map.put("pageSize",pageSize);
        List<Article> news=frontWebService.getLimitNewsContent(map);//新闻列表

		modelAndView.addObject("newsCount",newsCount);
		modelAndView.addObject("currentPage",currentPage);
		modelAndView.addObject("totalPage",totalPage);
        modelAndView.addObject("newsList",news);
        modelAndView.setViewName("luolePages/cn-simple/news-list");
        return modelAndView;
    }

    //简体版新闻详情
    @RequestMapping("/cnSimpleNewsDetails/{newsid}")
    public ModelAndView newsDetails(@PathVariable("newsid") String newsid){
    	ModelAndView modelAndView=new ModelAndView();
        Article article=frontWebService.getOnlyArticle(newsid);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("keywords","简体");
		map.put("categoryid",newscategoryid);
		map.put("newsid",newsid);
        Article prev=frontWebService.getPrevArtiles(map);
        Article next=frontWebService.getNextArtiles(map);

		String[] ids=article.getArticleData().getRelation().split(",");
		for (String id:ids) {
			if (id!=""&&id!=null) {
				Article bean = frontWebService.getOnlyArticle(id);
				if (bean.getKeywords().equals("繁体")) {
					modelAndView.addObject("complexArticleID", bean.getId());
				}
				if (bean.getKeywords().equals("英文")) {
					modelAndView.addObject("englishArticleID", bean.getId());
				}
			}
		}

		modelAndView.addObject("article",article);
		modelAndView.addObject("prev",prev);
		modelAndView.addObject("next",next);
    	modelAndView.setViewName("luolePages/cn-simple/news-details");
    	return modelAndView;
	}


	//繁体版 新闻列表
	@RequestMapping("/cnComplexNewsList")
	public ModelAndView complexnewslist(String currentPageStr){
		ModelAndView modelAndView=new ModelAndView();

		int start=0;//页面查询起点
		int pageone=1;
		int pagetwo=2;
		int pagethree=3;
		int pagefour=4;
		int pagefive=5;
		int currentPage=1;//默认当前页
		if (currentPageStr!=null){
			currentPage=Integer.parseInt(currentPageStr);
		}

		Map<String,Object> map=new HashMap<String, Object>();
		String keywords="繁体";
		int pageSize=5;//新闻列表展示数量限制
		int totalPage=0;//总页数
		map.put("categoryid",newscategoryid);
		map.put("keywords",keywords);
		int newsCount=frontWebService.getArticleCount(map);
		if (newsCount>0) {
			if (newsCount % pageSize == 0) {
				totalPage = newsCount / pageSize;
			} else {
				totalPage = newsCount / pageSize + 1;
			}
		}else {
			totalPage=1;
		}

		if (currentPage>1){
			modelAndView.addObject("prev",currentPage-1);//上一页
		}
		if (currentPage<totalPage){
			modelAndView.addObject("next",currentPage+1);//下一页
		}

		//获取指定页
		if (totalPage>0){
			if (totalPage<=5){
				modelAndView.addObject("pageone",pageone);
				modelAndView.addObject("pagetwo",pagetwo);
				modelAndView.addObject("pagethree",pagethree);
				modelAndView.addObject("pagefour",pagefour);
				modelAndView.addObject("pagefive",pagefive);
			}else if(totalPage>5){
				if(currentPage<3){
					modelAndView.addObject("pageone",pageone);
					modelAndView.addObject("pagetwo",pagetwo);
					modelAndView.addObject("pagethree",pagethree);
					modelAndView.addObject("pagefour",pagefour);
					modelAndView.addObject("pagefive",pagefive);
				}else if (totalPage-currentPage==1){
					modelAndView.addObject("pageone",currentPage-3);
					modelAndView.addObject("pagetwo",currentPage-2);
					modelAndView.addObject("pagethree",currentPage-1);
					modelAndView.addObject("pagefour",currentPage);
					modelAndView.addObject("pagefive",currentPage+1);
				}else if (totalPage==currentPage){
					modelAndView.addObject("pageone",currentPage-4);
					modelAndView.addObject("pagetwo",currentPage-3);
					modelAndView.addObject("pagethree",currentPage-2);
					modelAndView.addObject("pagefour",currentPage-1);
					modelAndView.addObject("pagefive",currentPage);
				}else {
					modelAndView.addObject("pageone",currentPage-2);
					modelAndView.addObject("pagetwo",currentPage-1);
					modelAndView.addObject("pagethree",currentPage);
					modelAndView.addObject("pagefour",currentPage+1);
					modelAndView.addObject("pagefive",currentPage+2);
				}
			}
		}

		start=pageSize*(Integer.valueOf(currentPage)-1);
		map.put("start",start);
		map.put("pageSize",pageSize);
		List<Article> news=frontWebService.getLimitNewsContent(map);//新闻列表

		modelAndView.addObject("newsCount",newsCount);
		modelAndView.addObject("currentPage",currentPage);
		modelAndView.addObject("totalPage",totalPage);
		modelAndView.addObject("newsList",news);
		modelAndView.setViewName("luolePages/cn-complex/news-list");
		return modelAndView;
	}

	//繁体版新闻详情
	@RequestMapping("/cnComplexNewsDetails/{newsid}")
	public ModelAndView complexnewsdetails(@PathVariable("newsid") String newsid){
		ModelAndView modelAndView=new ModelAndView();
		Article article=frontWebService.getOnlyArticle(newsid);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("keywords","繁体");
		map.put("categoryid",newscategoryid);
		map.put("newsid",newsid);
		Article prev=frontWebService.getPrevArtiles(map);
		Article next=frontWebService.getNextArtiles(map);

		String[] ids=article.getArticleData().getRelation().split(",");
		for (String id:ids) {
			if (id!=""&&id!=null){
			Article bean=frontWebService.getOnlyArticle(id);
			if (bean.getKeywords().equals("简体")){
				modelAndView.addObject("simpleArticleID",bean.getId());
			}
			if (bean.getKeywords().equals("英文")){
				modelAndView.addObject("englishArticleID",bean.getId());
			}
			}
		}

		modelAndView.addObject("article",article);
		modelAndView.addObject("prev",prev);
		modelAndView.addObject("next",next);
		modelAndView.setViewName("luolePages/cn-complex/news-details");
		return modelAndView;
	}

	//英文版 新闻列表
	@RequestMapping("/englishNewsList")
	public ModelAndView englishNewsList(String currentPageStr){
		ModelAndView modelAndView=new ModelAndView();

		int start=0;//页面查询起点
		int pageone=1;
		int pagetwo=2;
		int pagethree=3;
		int pagefour=4;
		int pagefive=5;
		int currentPage=1;//默认当前页
		if (currentPageStr!=null){
			currentPage=Integer.parseInt(currentPageStr);
		}

		Map<String,Object> map=new HashMap<String, Object>();
		String keywords="英文";
		int pageSize=5;//新闻列表展示数量限制
		int totalPage=0;//总页数
		map.put("categoryid",newscategoryid);
		map.put("keywords",keywords);
		int newsCount=frontWebService.getArticleCount(map);
		if (newsCount>0) {
			if (newsCount % pageSize == 0) {
				totalPage = newsCount / pageSize;
			} else {
				totalPage = newsCount / pageSize + 1;
			}
		}else {
			totalPage=1;
		}

		if (currentPage>1){
			modelAndView.addObject("prev",currentPage-1);//上一页
		}
		if (currentPage<totalPage){
			modelAndView.addObject("next",currentPage+1);//下一页
		}

		//获取指定页
		if (totalPage>0){
			if (totalPage<=5){
				modelAndView.addObject("pageone",pageone);
				modelAndView.addObject("pagetwo",pagetwo);
				modelAndView.addObject("pagethree",pagethree);
				modelAndView.addObject("pagefour",pagefour);
				modelAndView.addObject("pagefive",pagefive);
			}else if(totalPage>5){
				if(currentPage<3){
					modelAndView.addObject("pageone",pageone);
					modelAndView.addObject("pagetwo",pagetwo);
					modelAndView.addObject("pagethree",pagethree);
					modelAndView.addObject("pagefour",pagefour);
					modelAndView.addObject("pagefive",pagefive);
				}else if (totalPage-currentPage==1){
					modelAndView.addObject("pageone",currentPage-3);
					modelAndView.addObject("pagetwo",currentPage-2);
					modelAndView.addObject("pagethree",currentPage-1);
					modelAndView.addObject("pagefour",currentPage);
					modelAndView.addObject("pagefive",currentPage+1);
				}else if (totalPage==currentPage){
					modelAndView.addObject("pageone",currentPage-4);
					modelAndView.addObject("pagetwo",currentPage-3);
					modelAndView.addObject("pagethree",currentPage-2);
					modelAndView.addObject("pagefour",currentPage-1);
					modelAndView.addObject("pagefive",currentPage);
				}else {
					modelAndView.addObject("pageone",currentPage-2);
					modelAndView.addObject("pagetwo",currentPage-1);
					modelAndView.addObject("pagethree",currentPage);
					modelAndView.addObject("pagefour",currentPage+1);
					modelAndView.addObject("pagefive",currentPage+2);
				}
			}
		}

		start=pageSize*(Integer.valueOf(currentPage)-1);
		map.put("start",start);
		map.put("pageSize",pageSize);
		List<Article> news=frontWebService.getLimitNewsContent(map);//新闻列表

		modelAndView.addObject("newsCount",newsCount);
		modelAndView.addObject("currentPage",currentPage);
		modelAndView.addObject("totalPage",totalPage);
		modelAndView.addObject("newsList",news);
		modelAndView.setViewName("luolePages/english/news-list");
		return modelAndView;
	}

	//英文版新闻详情
	@RequestMapping("/englishNewsDetails/{newsid}")
	public ModelAndView englishNewsDetails(@PathVariable("newsid") String newsid){
		ModelAndView modelAndView=new ModelAndView();
		Article article=frontWebService.getOnlyArticle(newsid);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("keywords","英文");
		map.put("categoryid",newscategoryid);
		map.put("newsid",newsid);
		Article prev=frontWebService.getPrevArtiles(map);
		Article next=frontWebService.getNextArtiles(map);

		String[] ids=article.getArticleData().getRelation().split(",");
		for (String id:ids) {
			if (id!=""&&id!=null){
				Article bean=frontWebService.getOnlyArticle(id);
				if (bean.getKeywords().equals("简体")){
					modelAndView.addObject("simpleArticleID",bean.getId());
				}
				if (bean.getKeywords().equals("繁体")){
					modelAndView.addObject("complexArticleID",bean.getId());
				}
			}
		}

		modelAndView.addObject("article",article);
		modelAndView.addObject("prev",prev);
		modelAndView.addObject("next",next);
		modelAndView.setViewName("luolePages/english/news-details");
		return modelAndView;
	}
}
