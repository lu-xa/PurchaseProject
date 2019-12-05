package com.turing.biz;

import com.turing.entity.Employee;

/**
 * 员工接口
 * @author Administrator
 *
 */
public interface EmployeeBiz {
	
	/**
	 * 根据姓名查找员工
	 * @param name
	 * @return
	 */
	public Employee findByName(String name);
}
