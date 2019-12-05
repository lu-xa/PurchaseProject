package com.turing.biz;

import java.util.List;

import com.turing.entity.Material;

/**
 * 物资接口
 * @author Administrator
 *
 */
public interface MaterialBiz {

	/**
	 * 查询所有物资
	 * @return
	 */
	public List<Material> findAllMaterial();
	
	
	/**
	 * 根据类别查询物资
	 * @return
	 */
	public List<Material> findByType(String typeId);
	
	/**
	 * 根据id查询物资
	 * @param id
	 * @return
	 */
	public Material findById(int id);
	
	/**
	 * 根据物资编码查询物资
	 * @param code
	 * @return
	 */
	public Material findByCode(String code);
}
