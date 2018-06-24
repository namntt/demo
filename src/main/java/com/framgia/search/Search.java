package com.framgia.search;

import java.io.Serializable;

public class Search implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyword;
	private Integer page;
	private Integer pageSize;
	private Integer totalPage;
	
	
	public Search() {
		this.page=1;
		this.pageSize=2;
		
		
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
