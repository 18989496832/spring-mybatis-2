package com.kcy.mybatis.Dao;

import com.kcy.mybatis.bean.Department;

public interface DepartmentMapper {
	public Department getDeptById(Integer id);
	public Department getDeptAndEmpsById(Integer id);
}
