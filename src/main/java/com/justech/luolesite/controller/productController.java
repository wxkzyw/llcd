package com.justech.luolesite.controller;

import com.justech.luolesite.entity.fileEntity;
import com.justech.luolesite.entity.imgEntity;
import com.justech.luolesite.entity.productApplication;
import com.justech.luolesite.service.frontWebService;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: WangXiaoKun
 * @Date: 2019/4/24 12:20
 * 产品Controller
 */
@Controller
@RequestMapping("${frontPath}")
public class productController {

	@Autowired
	private frontWebService frontWebService;

	private String productscategoryid="e258a4ba24a74581bb799f53df5e4b54";//产品中心栏目id

	private static final String seriesSimpleFrontPath="/userfiles/1/files/productSeries/cn-simple/";//简体版-产品系列前部文件路径
	private static final String seriesComplexFrontPath="/userfiles/1/files/productSeries/cn-complex/";//繁体版-产品系列前部文件路径
	private static final String seriesEnglishFrontPath="/userfiles/1/files/productSeries/english/";//英文版-产品系列前部文件路径

	private static final String seriesProductIntroPath="/images/productIntroduce/";//产品系列产品简介文件路径
	private static final String seriesProductParameterPath="/images/productParameter/";//产品系列产品参数文件路径
	private static final String seriesProductCaseImgPath="/images/productCase/";//产品系列案例图片路径
	private static final String seriesProductCaseVideoPath="/video/";//产品系列案例视频路径

	private static final String seriesSimpleProductApplicationPath="/userfiles/1/files/productApplication/cn-simple/";//简体版-产品应用根目录路径
	private static final String seriesComplexProductApplicationPath="/userfiles/1/files/productApplication/cn-complex/";//繁体版-产品应用根目录路径
	private static final String seriesEnglishProductApplicationPath="/userfiles/1/files/productApplication/english/";//英文版-产品应用根目录路径

	private static final String imagePath="/images/";//产品应用-图片目录
	private static final String videoPath="/video/";//产品应用-视频目录


	/**
	 * 简体版 产品中心列表
	 * @return
	 */
	@RequestMapping("/cnSimpleProductList")
	public ModelAndView productList(){
		ModelAndView modelAndView=new ModelAndView();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("keywords","简体");
		map.put("categoryid",productscategoryid);
		List<Article> articles=frontWebService.getArticles(map);
		modelAndView.addObject("products",articles);
		modelAndView.setViewName("luolePages/cn-simple/product-list");
		return modelAndView;
	}

	//简体版 产品详情页
	@RequestMapping("/cnSimpleProductDetails/{productid}")
	public ModelAndView productDetails(@PathVariable("productid") String productid, HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Article article=frontWebService.getProductArticle(productid);
		String seriesName=article.getDescription().substring(0,article.getDescription().lastIndexOf("."));//产品系列名

		String introPath=seriesSimpleFrontPath+seriesName+seriesProductIntroPath;//产品简介图路径
		String parameterPath=seriesSimpleFrontPath+seriesName+seriesProductParameterPath;//产品参数图路径
		String caseImgPath=seriesSimpleFrontPath+seriesName+seriesProductCaseImgPath;//产品案例图
		String caseVideoPath=seriesSimpleFrontPath+seriesName+seriesProductCaseVideoPath;//产品案例图

		//类别名包含一个&
		if (seriesName.contains("&amp;")){
			String newSeriesName=seriesName.substring(0,seriesName.lastIndexOf(";")+1)+"amp;"+seriesName.substring(seriesName.lastIndexOf(";")+1);
			modelAndView.addObject("newSeriesName",newSeriesName);
		}

		Map<String,Object> productIntros=frontWebService.introductionList(productid);
		modelAndView.addObject("productIntros",productIntros);

		modelAndView.addObject("seriesName",seriesName);
		modelAndView.addObject("productid",productid);
		modelAndView.addObject("introduction",frontWebService.getProductIntroduction(article,introPath,request));
		modelAndView.addObject("parameter",frontWebService.getProductParameter(parameterPath,request));
		modelAndView.addObject("casesImgs",frontWebService.getProductCaseImg(caseImgPath,request));//产品案例-图片
		modelAndView.addObject("casesVideos",frontWebService.getProductCaseVideo(caseVideoPath,request));//产品案例-视频

		modelAndView.setViewName("luolePages/cn-simple/product-details");
		return modelAndView;
	}

	/**
	 * 简体版 产品应用页
	 * @param request
	 * @return
	 */
	@RequestMapping("/cnSimpleProductApplicaiton")
	public ModelAndView productAppplication(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		List<productApplication> productApplications=new ArrayList<productApplication>();
        List<String> catagoryNames=frontWebService.getAllApplicaitonName(seriesSimpleProductApplicationPath,request);//产品应用类别名

		for (String bean:catagoryNames) {
			productApplication application=new productApplication();

			//类别名包含一个&
			if (bean.contains("&amp;")){
				String newSeriesName=bean.substring(0,bean.lastIndexOf(";")+1)+"amp;"+bean.substring(bean.lastIndexOf(";")+1);
				application.setCatagoryName(newSeriesName);
			}else {
				application.setCatagoryName(bean);
			}

			String imgpath=seriesSimpleProductApplicationPath+bean+imagePath;
			List<imgEntity> imgs=frontWebService.getProductsImgs(request,imgpath);
			application.setImgs(imgs);

			String videopath=seriesSimpleProductApplicationPath+bean+videoPath;
			List<fileEntity> videos=frontWebService.productVideo(request,videopath);
			application.setVideos(videos);

			productApplications.add(application);
		}

		modelAndView.addObject("productApplications",productApplications);
		modelAndView.addObject("catagoryNames",catagoryNames);
		modelAndView.setViewName("luolePages/cn-simple/product-application");
		return modelAndView;
	}

	/**
	 * 繁体版 产品中心列表
	 * @return
	 */
	@RequestMapping("/cnComplexProductList")
	public ModelAndView complexproductlist(){
		ModelAndView modelAndView=new ModelAndView();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("keywords","繁体");
		map.put("categoryid",productscategoryid);
		List<Article> articles=frontWebService.getArticles(map);
		modelAndView.addObject("products",articles);
		modelAndView.setViewName("luolePages/cn-complex/product-list");
		return modelAndView;
	}

	//繁体版 产品详情页
	@RequestMapping("/cnComplexProductDetails/{productid}")
	public ModelAndView complexproductdetails(@PathVariable("productid") String productid, HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Article article=frontWebService.getProductArticle(productid);
		String seriesName=article.getDescription().substring(0,article.getDescription().lastIndexOf("."));//产品系列名

		String introPath=seriesComplexFrontPath+seriesName+seriesProductIntroPath;//产品简介图路径
		String parameterPath=seriesComplexFrontPath+seriesName+seriesProductParameterPath;//产品参数图路径
		String caseImgPath=seriesComplexFrontPath+seriesName+seriesProductCaseImgPath;//产品案例图
		String caseVideoPath=seriesComplexFrontPath+seriesName+seriesProductCaseVideoPath;//产品案例图

		//类别名包含一个&
		if (seriesName.contains("&amp;")){
			String newSeriesName=seriesName.substring(0,seriesName.lastIndexOf(";")+1)+"amp;"+seriesName.substring(seriesName.lastIndexOf(";")+1);
			modelAndView.addObject("newSeriesName",newSeriesName);
		}

		Map<String,Object> productIntros=frontWebService.introductionList(productid);
		modelAndView.addObject("productIntros",productIntros);

		modelAndView.addObject("seriesName",seriesName);
		modelAndView.addObject("productid",productid);
		modelAndView.addObject("introduction",frontWebService.getProductIntroduction(article,introPath,request));
		modelAndView.addObject("parameter",frontWebService.getProductParameter(parameterPath,request));
		modelAndView.addObject("casesImgs",frontWebService.getProductCaseImg(caseImgPath,request));//产品案例-图片
		modelAndView.addObject("casesVideos",frontWebService.getProductCaseVideo(caseVideoPath,request));//产品案例-视频

		modelAndView.setViewName("luolePages/cn-complex/product-details");
		return modelAndView;
	}

	/**
	 * 繁体版 产品应用页
	 * @param request
	 * @return
	 */
	@RequestMapping("/cnComplexProductApplicaiton")
	public ModelAndView complexproductAppplication(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		List<productApplication> productApplications=new ArrayList<productApplication>();
		List<String> catagoryNames=frontWebService.getAllApplicaitonName(seriesComplexProductApplicationPath,request);//产品应用类别名

		for (String bean:catagoryNames) {
			productApplication application=new productApplication();

			//类别名包含一个&
			if (bean.contains("&amp;")){
				String newSeriesName=bean.substring(0,bean.lastIndexOf(";")+1)+"amp;"+bean.substring(bean.lastIndexOf(";")+1);
				application.setCatagoryName(newSeriesName);
			}else {
				application.setCatagoryName(bean);
			}

			String imgpath=seriesComplexProductApplicationPath+bean+imagePath;
			List<imgEntity> imgs=frontWebService.getProductsImgs(request,imgpath);
			application.setImgs(imgs);

			String videopath=seriesComplexProductApplicationPath+bean+videoPath;
			List<fileEntity> videos=frontWebService.productVideo(request,videopath);
			application.setVideos(videos);

			productApplications.add(application);
		}

		modelAndView.addObject("productApplications",productApplications);
		modelAndView.addObject("catagoryNames",catagoryNames);
		modelAndView.setViewName("luolePages/cn-complex/product-application");
		return modelAndView;
	}

	/**
	 * 英文版 产品中心列表
	 * @return
	 */
	@RequestMapping("/englishProductList")
	public ModelAndView englishProductList(){
		ModelAndView modelAndView=new ModelAndView();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("keywords","英文");
		map.put("categoryid",productscategoryid);
		List<Article> articles=frontWebService.getArticles(map);
		modelAndView.addObject("products",articles);
		modelAndView.setViewName("luolePages/english/product-list");
		return modelAndView;
	}

	//英文版 产品详情页
	@RequestMapping("/englishProductDetails/{productid}")
	public ModelAndView englishproductDetails(@PathVariable("productid") String productid, HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Article article=frontWebService.getProductArticle(productid);
		String seriesName=article.getDescription().substring(0,article.getDescription().lastIndexOf("."));//产品系列名

		String introPath=seriesEnglishFrontPath+seriesName+seriesProductIntroPath;//产品简介图路径
		String parameterPath=seriesEnglishFrontPath+seriesName+seriesProductParameterPath;//产品参数图路径
		String caseImgPath=seriesEnglishFrontPath+seriesName+seriesProductCaseImgPath;//产品案例图
		String caseVideoPath=seriesEnglishFrontPath+seriesName+seriesProductCaseVideoPath;//产品案例图

		//类别名包含一个&
		if (seriesName.contains("&amp;")){
			String newSeriesName=seriesName.substring(0,seriesName.lastIndexOf(";")+1)+"amp;"+seriesName.substring(seriesName.lastIndexOf(";")+1);
			modelAndView.addObject("newSeriesName",newSeriesName);
		}

		Map<String,Object> productIntros=frontWebService.introductionList(productid);
		modelAndView.addObject("productIntros",productIntros);

		modelAndView.addObject("seriesName",seriesName);
		modelAndView.addObject("productid",productid);
		modelAndView.addObject("introduction",frontWebService.getProductIntroduction(article,introPath,request));
		modelAndView.addObject("parameter",frontWebService.getProductParameter(parameterPath,request));
		modelAndView.addObject("casesImgs",frontWebService.getProductCaseImg(caseImgPath,request));//产品案例-图片
		modelAndView.addObject("casesVideos",frontWebService.getProductCaseVideo(caseVideoPath,request));//产品案例-视频

		modelAndView.setViewName("luolePages/english/product-details");
		return modelAndView;
	}


	/**
	 * 英文版 产品应用页
	 * @param request
	 * @return
	 */
	@RequestMapping("/englishProductApplicaiton")
	public ModelAndView englishProductApplicaiton(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		List<productApplication> productApplications=new ArrayList<productApplication>();
		List<String> catagoryNames=frontWebService.getAllApplicaitonName(seriesEnglishProductApplicationPath,request);//产品应用类别名

		for (String bean:catagoryNames) {
			productApplication application=new productApplication();

			//类别名包含一个&
			if (bean.contains("&amp;")){
				String newSeriesName=bean.substring(0,bean.lastIndexOf(";")+1)+"amp;"+bean.substring(bean.lastIndexOf(";")+1);
				application.setCatagoryName(newSeriesName);
			}else {
				application.setCatagoryName(bean);
			}

			String imgpath=seriesEnglishProductApplicationPath+bean+imagePath;
			List<imgEntity> imgs=frontWebService.getProductsImgs(request,imgpath);
			application.setImgs(imgs);

			String videopath=seriesEnglishProductApplicationPath+bean+videoPath;
			List<fileEntity> videos=frontWebService.productVideo(request,videopath);
			application.setVideos(videos);

			productApplications.add(application);
		}

		modelAndView.addObject("productApplications",productApplications);
		modelAndView.addObject("catagoryNames",catagoryNames);
		modelAndView.setViewName("luolePages/english/product-application");
		return modelAndView;
	}
}
