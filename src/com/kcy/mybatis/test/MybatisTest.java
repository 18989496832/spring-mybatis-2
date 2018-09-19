package com.kcy.mybatis.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.kcy.mybatis.Dao.DepartmentMapper;
import com.kcy.mybatis.Dao.EmployeeMapper;
import com.kcy.mybatis.Dao.EmployeeMapperAnnotation;
import com.kcy.mybatis.Dao.EmployeeMapperPlus;
import com.kcy.mybatis.bean.Department;
import com.kcy.mybatis.bean.Employee;

public class MybatisTest {
	private static Logger logger = Logger.getLogger(MybatisTest.class);
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	/***
	 */
	@Test
	public void testMy1() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Employee employee = employeeMapper.getEmployeeById(1);
			System.out.println(employee.toString());
		} finally {
			session.close();
		}
	}
	/***
	 */
	@Test
	public void testMy2() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			EmployeeMapperAnnotation employeeMapper = session.getMapper(EmployeeMapperAnnotation.class);
			Employee employee= employeeMapper.getEmployeeById(2);
			System.out.println(employee.toString());
		}finally {
			session.close();
		}
	}
	/***
	 */
	@Test
	public void testMy3() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			//add
			Employee emp = new Employee(null, "jerry2","19", "jerry2@qq.com");
			employeeMapper.addEmp(emp);
			System.out.println(emp.getId());
			session.commit();
		}finally {
			session.close();
		}
	}
	@Test
	public void testMy4() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession(true);
		try {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Map<String, Object> params = new HashMap();
			params.put("id", 1);
			params.put("name", "tom");
			Employee employee = employeeMapper.getEmployeeByMap(params);
			System.out.println(employee.getE_mail());
		}finally {
			session.close();
		}
	}
	@Test
	public void testMy5() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession(true);
		try {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			List<Employee> emps = employeeMapper.getEmployeeByNameLike("%e%");
			System.out.println(emps);
		}finally {
			session.close();
		}
	}
	@Test
	public void test6() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession(true);
		try {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Map<String,Object> map = employeeMapper.getEmployeeByIdRetMap(1);
			System.out.println(map);
		}finally {
			session.close();
		}
	}
	@Test
	public void test7() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession(true);
		try {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Map<Integer,Employee> map = employeeMapper.getEmployeeByNameLikeRetMap("%e%");
			System.out.println(map);
		}finally {
			session.close();
		}
	}
	@Test
	public void test8() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession(true);
		try {
			EmployeeMapperPlus mapperPlus = session.getMapper(EmployeeMapperPlus.class);
			Employee employee= mapperPlus.getEmployeeById(2);
			System.out.println(employee);
		}finally {
			session.close();
		}
	}
	@Test
	public void test9() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession(true);
		try {
			EmployeeMapperPlus mapperPlus = session.getMapper(EmployeeMapperPlus.class);
			Employee employee= mapperPlus.getEmployeeAndDeptById(2);
			System.out.println(employee.getName());
		}finally {
			session.close();
		}
	}
	@Test
	public void testMy10() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession(true);
		try {
			EmployeeMapperPlus mapperPlus = session.getMapper(EmployeeMapperPlus.class);
			Employee employee= mapperPlus.getEmployeeAndDeptByStep(2);
			System.out.println(employee);
			System.out.println(employee.getDept());
		}finally {
			session.close();
		}
	}
	@Test
	public void test11() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession(true);
		try{
			EmployeeMapperPlus mapperPlus = session.getMapper(EmployeeMapperPlus.class);
		}finally {
			session.close();
		}
	}
	@Test
	public void testMy12() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession(true);
		try{
			DepartmentMapper mapperDept = session.getMapper(DepartmentMapper.class);
			Department dept = mapperDept.getDeptAndEmpsById(2);
			System.out.println(dept);
		}finally {
			session.close();
		}
	}
	@Test
	public void test13() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession(true);
		try{
			EmployeeMapperPlus mapperDept = session.getMapper(EmployeeMapperPlus.class);
			Employee emp = new Employee();
			//emp.setName("jerry2");
			emp.setId(2);
			Employee empRet = mapperDept.getEmpByDynamicCondition(emp);
			System.out.println(empRet);
		}finally {
			session.close();
		}
	}
	/***
	 */
	@Test
	public void testMy14() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		SqlSession session2 = getSqlSessionFactory().openSession();
		try {
			EmployeeMapperPlus employeeMapper = session.getMapper(EmployeeMapperPlus.class);
			Employee employee= employeeMapper.getEmployeeById(2);
			System.out.println(employee.toString());
			session.close();
			EmployeeMapperPlus employeeMapper2 = session2.getMapper(EmployeeMapperPlus.class);
			Employee employee2= employeeMapper2.getEmployeeById(2);
			System.out.println(employee2.toString());
			session2.close();
		}finally {
			session.close();
		}
	}
}
