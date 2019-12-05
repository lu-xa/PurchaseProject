package com.turing.biz;

import java.util.List;

import com.turing.entity.SysCodes;

/**
 * 	基础代码表接口
 * @author Administrator
 *
 */
public interface CodesBiz {

	/**
	 * 在基础代码表中查询所有的物资代码
	 * @return
	 */
	public List<SysCodes> findMaterialType();
}
