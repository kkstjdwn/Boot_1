package com.coo.b1.util;

import org.springframework.stereotype.Component;

@Component
public class SqlPager {
	
	private Integer curPage;
	private Integer perPage=8;
	private String kind;
	private String search;
	private Integer startRow;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer perBlock;
	private Integer totalBlock;
	private Integer totalPage;
	
	
	
	public Integer getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}
	public Integer getCurPage() {
		if (this.curPage == null || this.curPage == 0) {
			this.curPage = 1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getLastNum() {
		return lastNum;
	}
	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}
	public Integer getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}
	public Integer getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(Integer perBlock) {
		this.perBlock = perBlock;
	}
	public String getKind() {
		if (this.kind == null) {
			kind = "tt";
		}
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	
	public void makeRow(int curPage,int perP) throws Exception{
		this.perPage = perP;
		this.startRow = (curPage-1)*this.perPage;
	}
	
	public void makePager(int totalCount,int perB) throws Exception{
		
		this.perBlock = perB;
		
		this.totalPage = totalCount / this.perPage;
		
		if (totalCount%this.perPage !=0) {
			this.totalPage++;
		}
		
		totalBlock = totalPage/this.perBlock;
		if (totalPage%perBlock!=0) {
			totalBlock++;
		}

		//4.curPage 이용햇 현재 블록curBlock 표시

		curBlock = this.getCurPage()/this.perBlock;
		if (curPage%perBlock != 0) {
			curBlock++;
		}
		
		//5.curBlock 이용해서 startNum, lastNum 구하기
		this.startNum = (curBlock-1)*this.perBlock + 1; 
		this.lastNum = curBlock*this.perBlock;
		
		if (curBlock==totalBlock) {
			lastNum = totalPage;
		}
		if (totalPage ==0) {
			lastNum = 1;
		}
	}
 	
	
}
