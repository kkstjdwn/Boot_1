package com.coo.b1.config;

import java.util.Locale;

import javax.servlet.http.Cookie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class Papago implements WebMvcConfigurer{

	@Bean
	public LocaleResolver getLR() {
//		세션쓰고 싶으면 
//		SessionLocaleResolver sessionResolver = new SessionLocaleResolver();
//		sessionResolver.setDefaultLocale(Locale.KOREAN);
		
		//보통은 쿠키로 쓴다
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREAN);
		resolver.setCookieName("lang");
		
		return resolver;
	}
	
	@Bean
	public LocaleChangeInterceptor getLCI() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		
		return lci;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(getLCI()).addPathPatterns("/**");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
	
}
