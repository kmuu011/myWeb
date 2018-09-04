package com.ict.erp.vo;

public class MovieInfo {
	private int tmNum;
	private String tmName;
	private Long tmPrice;
	private String tmStartDat;
	private String tmEndDat;
	private String tmCredat;
	private String tmDesc;
	private Long tmCnt;
	private String tmImg;
	
	public MovieInfo() {}

	public int getTmNum() {
		return tmNum;
	}

	public void setTmNum(int tmNum) {
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

	public String getTmStartDat() {
		return tmStartDat;
	}

	public void setTmStartDat(String tmStartDat) {
		this.tmStartDat = tmStartDat.replace("-", "");
	}

	public String getTmEndDat() {
		return tmEndDat;
	}

	public void setTmEndDat(String tmEndDat) {
		this.tmEndDat = tmEndDat.replace("-", "");
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
		return "MovieInfo [tmNum=" + tmNum + ", tmName=" + tmName + ", tmPrice=" + tmPrice + ", tmStartDat="
				+ tmStartDat + ", tmEndDat=" + tmEndDat + ", tmCredat=" + tmCredat + ", tmDesc=" + tmDesc + ", tmCnt="
				+ tmCnt + ", tmImg=" + tmImg + "]";
	}
	
	
	
	
	
	

}
