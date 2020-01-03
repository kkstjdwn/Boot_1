package com.coo.b1.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FilesMapper {

	public int filesUpload(FilesVO filesVO) throws Exception;
	
	public FilesVO getFiles(FilesVO filesVO) throws Exception;
}
