package com.coo.b1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class CustomInterceptor extends HandlerInterceptorAdapter {
	
	//컨트롤러 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Controller 진입전");
		boolean check = false;
		
		return check;
	}
	
	
	//컨트롤러 종료후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("컨트롤러 종료 후");
	}
	
	
	//jsp 완성후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("jsp 띄우고 난 후");
	}
	
	//비동기(ajax) 요청시 postHandle, afterCompletion 을 수정하지 않고 이 메서드를 수행
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
	}
	
	
	
}
