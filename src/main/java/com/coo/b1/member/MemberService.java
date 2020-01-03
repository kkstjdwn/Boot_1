package com.coo.b1.member;


import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.coo.b1.util.FilePathGenerator;
import com.coo.b1.util.FileSaver;

@Service
//@Transactional
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	@Autowired
	private FilesMapper fmapper;
	@Autowired
	private FilePathGenerator fpg;
	@Autowired
	private FileSaver saver;
	
	
	@Transactional(rollbackFor = Exception.class)
	public int memberSignUp(MemberVO memberVO,MultipartFile files) throws Exception{
		//파일을 저장할 폴더
		
		File file = fpg.useClassPathResource("upload");
		String fname=saver.saver(file, files);
		System.out.println(fname);
		int result = mapper.memberSignUp(memberVO); 
		if (result > 0) {
			FilesVO filesVO = new FilesVO();
			filesVO.setId(memberVO.getId());
			filesVO.setFname(fname);
			filesVO.setOname(files.getOriginalFilename());
			result = fmapper.filesUpload(filesVO);
		}
		return result;
	}
	
	public MemberVO memberSingIn(MemberVO memberVO) throws Exception{
		return mapper.memberSignIn(memberVO);
	}
	
	public FilesVO getImg(MemberVO memberVO) throws Exception{
		FilesVO filesVO = new FilesVO();
		filesVO.setId(memberVO.getId());
		return fmapper.getFiles(filesVO);
	}
	
	public boolean signUpValidate(MemberVO memberVO, BindingResult br) throws Exception{
		boolean check = false;
		//annotation 검증 결과
		if (br.hasErrors()) {
			check = true;
		}
		
		//pw가 일치하는지 검증
		if (!memberVO.getPw().equals(memberVO.getPw2())) {
			check = true;
//							form의 path명, properties의 키
			br.rejectValue("pw2", "memberVO.pw.notEqual");
		}
		
		//id중복검사
		String idCheck = mapper.idCheck(memberVO);
		if (!memberVO.getId().equals("") && idCheck.equals(memberVO.getId())) {
			check = true;
			
			br.rejectValue("id", "memberVO.id.duplication");
		}
		
		
		return check;
	}
}
