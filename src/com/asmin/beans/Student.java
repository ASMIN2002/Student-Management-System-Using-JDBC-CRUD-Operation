package com.asmin.beans;

// with private properties and toString()

public class Student {
	
	private int sroll;
	private String sname;
	private String semail;
	private String saddr;
	
	public int getSroll() {
		return sroll;
	}
	public void setSroll(int sroll) {
		this.sroll = sroll;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	
	@Override
	public String toString(){
		return "[ Roll="+sroll+", Name="+sname+", Email="+semail+", Address="+saddr+" ]";
	}	
}
