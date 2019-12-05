package com.turing.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.biz.CodesBiz;
import com.turing.entity.SysCodes;
import com.turing.entity.SysCodesExample;
import com.turing.mapper.SysCodesMapper;

/**
 * 基础代码表Service
 * @author Administrator
 *
 */
@Service
public class CodesBizImpl implements CodesBiz {
	
	@Autowired
	private SysCodesMapper mapper;//基础代码表mapper
	
	/**
	 * 在基础代码表中查询所有的物资代码
	 * @return
	 */
	@Override
	public List<SysCodes> findMaterialType() {
		SysCodesExample example = new SysCodesExample();
		example.createCriteria().andParentIdEqualTo((long) 4);
		return mapper.selectByExample(example);
	}

}
