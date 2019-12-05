package com.turing.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.biz.MaterialBiz;
import com.turing.entity.Material;
import com.turing.entity.MaterialExample;
import com.turing.mapper.MaterialMapper;

/**
 * 物资服务类
 * @author Administrator
 *
 */

@Service
public class MaterialBizImpl implements MaterialBiz{

	@Autowired
	private MaterialMapper mMapper;//物资mapper

	/**
	 * 查询所有物资
	 */
	@Override
	public List<Material> findAllMaterial() {
		
		return mMapper.selectByExample(null);
	}

	
	/**
	 * 根据类别查询物资
	 * @return
	 */
	@Override
	public List<Material> findByType(String typeId) {
		MaterialExample example = new MaterialExample();
		example.createCriteria().andMaterialTypeEqualTo(typeId);
		return mMapper.selectByExample(example);
	}

	/**
	 * 根据id查询物资
	 * @param id
	 * @return
	 */
	@Override
	public Material findById(int id) {
		
		return mMapper.selectByPrimaryKey((long)id);
	}


	/**
	 * 根据物资编码查询物资
	 * @param code
	 * @return
	 */
	@Override
	public Material findByCode(String code) {
		MaterialExample example = new MaterialExample();
		example.createCriteria().andMaterialNumEqualTo(code);
		
		return mMapper.selectByExample(example).get(0);
	}
	
	
	
}
