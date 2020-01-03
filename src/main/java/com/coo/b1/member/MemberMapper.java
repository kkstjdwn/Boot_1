package com.coo.b1.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {
	public int memberSignUp(MemberVO memberVO) throws Exception; 
	
	public MemberVO memberSignIn(MemberVO memberVO) throws Exception;
	
	public String idCheck(MemberVO memberVO) throws Exception;
}
