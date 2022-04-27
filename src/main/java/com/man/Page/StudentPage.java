package com.man.Page;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


public class StudentPage {
	private int pageNo=0;
	private int pageSize=5;
	private Sort.Direction sortDirection=Sort.Direction.ASC;
	private String sortBy="lastName";
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
	public Sort.Direction getSortDirection() {
		return sortDirection;
	}
	public void setSortDirection(Sort.Direction sortDirection) {
		this.sortDirection = sortDirection;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

}
