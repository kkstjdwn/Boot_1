package com.coo.b1.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("memberSignUp")
	public String memberSignUp() throws Exception {
		return "member/memberSignUp";
	}
	
	@ModelAttribute("memberVO")
	public MemberVO getMemberVO() throws Exception{
		return new MemberVO();
	}
	
	@PostMapping("memberSignUp") // BindResult 는 Valid 바로 뒤에 있어야 함
	public ModelAndView memberSignUp(@Valid MemberVO memberVO, BindingResult br, MultipartFile files) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if (service.signUpValidate(memberVO, br)) {
			mv.setViewName("member/memberSignUp");
		} else {

			int result = service.memberSignUp(memberVO, files);
			String msg = "실패!";
			if (result > 0) {
				msg = "성공~";
			}
			String path = "/";
			mv.addObject("msg", msg);
			mv.addObject("path", path);
			mv.setViewName("common/msg");
		}

		return mv;
	}

	@GetMapping("memberSignIn")
	public String memberSignIn() {
		return "member/memberSignIn";
	}

	@PostMapping("memberSignIn")
	public ModelAndView memberSignIn(MemberVO memberVO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberVO = service.memberSingIn(memberVO);
		String msg = "다시 시도해주세요";
		String path = "#";
		if (memberVO.getName() != null) {
			msg = "Hey! buddy";
			path = "/";
			session.setAttribute("member", memberVO);
			session.setAttribute("files", service.getImg(memberVO));
		}
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/msg");

		return mv;

	}

	@GetMapping("memberSignOut")
	public ModelAndView memberSignOut(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.addObject("msg", "See you buddy!");
		mv.addObject("path", "/");
		mv.setViewName("common/msg");
		return mv;
	}

	@GetMapping("memberInfo")
	public void memberInfo() throws Exception {

	}

	@GetMapping("fileDownload")
	public ModelAndView fileDownload(FilesVO filesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = new MemberVO();
		memberVO.setId(filesVO.getId());
		filesVO = service.getImg(memberVO);
		if (filesVO != null) {
			mv.addObject("files", filesVO);
			mv.addObject("path", "upload");
			mv.setViewName("fileDownload");
		} else {
			mv.addObject("msg", "파일이 없습니다!");
			mv.addObject("path", "member/memberInfo");
			mv.setViewName("common/msg");
		}

		return mv;
	}
}
