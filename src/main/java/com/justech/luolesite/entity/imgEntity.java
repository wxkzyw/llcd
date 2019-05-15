package com.justech.luolesite.entity;

/**
 * @Author: WangXiaoKun
 * @Date: 2019/4/17 17:12
 * 首页图片类
 */

public class imgEntity {

    private int id;
    private String src;//图片地址
    private String imgName;//图片名称
    private String imgSuffix;//图片后缀名
    private String productid;//关联产品cms_article id

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgSuffix() {
        return imgSuffix;
    }

    public void setImgSuffix(String imgSuffix) {
        this.imgSuffix = imgSuffix;
    }
}
