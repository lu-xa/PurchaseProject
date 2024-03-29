package com.turing.mapper;

import com.turing.entity.SuppMaterial;
import com.turing.entity.SuppMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuppMaterialMapper {
	
	
	SuppMaterial findSuppMaterialByWzId(int id);//根据物资id查询供应商对应的产品
	
    long countByExample(SuppMaterialExample example);

    int deleteByExample(SuppMaterialExample example);

    int insert(SuppMaterial record);

    int insertSelective(SuppMaterial record);

    List<SuppMaterial> selectByExample(SuppMaterialExample example);

    int updateByExampleSelective(@Param("record") SuppMaterial record, @Param("example") SuppMaterialExample example);

    int updateByExample(@Param("record") SuppMaterial record, @Param("example") SuppMaterialExample example);
}