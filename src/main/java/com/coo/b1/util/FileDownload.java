package com.coo.b1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.coo.b1.member.FilesVO;

@Component
public class FileDownload extends AbstractView{
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String filePath = "/static/"+(String)model.get("path");
		FilesVO filesVO = (FilesVO)model.get("files");
		ClassPathResource cpr = new ClassPathResource(filePath);
		
		File file = new File(cpr.getFile(),filesVO.getFname());
		
		//한글처리
		response.setCharacterEncoding("UTF-8");
		//파일크기
		response.setContentLengthLong(file.length());
		//파일다운로드시 인코딩 처리
		String fileName = URLEncoder.encode(filesVO.getOname(),"UTF-8");
		//header 설정
//		response.setHeader("Content-Disposition", "attachment="+"\""+fileName+"\"");
//		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//파일을 읽어오는 스트림
		FileInputStream fi = new FileInputStream(file);
		
		//파일을 출력하는 스트림
		OutputStream os = response.getOutputStream();
		
		//파일출력
		FileCopyUtils.copy(fi, os);
		//close
		os.close();
		fi.close();
		
	}
}
