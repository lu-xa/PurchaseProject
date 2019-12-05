package com.turing.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.biz.IdMappingBiz;
import com.turing.entity.IdMapping;
import com.turing.entity.IdMappingExample;
import com.turing.mapper.IdMappingMapper;

/**
 * 编号对照表接口
 * @author Administrator
 *
 */
@Service
public class IdMappingBizImpl implements IdMappingBiz {

	@Autowired
	private IdMappingMapper mapper;
	
	/**
	 * 添加编号对照表
	 * @param idMapping
	 * @return
	 */
	@Override
	public int addIdMapping(IdMapping idMapping) {
		
		return mapper.insertSelective(idMapping);
	}

	/**
	 * 根据需求id查询编号对照表
	 * @param orderid
	 * @return
	 */
	@Override
	public IdMapping findMappingByOrderId(int orderid) {
		IdMappingExample idexample = new IdMappingExample();
		idexample.createCriteria().andOrderIdEqualTo((long) orderid);
		return mapper.selectByExample(idexample).get(0);
	}

	/**
	 * 根据id修改编号对照表
	 * @param id
	 * @return
	 */
	@Override
	public int updateIdMapping(IdMapping mapping) {
	
		return mapper.updateByPrimaryKeySelective(mapping);
	}

	/**
	 * 删除编号对照记录
	 * @param id
	 * @return
	 */
	@Override
	public int deleteIdMapping(Long id) {
		
		return mapper.deleteByPrimaryKey(id);
	}

	
	
}
