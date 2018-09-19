package com.kcy.mybatis.Dao;

import org.apache.ibatis.annotations.Select;

import com.kcy.mybatis.bean.Employee;

public interface EmployeeMapperAnnotation {
	@Select("select id,name,age,email as e_mail from tbl_employee where id = #{id}")
	public Employee getEmployeeById(Integer id);
}
