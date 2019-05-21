package com.justech.luolesite.controller;

import com.justech.luolesite.entity.fileEntity;
import com.justech.luolesite.service.frontWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: WangXiaoKun
 * @Date: 2019/4/25 13:35
 * 下载Controller
 */
@Controller
@RequestMapping("${frontPath}")
public class downloadController {

	@Autowired
	private frontWebService frontWebService;
	/**
	 * 简体版 下载-产品目录列表
	 * @return
	 */
	@RequestMapping("/cnSimpleDirectoryList")
	public ModelAndView downloadProductsDirectoryList(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
        String directoryPath="/userfiles/1/files/download/cn-simple/productCatalog/";
		List<fileEntity> list=frontWebService.downloadProductpdf(request,directoryPath);
		modelAndView.addObject("directories",list);
		modelAndView.setViewName("luolePages/cn-simple/download-productsDirectory");
		return modelAndView;
	}

	/**
	 * 简体版 下载-保养手册列表
	 * @return
	 */
	@RequestMapping("/cnSimpleManualList")
	public ModelAndView downloadProductsManualList(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		String directoryPath="/userfiles/1/files/download/cn-simple/maintenanceManual/";
		List<fileEntity> list=frontWebService.downloadProductpdf(request,directoryPath);
		modelAndView.addObject("directories",list);
		modelAndView.setViewName("luolePages/cn-simple/download-productsManual");
		return modelAndView;
	}

	@RequestMapping("/downloadProductsDirectory/{version}/{fileName}")
	public void downliadProductsDirectory(@PathVariable("version") String version,@PathVariable("fileName") String fileName,HttpServletRequest request,HttpServletResponse response){
		String path="/userfiles/1/files/download/"+version+"/productCatalog/";
		String directoryPath=request.getSession().getServletContext().getRealPath(path);
		frontWebService.download(response,directoryPath+fileName+".pdf");
	}

	@RequestMapping("/downloadProductsManual/{version}/{fileName}")
	public void downliadProductsManual(@PathVariable("version") String version,@PathVariable("fileName") String fileName,HttpServletRequest request,HttpServletResponse response){
		String path="/userfiles/1/files/download/"+version+"/maintenanceManual/";
		String directoryPath=request.getSession().getServletContext().getRealPath(path);
		frontWebService.download(response,directoryPath+fileName+".pdf");
	}

	/**
	 * 繁体版 下载-产品目录列表
	 * @return
	 */
	@RequestMapping("/cnComplexDirectoryList")
	public ModelAndView downloadComplexProductsDirectoryList(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		String directoryPath="/userfiles/1/files/download/cn-complex/productCatalog/";
		List<fileEntity> list=frontWebService.downloadProductpdf(request,directoryPath);
		modelAndView.addObject("directories",list);
		modelAndView.setViewName("luolePages/cn-complex/download-productsDirectory");
		return modelAndView;
	}

	/**
	 * 繁体版 下载-保养手册列表
	 * @return
	 */
	@RequestMapping("/cnComplexManualList")
	public ModelAndView downloadComplexProductsManualList(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		String directoryPath="/userfiles/1/files/download/cn-complex/maintenanceManual/";
		List<fileEntity> list=frontWebService.downloadProductpdf(request,directoryPath);
		modelAndView.addObject("directories",list);
		modelAndView.setViewName("luolePages/cn-complex/download-productsManual");
		return modelAndView;
	}

	/**
	 * 英文版 下载-产品目录列表
	 * @return
	 */
	@RequestMapping("/englishDirectoryList")
	public ModelAndView englishDirectoryList(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		String directoryPath="/userfiles/1/files/download/english/productCatalog/";
		List<fileEntity> list=frontWebService.downloadProductpdf(request,directoryPath);
		modelAndView.addObject("directories",list);
		modelAndView.setViewName("luolePages/english/download-productsDirectory");
		return modelAndView;
	}

	/**
	 * 英文版 下载-保养手册列表
	 * @return
	 */
	@RequestMapping("/englishManualList")
	public ModelAndView englishManualList(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		String directoryPath="/userfiles/1/files/download/english/maintenanceManual/";
		List<fileEntity> list=frontWebService.downloadProductpdf(request,directoryPath);
		modelAndView.addObject("directories",list);
		modelAndView.setViewName("luolePages/english/download-productsManual");
		return modelAndView;
	}

	/**
	 * 首页-视频
	 * @param response
	 * @param filePath
	 */
	@RequestMapping("/downFile/{filePath}")
	public void downloadFile(HttpServletRequest request,HttpServletResponse response,@PathVariable String filePath){
		filePath="/userfiles/1/files/video/"+filePath+".mp4";
		File file=new File(filePath);
		String userAgent=request.getHeader("User-Agent");
		if (userAgent.contains("iPhone")||userAgent.contains("iPod")||userAgent.contains("iPad")){
			try {
				frontWebService.sendVideo(request,response,file,file.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			frontWebService.downloadFile(response,filePath);
		}
	}
}
