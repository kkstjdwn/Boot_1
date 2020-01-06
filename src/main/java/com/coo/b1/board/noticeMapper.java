package com.coo.b1.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import com.coo.b1.util.SqlPager;

@Repository
@Mapper
public interface noticeMapper {
	
	public int noticeWrite(NoticeVO noticeVO) throws Exception;
	
	public int filesInsert(NoticeFilesVO filesVO) throws Exception;
	
	public int filesInsertList(List<NoticeFilesVO> ar) throws Exception;
	
	public List<NoticeVO> noticeList(SqlPager pager) throws Exception;
	
	public int countList() throws Exception;
	
	public List<NoticeFilesVO> getFiles(NoticeFilesVO filesVO) throws Exception;
	
	public NoticeVO noticeSelect(NoticeVO noticeVO) throws Exception;
	
	public List<NoticeVO> noticeSearch(SqlPager pager) throws Exception;
	
	public int searchCount(SqlPager pager) throws Exception;
}
