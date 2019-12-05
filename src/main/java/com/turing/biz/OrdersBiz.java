package com.turing.biz;

import java.util.List;

import com.turing.entity.Orders;

/**
 * 需求接口
 * @author Administrator
 *
 */
public interface OrdersBiz {

	/**
	 * 添加需求
	 * @param order
	 * @return
	 */
	public int addOrder(Orders order);
	
	
	/**
	 * 查询刚刚添加的order的id
	 */
	public int findLastOrderId();
	
	
	/**
	 * 查询需求的映射
	 */
	public List<Orders> findOrderMapping(Orders order);
	
	/**
	 * 根据id查询需求
	 * @param id
	 * @return
	 */
	public Orders findOrderById(int id);
	
	/**
	 * 根据id删除需求
	 * @param id
	 * @return
	 */
	public int deleteOrder(long id);
	
	/**
	 * 修改需求
	 * @param order
	 * @return
	 */
	public int updateOrder(Orders order);
	
	/**
	 * 按照状态查询需求
	 * @return
	 */
	public List selectOrderByStatus(String status);
	
	
}
