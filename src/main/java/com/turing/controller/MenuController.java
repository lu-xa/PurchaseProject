package com.turing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turin.util.MenuUtil;
import com.turing.entity.SysMenus;
import com.turing.mapper.SysMenusMapper;

@Controller
public class MenuController {

	@Autowired
	private SysMenusMapper mapper;
	
	
	//获取所有菜单信息(json集合格式数据)
	@GetMapping("/menus")
	@ResponseBody
	public List<SysMenus> findAll(){
		List<SysMenus> allList = mapper.selectByExample(null);
		List<SysMenus> parents = MenuUtil.findParents(allList);
		return parents;
	}
}
