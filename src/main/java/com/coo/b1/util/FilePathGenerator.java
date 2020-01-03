package com.coo.b1.util;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class FilePathGenerator {
	@Autowired
	private ServletContext context;
	@Autowired
	private ResourceLoader rl;
	
	public File useReloadr(String filePath) throws Exception{
		String path = "classpath:/static/";
		File file = new File(rl.getResource(path).getFile(), filePath);
		/** 
		 * resource Loader는 classpath경로를 받아오기 위해 사용
		 * 폴더가 없으면 에러 발생
		 * static 경로를 이용해서 file 객체 생성하고
		 * 하위 폴더를 Child로 사용해서 폴더 생성
		 * 
		 * */
		
		if (!file.exists()) {
			file.mkdirs();
		}
		System.out.println(file.getAbsolutePath());
		return file;
	}
	
	public File useServletContext(String filePath) throws Exception{
		String files = context.getRealPath("upload");
		File file = new File(files);
		if (!file.exists()) {
			file.mkdirs();
		}
		return file;
	}
	
	public File useClassPathResource(String filePath) throws Exception{
		//classPath 경로를 받아오기 위해 사용, 시작 경로의 classpath 문구 사용 X
		//나머지는 ResourceLoader와 같음
		String path = "/static/";
		ClassPathResource cpr = new ClassPathResource(path);
		File file = new File(cpr.getFile(), filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		
		System.out.println(file.getAbsolutePath());
		
		return file;
		
	}
	
}
