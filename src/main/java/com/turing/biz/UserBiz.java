package com.turing.biz;

import com.turing.entity.SysUsers;

/**
 * 用户接口
 * @author Administrator
 *
 */
public interface UserBiz {

	/**
	 * 登录
	 * @return
	 */
	public SysUsers login(SysUsers user);
}
