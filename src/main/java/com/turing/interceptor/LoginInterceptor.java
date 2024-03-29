package com.turing.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 复制拦截是否有登录
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//是否有登录
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			//没有登录
			response.sendRedirect("/");//重定向去登录页面
			return false;
		}else {
			//登录
			return true;
		}
		
	}
	
	
}
