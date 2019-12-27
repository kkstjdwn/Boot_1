package com.coo.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberTest {

	@Autowired
	private MemberMapper mapper;	
	
	@Test
	void test() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setId("coo");
		vo.setPw("coo");
		vo = mapper.memberSignIn(vo);
		
		System.out.println(vo.getEmail() + "= email");
	}

}
