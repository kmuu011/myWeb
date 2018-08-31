package com.ict.erp.vo;

public class MusicInfo {
	private int mcNum;
	private String mcName;
	private String mcSinger;
	private String mcVendor;
	private int mcLike;
	private int mcDislike;
	private String mcCredat;
	private String mcDesc;
	
	public MusicInfo() {}
	
	public MusicInfo(int mcNum, String mcName, String mcSinger, String mcVendor, int mcLike, int mcDislike,
			String mcCredat, String mcDesc) {
		this.mcNum = mcNum;
		this.mcName = mcName;
		this.mcSinger = mcSinger;
		this.mcVendor = mcVendor;
		this.mcLike = mcLike;
		this.mcDislike = mcDislike;
		this.mcCredat = mcCredat;
		this.mcDesc = mcDesc;
	}

	public int getMcNum() {
		return mcNum;
	}

	public void setMcNum(int mcNum) {
		this.mcNum = mcNum;
	}

	public String getMcName() {
		return mcName;
	}

	public void setMcName(String mcName) {
		this.mcName = mcName;
	}

	public String getMcSinger() {
		return mcSinger;
	}

	public void setMcSinger(String mcSinger) {
		this.mcSinger = mcSinger;
	}

	public String getMcVendor() {
		return mcVendor;
	}

	public void setMcVendor(String mcVendor) {
		this.mcVendor = mcVendor;
	}

	public int getMcLike() {
		return mcLike;
	}

	public void setMcLike(int mcLike) {
		this.mcLike = mcLike;
	}

	public int getMcDislike() {
		return mcDislike;
	}

	public void setMcDislike(int mcDislike) {
		this.mcDislike = mcDislike;
	}

	public String getMcCredat() {
		return mcCredat;
	}

	public void setMcCredat(String mcCredat) {
		this.mcCredat = mcCredat;
	}

	public String getMcDesc() {
		return mcDesc;
	}

	public void setMcDesc(String mcDesc) {
		this.mcDesc = mcDesc;
	}

	@Override
	public String toString() {
		return "MusicInfo [mcNum=" + mcNum + ", mcName=" + mcName + ", mcSinger=" + mcSinger + ", mcVendor=" + mcVendor
				+ ", mcLike=" + mcLike + ", mcDislike=" + mcDislike + ", mcCredat=" + mcCredat + ", mcDesc=" + mcDesc
				+ "]";
	}
	
	
	
	

}
