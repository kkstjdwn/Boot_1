package com.coo.b1.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface noticeMapper {
	
	public int noticeWrite(NoticeVO noticeVO) throws Exception;
	
	public int filesInsert(NoticeFilesVO filesVO) throws Exception;
	
	public int filesInsertList(List<NoticeFilesVO> ar) throws Exception;
}
