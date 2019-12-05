package com.turing.biz;

import java.util.List;

import com.turing.entity.Supplier;

/**
 * 供应商biz
 * @author Administrator
 *
 */
public interface SupplierBiz {

	/**
	 * 查询所有供应商
	 * @return
	 */
	public List<Supplier> findSuppliers();
}
