package com.turing.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.biz.SupplierBiz;
import com.turing.entity.Supplier;
import com.turing.mapper.SupplierMapper;

/**
 * 供应商服务类
 * @author Administrator
 *
 */
@Service
public class SupplierBizImpl implements SupplierBiz {

	@Autowired
	private SupplierMapper mapper;//供应商mapper
	
	/**
	 * 查询所有供应商
	 * @return
	 */
	@Override
	public List<Supplier> findSuppliers() {
		
		return mapper.selectByExample(null);
	}

}
