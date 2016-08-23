package com.sigmatrix.sc.page;

import java.io.Serializable;
import java.util.List;

/**
 * 功能概要：
 * 
 * @author linbingwen
 * @since  2015年10月23日 
 */
public class PageBean<T> implements Serializable {
	
	/*serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private List<T> dataList; // 数据
	
	private int pageNo = 1; // 当前页
	
	private int pageSize = 20;// 每页显示条数
	
	private long total; // 总条数
	
	private int pages; // 总页面数目

	public PageBean(){}
	
	public PageBean(int pageNo){
		this.pageNo = pageNo;
	}
	
	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
}
