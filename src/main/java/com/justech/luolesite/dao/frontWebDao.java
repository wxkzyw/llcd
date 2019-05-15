package com.justech.luolesite.dao;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.ArticleData;

import java.util.List;
import java.util.Map;

/**
 * @Author: WangXiaoKun
 * @Date: 2019/4/19 10:51
 */
@MyBatisDao
public interface frontWebDao {
   public ArticleData getCompanyContent(Map<String,Object> map);

    public List<Article> getProducts(Map<String,Object> map);

    public List<Article> getNewsArticle(Map<String,Object> map);

    public ArticleData getNewsArticleData(String newsid);

    public String getProductID(String imgid);

    public List<Article> getLimitNewsArticle(Map<String,Object> map);

    public int getArticlesCount(Map<String,Object> map);

    public Article getOnlyArticel(String newsid);

    public Article getPrevArticle(Map<String,Object> map);

	public Article getNextArticle(Map<String,Object> map);

	public List<Article> getArticle(Map<String,Object> map);

	public ArticleData getProductIntroduction(String productid);

}
