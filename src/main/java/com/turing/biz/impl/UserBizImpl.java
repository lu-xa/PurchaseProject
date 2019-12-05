package com.turing.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.biz.UserBiz;
import com.turing.entity.SysUsers;
import com.turing.entity.SysUsersExample;
import com.turing.mapper.SysUsersMapper;

@Service
public class UserBizImpl implements UserBiz{

	@Autowired
	private SysUsersMapper mapper;
		
	@Override
	/**
	 * 登录
	 */
	public SysUsers login(SysUsers user) {
		SysUsersExample example = new SysUsersExample();
		example.createCriteria().andLoginIdEqualTo(user.getLoginId()).andPasswordEqualTo(user.getPassword());
		List<SysUsers> list = mapper.selectByExample(example);
		return list.size() == 0?null:list.get(0);
	}

}
