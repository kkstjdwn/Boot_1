package com.coo.b1.member;

import org.springframework.stereotype.Component;

@Component
public class FilesVO {

	private Integer fnum;
	private String id;
	private String fname;
	private String oname;
	public Integer getFnum() {
		return fnum;
	}
	public void setFnum(Integer fnum) {
		this.fnum = fnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
}
