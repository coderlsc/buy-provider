package com.qdu.buy.lang;

import lombok.Data;

import java.io.Serializable;

//搜索结果封装类
@Data
public class SearchResult implements Serializable{

	private long totalPages;
    private long recordCount;
//	private List<> itemList;
	public long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
//	public List<SearchItem> getItemList() {
//		return itemList;
//	}
//	public void setItemList(List<SearchItem> itemList) {
//		this.itemList = itemList;
//	}
	
	
	
}