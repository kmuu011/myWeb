package com.ict.erp.vo;

public class BeanInfo {
	private Long bNum;
	private String bName;
	private String bHobby;
	
	public BeanInfo() {}
	
	public BeanInfo(Long bNum, String bName, String bHobby) {
		this.bNum = bNum;
		this.bName = bName;
		this.bHobby = bHobby;
	}
	
	public Long getbNum() {
		return bNum;
	}
	public void setbNum(Long bNum) {
		this.bNum = bNum;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbHobby() {
		return bHobby;
	}
	public void setbHobby(String bHobby) {
		this.bHobby = bHobby;
	}
	@Override
	public String toString() {
		return "BeanInfo [bNum=" + bNum + ", bName=" + bName + ", bHobby=" + bHobby + "]";
	}
	

}
