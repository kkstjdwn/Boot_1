package com.coo.b1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.coo.b1.interceptor.CustomInterceptor;
import com.coo.b1.member.MemberInterceptor;

@Configuration //XML 파일입니다
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	private CustomInterceptor ci;
	@Autowired
	private MemberInterceptor mi;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

//		인터셉터 등록, URL 등록
//		registry.addInterceptor(ci).addPathPatterns("/member/*")
//		제외할 URL등록
//		.excludePathPatterns("/member/memberSign*");
		
		registry.addInterceptor(mi).addPathPatterns("/member/*")
		.excludePathPatterns("/member/memberSign*");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
		
	
}
