package com.kcy.mybatis.bean;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("dept")
public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id ;
	private String  deptName;
	private List<Employee> emps;
	public Department(Integer id, String deptName) {
		this.id = id;
		this.deptName = deptName;
	}
	public Department() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", emps=" + emps + "]";
	}

}
