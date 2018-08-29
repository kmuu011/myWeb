package com.ict.erp.vo;

public class PList {
	private int pno;
	private String pname;
	private String ptext;
	private int phit;
	
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtext() {
		return ptext;
	}
	public void setPtext(String ptext) {
		this.ptext = ptext;
	}
	public int getPhit() {
		return phit;
	}
	public void setPhit(int phit) {
		this.phit = phit;
	}
	@Override
	public String toString() {
		return "PList [pno=" + pno + ", pname=" + pname + ", ptext=" + ptext + ", phit=" + phit + "]";
	}

	
}
