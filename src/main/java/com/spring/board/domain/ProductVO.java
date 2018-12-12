package com.spring.board.domain;

public class ProductVO {
	private int proNum;   	    //INTEGER AUTO_INCREMENT  primary key,  -- 상품번호
	private String proName;     //VARCHAR(50) NOT NULL,  -- 상품명
	private int proPrice ;  	//INTEGER DEFAULT 0, -- 상품가격
	private String proContent;  //VARCHAR(1000) ,   -- 상세설명
	private String proFile;     //VARCHAR(100) , -- 상품사진
	private String proTime;     //TIMESTAMP  -- 등록일시
	
	public int getProNum() {
		return proNum;
	}
	public void setProNum(int proNum) {
		this.proNum = proNum;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public String getProContent() {
		return proContent;
	}
	public void setProContent(String proContent) {
		this.proContent = proContent;
	}
	public String getProFile() {
		return proFile;
	}
	public void setProFile(String proFile) {
		this.proFile = proFile;
	}
	public String getProTime() {
		return proTime;
	}
	public void setProTime(String proTime) {
		this.proTime = proTime;
	}
	
	@Override
	public String toString() {
		return "ProductVO [proNum=" + proNum + ", proName=" + proName
				+ ", proPrice=" + proPrice + ", proContent=" + proContent
				+ ", proFile=" + proFile + ", proTime=" + proTime + "]";
	}
		
}
