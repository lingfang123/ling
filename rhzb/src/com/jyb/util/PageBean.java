package com.jyb.util;

import java.util.List;

public class PageBean<T> {
	private int currPage;//当前页
    private int pageSize;//一页显示多少条
    private int totalCount;//总条数
    private int totalPage;//总页数
    private List<T> lists;//返回的对象
	public PageBean() {
		super();
	}
	public PageBean(int currPage, int pageSize, int totalCount, int totalPage, List<T> lists) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.lists = lists;
	}
	@Override
	public String toString() {
		return "PageBean [currPage=" + currPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", lists=" + lists + "]";
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getLists() {
		return lists;
	}
	public void setLists(List<T> lists) {
		this.lists = lists;
	}
}