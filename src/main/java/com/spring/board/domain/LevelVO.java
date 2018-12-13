package com.spring.board.domain;

public class LevelVO {
	private int num;
	private int point;
	private int levels;
	
	public LevelVO() {
	}
	
	public LevelVO(int point, int levels) {
		this.point = point;
		this.levels = levels;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}
	
}
