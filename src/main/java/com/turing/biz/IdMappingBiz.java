package com.turing.biz;

import com.turing.entity.IdMapping;

/**
 * 编号对照表接口
 * @author Administrator
 *
 */
public interface IdMappingBiz {

	/**
	 * 添加编号对照表
	 * @param idMapping
	 * @return
	 */
	public int addIdMapping(IdMapping idMapping);
	
	/**
	 * 根据需求id查询编号对照表
	 * @param orderid
	 * @return
	 */
	public IdMapping findMappingByOrderId(int orderid);
	
	
	/**
	 * 根据id修改编号对照表
	 * @param id
	 * @return
	 */
	public int updateIdMapping(IdMapping mapping ) ;
	
	/**
	 * 删除编号对照记录
	 * @param id
	 * @return
	 */
	public int deleteIdMapping(Long id);
}
