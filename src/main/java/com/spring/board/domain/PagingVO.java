package com.spring.board.domain;

public class PagingVO {
	private int count; // 전체글개수
    private int page;
    private int pageCount;
    private int pageBlock;
    private int startPage;
    private int endPage;
    
    
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "PagingVO [count=" + count + ", page=" + page + ", pageCount="
				+ pageCount + ", pageBlock=" + pageBlock + ", startPage="
				+ startPage + ", endPage=" + endPage + "]";
	}
    
    
}
