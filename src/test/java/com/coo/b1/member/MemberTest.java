package com.coo.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback
class MemberTest {
	
	@Autowired
	private MemberMapper memberMapper; 
	
	@Test
	public void test() throws Exception {
		MemberVO memberVO= new MemberVO();
		memberVO.setId("iu12");
		memberVO.setPw("iu12");
		memberVO.setEmail("i@u12");
		memberVO.setName("iu12");
		int result = memberMapper.memberSignUp(memberVO);
		assertEquals(1, result);
	}

}
