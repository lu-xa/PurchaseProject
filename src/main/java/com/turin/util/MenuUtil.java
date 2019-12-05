package com.turin.util;

import java.util.ArrayList;
import java.util.List;

import com.turing.entity.SysMenus;


public class MenuUtil {
	
	//寻找一级菜单
	public static List<SysMenus> findParents(List<SysMenus> allList){
		List<SysMenus> parents = new ArrayList<SysMenus>();
		for(SysMenus menu:allList) {
			//判断是否是一级菜单
			if(menu.getParentId() == null ) {
				//寻找一级菜单下的子节点
				menu.setChildren(findSons(menu.getId(),allList));
				parents.add(menu);
			}
		}
		
		return parents;
	}
	
	
	//寻找指定的父节点下面的子节点集合
	public static List<SysMenus> findSons(long pid,List<SysMenus> allList){
		List<SysMenus> sons = new ArrayList<SysMenus>();
		for (SysMenus sysMenus : allList) {
			if(sysMenus.getParentId() == null) {
				continue;
			}
			//继续再找该菜单下子节点
			//递归算法
			if(sysMenus.getParentId() == pid) {
				sysMenus.setChildren(findSons(sysMenus.getId(),allList));
				sons.add(sysMenus);
			}
		}
		return sons;
	}
	
	
}
