package com.spring.board.domain;

public class ReplyVO {
	private int rNum;
	private String rContent;
	private String rWriteDate;
	private int bNum;
	private String userEmail;
	private String password;
	
	
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getrWriteDate() {
		return rWriteDate;
	}
	public void setrWriteDate(String rWriteDate) {
		this.rWriteDate = rWriteDate;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
