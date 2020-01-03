package com.coo.b1.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean check = false;
		
		//null 인지 아닌지만 판단하니 굳이 형변환 해줄 필요는 없음
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		
		if (memberVO != null) {
			check = true;
			
			return check;
		}else {
			response.sendRedirect("memberSignIn");
			return check;
		}
	}
}
