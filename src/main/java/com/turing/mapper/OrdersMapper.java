package com.turing.mapper;

import com.turing.entity.Orders;
import com.turing.entity.OrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {
	List<Orders> selectOrderMappingByStatus (String status);//查询需求和相对映射
	
	List<Orders> selectOrderMapping (Orders order);//查询需求和相对映射
	
	int selectLastOrderId();//查询最近生成的order对象的id
	
    long countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}