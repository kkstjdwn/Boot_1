package com.coo.b1.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	public String saver(File save, MultipartFile files) throws Exception{
		String fileName = UUID.randomUUID().toString()+"_"+files.getOriginalFilename();
		save = new File(save, fileName);
		files.transferTo(save);
		
		return fileName;
	}
	
}
