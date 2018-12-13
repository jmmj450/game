package com.spring.board.domain;

import java.sql.Timestamp;

public class BoardVO {
	private int bNum;
	private String bigcategory;
	private String category;
	private String bTitle;
	private String bContent;
	private int bReadCount;
	private String userEmail;
	private String password;
	private String fileName;
	private int reRef;
	private int reLev;
	private int reSeq;
	private int recommend;
	private int report;
	private int notice;
	private Timestamp bWriteDate;
	private String ip;
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getBigcategory() {
		return bigcategory;
	}
	public void setBigcategory(String bigcategory) {
		this.bigcategory = bigcategory;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public int getbReadCount() {
		return bReadCount;
	}
	public void setbReadCount(int bReadCount) {
		this.bReadCount = bReadCount;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getReRef() {
		return reRef;
	}
	public void setReRef(int reRef) {
		this.reRef = reRef;
	}
	public int getReLev() {
		return reLev;
	}
	public void setReLev(int reLev) {
		this.reLev = reLev;
	}
	public int getReSeq() {
		return reSeq;
	}
	public void setReSeq(int reSeq) {
		this.reSeq = reSeq;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	public int getNotice() {
		return notice;
	}
	public void setNotice(int notice) {
		this.notice = notice;
	}
	public Timestamp getbWriteDate() {
		return bWriteDate;
	}
	public void setbWriteDate(Timestamp bWriteDate) {
		this.bWriteDate = bWriteDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
	
	
	
	
	
}
