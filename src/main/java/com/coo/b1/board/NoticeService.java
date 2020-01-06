package com.coo.b1.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.coo.b1.util.FilePathGenerator;
import com.coo.b1.util.FileSaver;

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
		if (result>0) {
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
	
	
}
