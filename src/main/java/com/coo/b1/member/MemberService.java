package com.coo.b1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	public int memberSingUp(MemberVO memberVO) throws Exception{
		return mapper.memberSignUp(memberVO);
	}
}
