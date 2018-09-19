package com.kcy.mybatis.Dao;

import com.kcy.mybatis.bean.Employee;

public interface EmployeeMapperPlus {
	public Employee getEmployeeById(Integer id);
	public Employee getEmployeeAndDeptById(Integer id);
	public Employee getEmployeeAndDeptByStep(Integer id);
	public Employee getEmpByDynamicCondition(Employee emp);

}
