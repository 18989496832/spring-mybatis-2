package com.kcy.mybatis.bean;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("employee")
public class Employee  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String age;
	private String e_mail;
	private Department dept;
	private String gendar;
	
	public Employee() {
		super();
	}
	public Employee(Integer id, String name, String age, String e_mail) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.e_mail = e_mail;
	}

	public String getGendar() {
		return gendar;
	}
	public void setGendar(String gendar) {
		this.gendar = gendar;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", e_mail=" + e_mail+"]";
	}

	
}
