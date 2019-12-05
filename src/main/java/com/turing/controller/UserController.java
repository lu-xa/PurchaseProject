package com.turing.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.turing.biz.UserBiz;
import com.turing.entity.SysUsers;

/**
 * 用户控制器
 * @author Administrator
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserBiz uBiz;//用户业务接口
	
	/**
	 * 去登陆
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/gologin",method = RequestMethod.GET)
	public String toLogin(Model model) {
		model.addAttribute("user",new SysUsers());
		return "login.html";
	}
	
	
	/**
	 * 登录
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login1",method=RequestMethod.POST)
	public String login(SysUsers user,HttpServletRequest session) {
		SysUsers sysuser = uBiz.login(user);
		if(sysuser != null) {
			session.getSession().setAttribute("user", sysuser);
			
			
			return "main";
		}else {
			return "/goLogin";
		}
	}
	
	/**
	 * 头部
	 */
	@RequestMapping(value="gohead",method=RequestMethod.GET)
	public String head() {
		return "head";
	}
}
