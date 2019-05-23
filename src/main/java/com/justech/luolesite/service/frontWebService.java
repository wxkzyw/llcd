package com.justech.luolesite.service;

import com.justech.luolesite.dao.frontWebDao;
import com.justech.luolesite.entity.fileEntity;
import com.justech.luolesite.entity.imgEntity;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.ArticleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: WangXiaoKun
 * @Date: 2019/4/18 14:46
 */
@Service
public class frontWebService {

	@Autowired
	private frontWebDao frontWebDao;

	//获得指定路径下所有图片名
	public List<imgEntity> getIndexImgs(HttpServletRequest request, String homePagePath) {
		List<imgEntity> list = new ArrayList<imgEntity>();
		String homePageImgsUrl = request.getSession().getServletContext().getRealPath(homePagePath);
		String imgurl = "";
		String imgSuffix = "";

		File file = new File(homePagePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		File[] imgs = file.listFiles();//获取所有子文件夹
		if (imgs.length > 0 && imgs != null) {
			for (File file_sec : imgs) {
				String fileName = file_sec.getName();
				if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".gif")) {
					imgEntity bean = new imgEntity();
					imgSuffix = fileName.substring(fileName.lastIndexOf("."));
					imgurl = fileName.substring(0, fileName.lastIndexOf("."));
					bean.setImgSuffix(imgSuffix);
					bean.setImgName(imgurl);
					list.add(bean);
				}
			}

		}
		return list;
	}

	//获得产品下所有图片名
	public List<imgEntity> getProductsImgs(HttpServletRequest request, String homePagePath) {
		List<imgEntity> list = new ArrayList<imgEntity>();
		String homePageImgsUrl = request.getSession().getServletContext().getRealPath(homePagePath);
		String imgurl = "";
		String imgSuffix = "";


		File file = new File(homePagePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		File[] imgs = file.listFiles();//获取所有子文件夹
		if (imgs.length > 0 && imgs != null) {
			imgEntity[] imgSort=new imgEntity[imgs.length];
			for (File file_sec : imgs) {
				String fileName = file_sec.getName();
				if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".gif")) {
						imgEntity bean = new imgEntity();
						imgSuffix = fileName.substring(fileName.lastIndexOf("."));
						imgurl = fileName.substring(0, fileName.lastIndexOf("."));
						bean.setImgSuffix(imgSuffix);
						bean.setImgName(imgurl);
					if (isContainNumber(fileName)){
						String imgNameNum=fileName.substring(fileName.lastIndexOf("-")+1,fileName.lastIndexOf("."));
						imgSort[Integer.parseInt(imgNameNum)-1]=bean;
					}
					else {
						list.add(bean);
					}
				}
			}
			//按数字排序
			if (list.size()==0){
				for (int i=0;i<imgSort.length;i++){
					list.add(imgSort[i]);
				}
			}
		}
		return list;
	}

	public static boolean isContainNumber(String company) {

		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(company);
		if (m.find()) {
			return true;
		}
		return false;
	}

	//获取指定文件下视频名
	public List<fileEntity> productVideo(HttpServletRequest request, String Path) {
		List<fileEntity> list = new ArrayList<fileEntity>();
		String fileUrl = request.getSession().getServletContext().getRealPath(Path);
		String fileName = "";
		String fileSuffix = "";

		File file = new File(Path);
		if (!file.exists()) {
			file.mkdirs();
		}
		File[] files = file.listFiles();
		if (files.length > 0 && files != null) {
			for (File file_sec : files) {
				String fileAllName = file_sec.getName();
				if (fileAllName.endsWith(".mp4") || fileAllName.endsWith(".avi") || fileAllName.endsWith(".mov")|| fileAllName.endsWith(".rmvb")) {
					fileEntity bean = new fileEntity();
					fileSuffix = fileAllName.substring(fileAllName.lastIndexOf("."));
					fileName = fileAllName.substring(0, fileAllName.lastIndexOf("."));
					bean.setFileSuffix(fileSuffix);
					bean.setFileName(fileName);
					list.add(bean);
				}
			}
		}
		return list;
	}

	//首页公司简介
	public ArticleData getCompanyContent(String keywords) {
		Map<String,Object> map=new HashMap<String, Object>();
		String companycategoryid = "1a43b5c257fa488cb96a748900da572c";//公司栏目id
		map.put("categoryid",companycategoryid);
		map.put("keywords",keywords);

		return frontWebDao.getCompanyContent(map);
	}

	//首页TSUNTIEN产品系列
	public List<Article> TSUNTIENproducts(Map<String, Object> map) {
		map.put("num",10);//首页展示数量
		return frontWebDao.getProducts(map);
	}

	//首页新闻中心
	public List<Article> getNewsContent(Map<String, Object> map) {
		List<Article> articles = frontWebDao.getNewsArticle(map);
		for (Article bean : articles) {
			bean.setArticleData(frontWebDao.getNewsArticleData(bean.getId()));
		}
		return articles;
	}

	//首页产品图片及关联产品文章id
	public List<imgEntity> getProuctsImg(HttpServletRequest request, String homePagePath) {
		List<imgEntity> list = getIndexImgs(request, homePagePath);
		for (imgEntity imgbean : list) {
			imgbean.setProductid(frontWebDao.getProductID(imgbean.getImgName() + imgbean.getImgSuffix()));
		}
		return list;
	}

	//新闻列表
	public List<Article> getLimitNewsContent(Map<String, Object> map) {
		List<Article> articles = frontWebDao.getLimitNewsArticle(map);
		if(articles.size()>0) {
			for (Article bean : articles) {
				bean.setArticleData(frontWebDao.getNewsArticleData(bean.getId()));
			}
		}
		return articles;
	}

	//获取指定版本及栏目的文章数
	public int getArticleCount(Map<String, Object> map) {
		return frontWebDao.getArticlesCount(map);
	}

	//获取指定文章详情
	public Article getOnlyArticle(String newsid) {
		Article article = frontWebDao.getOnlyArticel(newsid);
		article.setArticleData(frontWebDao.getNewsArticleData(newsid));
		return article;
	}

	//获取指定文章的上一篇
	public Article getPrevArtiles(Map<String, Object> map) {
		return frontWebDao.getPrevArticle(map);
	}

	//获取指定文章的下一篇
	public Article getNextArtiles(Map<String, Object> map) {
		return frontWebDao.getNextArticle(map);
	}

	//获取指定文章(大图)
	public List<Article> getArticles(Map<String, Object> map) {
		List<Article> articles = frontWebDao.getArticle(map);
		for (Article article : articles) {
			String imgName = article.getDescription().substring(0, article.getDescription().lastIndexOf("."));
			String imgSuffix = article.getDescription().substring(article.getDescription().lastIndexOf("."));
			article.setImgName(imgName);
		}
		return articles;
	}

	//获取指定文章(小图)
	public List<Article> getSmallArticles(Map<String, Object> map) {
		List<Article> articles = frontWebDao.getArticle(map);
		for (Article article : articles) {
			String imgName = article.getDescription().substring(0, article.getDescription().lastIndexOf("."));
			String imgSuffix = article.getDescription().substring(article.getDescription().lastIndexOf("."));
			String imgNewName = imgName + "-small";
			article.setDescription(imgNewName + imgSuffix);
			article.setImgName(imgName);
		}
		return articles;
	}

	//获取pdf下载列表
	public List<fileEntity> downloadProductpdf(HttpServletRequest request, String downloadPath) {
		List<fileEntity> list = new ArrayList<fileEntity>();
		String fileUrl = request.getSession().getServletContext().getRealPath(downloadPath);
		String fileName = "";
		String fileSuffix = "";

		File file = new File(downloadPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		File[] files = file.listFiles();
		if (files.length > 0 && files != null) {
			for (File file_sec : files) {
				String fileAllName = file_sec.getName();
				if (fileAllName.endsWith(".pdf")) {
					fileEntity bean = new fileEntity();
					fileSuffix = fileAllName.substring(fileAllName.lastIndexOf("."));
					fileName = fileAllName.substring(0, fileAllName.lastIndexOf("."));
					bean.setFileSuffix(fileSuffix);
					bean.setFileName(fileName);
					list.add(bean);
				}
			}
		}
		return list;
	}


	//下载文件(pdf格式)
	public void download(HttpServletResponse response, String downloadPath) {
		File file = new File(downloadPath);
		Date date=new Date();
		String fileNewName=date.getTime()+".pdf";
		if (file.exists()) {
			//清空reponse
			response.reset();
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename="+fileNewName);
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			byte[] bytes = null;

			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				bytes = new byte[bis.available()];

				OutputStream os = response.getOutputStream();
				int num = bis.read(bytes);
				os.write(bytes,	0, num);
				os.flush();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (bis!=null){
				try {
						bis.close();
					}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			 if (fis!=null){
				try {
						fis.close();
					}
				 catch (IOException e) {
					e.printStackTrace();
				}
		}
			}
		}
	}

	//读取非IOS访问的视频
	public void downloadFile(HttpServletResponse response, String filePath) {
		try {
			File file=new File(filePath);
			String filename=file.getName();
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(file));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			response.setContentType("video/mp4");
			/*response.setHeader("Content-disposition", "attachment;filename=" + filename);*/
			OutputStream ouputStream = response.getOutputStream();
			ouputStream.write(buffer);
			ouputStream.flush();
			ouputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//读取IOS设备上的视频
	public void sendVideo(HttpServletRequest request, HttpServletResponse response, File file, String fileName) throws FileNotFoundException, IOException {
		RandomAccessFile randomFile = new RandomAccessFile(file, "r");//只读模式
		long contentLength = randomFile.length();
		String range = request.getHeader("Range");
		int start = 0, end = 0;
		if(range != null && range.startsWith("bytes=")){
			String[] values = range.split("=")[1].split("-");
			start = Integer.parseInt(values[0]);
			if(values.length > 1){
				end = Integer.parseInt(values[1]);
			}
		}
		int requestSize = 0;
		if(end != 0 && end > start){
			requestSize = end - start + 1;
		} else {
			requestSize = Integer.MAX_VALUE;
		}

		byte[] buffer = new byte[4096];
		response.setContentType("video/mp4");
		response.setHeader("Accept-Ranges", "bytes");
		response.setHeader("ETag", fileName);
		response.setHeader("Last-Modified", new Date().toString());
		//第一次请求只返回content length来让客户端请求多次实际数据
		if(range == null){
			response.setHeader("Content-length", contentLength + "");
		}else{
			//以后的多次以断点续传的方式来返回视频数据
			response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);//206
			long requestStart = 0, requestEnd = 0;
			String[] ranges = range.split("=");
			if(ranges.length > 1){
				String[] rangeDatas = ranges[1].split("-");
				requestStart = Integer.parseInt(rangeDatas[0]);
				if(rangeDatas.length > 1){
					requestEnd = Integer.parseInt(rangeDatas[1]);
				}
			}
			long length = 0;
			if(requestEnd > 0){
				length = requestEnd - requestStart + 1;
				response.setHeader("Content-length", "" + length);
				response.setHeader("Content-Range", "bytes " + requestStart + "-" + requestEnd + "/" + contentLength);
			}else{
				length = contentLength - requestStart;
				response.setHeader("Content-length", "" + length);
				response.setHeader("Content-Range", "bytes "+ requestStart + "-" + (contentLength - 1) + "/" + contentLength);
			}
		}
		ServletOutputStream out = response.getOutputStream();
		int needSize = requestSize;
		randomFile.seek(start);
		while(needSize > 0){
			int len = randomFile.read(buffer);
			if(needSize < buffer.length){
				out.write(buffer, 0, needSize);
			} else {
				out.write(buffer, 0, len);
				if(len < buffer.length){
					break;
				}
			}
			needSize -= buffer.length;
		}
		randomFile.close();
		out.close();

	}

	/**
	 * 获取指定产品-产品简介
	 * @param productid
	 * @return
	 */
	public Article getProductArticle(String productid){
		ArticleData articleData=frontWebDao.getProductIntroduction(productid);
		Article article=frontWebDao.getOnlyArticel(articleData.getId());
		article.setArticleData(articleData);
		return article;
	}

	/**
	 * 获取指定产品-产品简介图
	 * @param article
	 * @param productIntroPath
	 * @param request
	 * @return
	 */
	public Article getProductIntroduction(Article article,String productIntroPath,HttpServletRequest request){
		List<imgEntity> imgs=getIndexImgs(request,productIntroPath);
		if (imgs.size()!=0) {
			article.setDescription(imgs.get(0).getImgName() + imgs.get(0).getImgSuffix());
			article.setImgName(imgs.get(0).getImgName());
		}
		return article;
	}

	/**
	 * 获取指定产品-技术参数
	 * @param productParameterPath
	 * @return
	 */
	public List<imgEntity> getProductParameter(String productParameterPath,HttpServletRequest request){
		 return getIndexImgs(request,productParameterPath);
	}

	/**
	 * 获取指定产品-产品案例图片
	 * @param productCasePath
	 * @param request
	 * @return
	 */
	public List<imgEntity> getProductCaseImg(String productCasePath,HttpServletRequest request){
		return getProductsImgs(request,productCasePath);
	}

	/**
	 * 获取指定产品-产品案例视频
	 * @param productCasePath
	 * @param request
	 * @return
	 */
	public List<fileEntity> getProductCaseVideo(String productCasePath,HttpServletRequest request){
		return productVideo(request,productCasePath);
	}

	/**
	 * 获取所有产品应用类别名
	 * @param applicaitonPath
	 * @param request
	 * @return
	 */
	public List<String> getAllApplicaitonName(String applicaitonPath,HttpServletRequest request){
		List<String> list=new ArrayList<String>();
		String applicationDiskPath=request.getSession().getServletContext().getRealPath(applicaitonPath);//产品应用根目录路径
		File file=new File(applicaitonPath);
		if (!file.exists()){
		file.mkdirs();
		}
		File[] files=file.listFiles();
		if (files.length>0&&files!=null){
			for (File bean:files) {
				list.add(bean.getName());
			}
		}
		return list;
	}

	/**
	 * 获取产品简介-其余版本ID
	 * @return
	 */
	public Map<String,Object> introductionList(String productid){
		ArticleData articleData=frontWebDao.getProductIntroduction(productid);
		Map<String,Object> map=new HashMap<String, Object>();
		String[] relations=articleData.getRelation().split(",");
		for (String relation:relations) {
			if (!relation.equals(productid)){
				Article article=frontWebDao.getOnlyArticel(relation);
				ArticleData data=frontWebDao.getNewsArticleData(relation);
				String[] datas=data.getRelation().split(",");
				if (article.getKeywords().equals("简体")){
					map.put("jt",datas[0]);//获取对应产品id
				}else if (article.getKeywords().equals("繁体")){
					map.put("ft",datas[0]);
				}else if (article.getKeywords().equals("英文")){
					map.put("yw",datas[0]);
				}
			}
		}

		return map;
	}
}
