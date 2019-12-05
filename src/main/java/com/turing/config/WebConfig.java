package com.turing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.turing.interceptor.LoginInterceptor;


@Configuration //配置类
public class WebConfig implements WebMvcConfigurer {

	//添加视图映射(地址-模板)
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
	}
	
	/*//注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/","/login1/","/css/**","/js/**","/jquery-easyui-1.6.3/**","/goLogin");
	}*/
}
