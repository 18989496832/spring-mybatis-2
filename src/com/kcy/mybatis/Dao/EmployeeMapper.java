package com.kcy.mybatis.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.kcy.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	@MapKey("id")
	public Map<Integer,Employee> getEmployeeByNameLikeRetMap(String param);
	
	public Map<String,Object> getEmployeeByIdRetMap(Integer id);
	
	public List<Employee> getEmployeeByNameLike(String param);
	
	public Employee getEmployeeById(Integer id);
		
	public Employee getEmployeeByMap(Map<String, Object> params);
	
	public Integer addEmp(Employee employee);
	
	public Integer updateEmp(Employee employee);
	
	public Integer deleteEmp(Employee employee);
	
	public List<Employee> getEmployeeByDeptId(Integer dept);
}
