package com.spring.board.domain;

public class PointVO {
	private int num;
	private String itemName;
	private String itemType;
	int point;
	
	public PointVO() {
	}
	
	public PointVO(String itemName, String itemType, int point) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.point = point;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
}
