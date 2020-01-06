package com.coo.b1.board;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.coo.b1.util.FilePathGenerator;
import com.coo.b1.util.FileSaver;
import com.coo.b1.util.SqlPager;

@Service
public class NoticeService {
	
	@Autowired
	private noticeMapper mapper;
	@Autowired
	private FileSaver saver;
	@Autowired
	private FilePathGenerator fpg;
	
	@Transactional
	public int noticeWrite(NoticeVO noticeVO,MultipartFile[] files) throws Exception{
		int result = mapper.noticeWrite(noticeVO); 
		System.out.println(files.length);
		int count = files.length;
		if (result>0 && count != 0) {
			File file = fpg.useClassPathResource("notice");
			NoticeFilesVO filesVO = new NoticeFilesVO();
			filesVO.setNum(noticeVO.getNum());
			
//			for (MultipartFile multipartFile : files) {
//				if (count != files.length) {					
//					filesVO.setFname(saver.saver(file, multipartFile));
//					filesVO.setOname(multipartFile.getOriginalFilename());
//					count -= mapper.filesInsert(filesVO);
//				}else {					
//					count--;
//				}
//				Thread.sleep(200);
//			}
			
			List<NoticeFilesVO> ar = new ArrayList<>();
			for (MultipartFile multipartFile : files) {
				if (count != files.length) {
					filesVO = new NoticeFilesVO();
					filesVO.setNum(noticeVO.getNum());
					filesVO.setFname(saver.saver(file, multipartFile));
					filesVO.setOname(multipartFile.getOriginalFilename());
					count--;
					ar.add(filesVO);
				}else {
					count--;
				}
				Thread.sleep(200);
			}
			
			mapper.filesInsertList(ar);
			
			if (count == 0) {
				result = 1;
			}
			
		}
		
		return result;
	}
	
	
	public int countList() throws Exception{
		return mapper.countList();
	}
	
	public int searchList(SqlPager pager) throws Exception{
		return mapper.searchCount(pager);
	}
	
	public List<NoticeVO> noticeList(SqlPager pager) throws Exception{
		return mapper.noticeList(pager);
	}
	
	public List<NoticeVO> noticeSearch(SqlPager pager) throws Exception{
		return mapper.noticeList(pager);
	}
	
	
	public NoticeVO noticeSelect(NoticeVO noticeVO) throws Exception{
		return mapper.noticeSelect(noticeVO);
	}
	
	public List<NoticeFilesVO> getFiles(NoticeVO noticeVO) throws Exception{
		NoticeFilesVO filesVO = new NoticeFilesVO();
		filesVO.setNum(noticeVO.getNum());
		List<NoticeFilesVO> list = mapper.getFiles(filesVO);
		return list;
	}
	
}
