package com.turing.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.biz.StockBiz;
import com.turing.entity.Stock;
import com.turing.mapper.StockMapper;

@Service
public class StockBizImpl implements StockBiz {

	@Autowired
	private StockMapper mapper;//采购
	
	/**
	 * 添加采购
	 * @return
	 */
	@Override
	public int addStock(Stock stock) {
		
		return mapper.insertSelective(stock);
	}

}
