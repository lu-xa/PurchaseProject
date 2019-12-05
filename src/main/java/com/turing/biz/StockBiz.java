package com.turing.biz;

import com.turing.entity.Stock;

/**
 * 采购
 * @author Administrator
 *
 */
public interface StockBiz {

	/**
	 * 添加采购
	 * @return
	 */
	public int addStock(Stock stock);
	
}
