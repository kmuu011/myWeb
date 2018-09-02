package com.ict.erp.vo;

public class MovieInfo {
	private Long tmNum;
	private String tmName;
	private Long tmPrice;
	private String tmStartdat;
	private String tmEnddat;
	private String tmCredat;
	private String tmDesc;
	private Long tmCnt;
	private String tmImg;
	
	public MovieInfo() {}
	
	public Long getTmNum() {
		return tmNum;
	}
	public void setTmNum(Long tmNum) {
		this.tmNum = tmNum;
	}
	public String getTmName() {
		return tmName;
	}
	public void setTmName(String tmName) {
		this.tmName = tmName;
	}
	public Long getTmPrice() {
		return tmPrice;
	}
	public void setTmPrice(Long tmPrice) {
		this.tmPrice = tmPrice;
	}
	public String getTmStartdat() {
		return tmStartdat;
	}
	public void setTmStartdat(String tmStartdat) {
		this.tmStartdat = tmStartdat;
	}
	public String getTmEnddat() {
		return tmEnddat;
	}
	public void setTmEnddat(String tmEnddat) {
		this.tmEnddat = tmEnddat;
	}
	public String getTmCredat() {
		return tmCredat;
	}
	public void setTmCredat(String tmCredat) {
		this.tmCredat = tmCredat;
	}
	public String getTmDesc() {
		return tmDesc;
	}
	public void setTmDesc(String tmDesc) {
		this.tmDesc = tmDesc;
	}
	public Long getTmCnt() {
		return tmCnt;
	}
	public void setTmCnt(Long tmCnt) {
		this.tmCnt = tmCnt;
	}
	public String getTmImg() {
		return tmImg;
	}
	public void setTmImg(String tmImg) {
		this.tmImg = tmImg;
	}
	@Override
	public String toString() {
		return "MovieInfo [tmNum=" + tmNum + ", tmName=" + tmName + ", tmPrice=" + tmPrice + ", tmStartdat="
				+ tmStartdat + ", tmEnddat=" + tmEnddat + ", tmCredat=" + tmCredat + ", tmDesc=" + tmDesc + ", tmCnt="
				+ tmCnt + ", tmImg=" + tmImg + "]";
	}
	
	
	

}
