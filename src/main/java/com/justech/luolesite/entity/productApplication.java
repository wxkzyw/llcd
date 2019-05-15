package com.justech.luolesite.entity;

import java.util.List;

/**
 * @Author: WangXiaoKun
 * @Date: 2019/4/26 17:40
 * 产品应用类
 */
public class productApplication {

	private String catagoryName;//类别名 主键
	private List<imgEntity> imgs;
	private List<fileEntity> videos;

	public String getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	public List<imgEntity> getImgs() {
		return imgs;
	}

	public void setImgs(List<imgEntity> imgs) {
		this.imgs = imgs;
	}

	public List<fileEntity> getVideos() {
		return videos;
	}

	public void setVideos(List<fileEntity> videos) {
		this.videos = videos;
	}
}
