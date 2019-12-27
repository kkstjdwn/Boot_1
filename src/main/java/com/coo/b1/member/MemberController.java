package com.coo.b1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("memberSignUp")
	public String memberSignUp(MemberVO memberVO) throws Exception{
	
		return "member/memberSignUp";
	}
}
