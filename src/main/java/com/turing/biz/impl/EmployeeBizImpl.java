package com.turing.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.biz.EmployeeBiz;
import com.turing.entity.Employee;
import com.turing.entity.EmployeeExample;
import com.turing.mapper.EmployeeMapper;


/**
 * 员工实现类
 * @author Administrator
 *
 */

@Service
public class EmployeeBizImpl implements EmployeeBiz{

	@Autowired
	private EmployeeMapper mapper;
	
	/**
	 * 根据姓名查找员工
	 * @param name
	 * @return
	 */
	@Override
	public Employee findByName(String name) {
		EmployeeExample example = new EmployeeExample();
		example.createCriteria().andEmpNameEqualTo(name);
		
		return mapper.selectByExample(example).get(0);
	}

	
}
