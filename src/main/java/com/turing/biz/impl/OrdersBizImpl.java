package com.turing.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.biz.OrdersBiz;
import com.turing.entity.Orders;
import com.turing.entity.OrdersExample;
import com.turing.mapper.OrdersMapper;

/**
 * 需求计划表
 * @author Administrator
 *
 */
@Service
public class OrdersBizImpl implements OrdersBiz {

	@Autowired
	private OrdersMapper mapper;//需求mapper
	
	
	/**
	 * 添加需求
	 * @param order
	 * @return
	 */
	@Override
	public int addOrder(Orders order) {
		
		return mapper.insertSelective(order);
	}


	/**
	 * 查询刚刚添加的order的id
	 */
	@Override
	public int findLastOrderId() {
		
		return mapper.selectLastOrderId();
	}

	/**
	 * 查询需求的映射
	 */
	@Override
	public List<Orders> findOrderMapping(Orders order) {
		
		return mapper.selectOrderMapping(order);
	}


	/**
	 * 根据id查询需求
	 * @param id
	 * @return
	 */
	@Override
	public Orders findOrderById(int id) {
		
		return mapper.selectByPrimaryKey((long) id);
	}


	/**
	 * 根据id删除需求
	 * @param id
	 * @return
	 */
	@Override
	public int deleteOrder(long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	/**
	 * 修改需求
	 * @param order
	 * @return
	 */
	@Override
	public int updateOrder(Orders order) {
		
		return mapper.updateByPrimaryKeySelective(order);
	}

	/**
	 * 按照状态查询需求
	 * @return
	 */
	@Override
	public List<Orders> selectOrderByStatus(String stauts) {
		
		return mapper.selectOrderMappingByStatus(stauts);
	}

}
