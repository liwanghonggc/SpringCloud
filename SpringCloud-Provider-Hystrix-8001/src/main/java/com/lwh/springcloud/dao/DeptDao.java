package com.lwh.springcloud.dao;


import com.lwh.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author lwh
 * @date 2018-11-04
 * @desp @Mapper注解,SpringBoot与Mybatis整合,需要添加该注解
 */
@Mapper
public interface DeptDao {

	/**
	 * 添加部门
	 * @param dept
	 * @return
	 */
	boolean addDept(Dept dept);

	/**
	 * 根据ID查找部门
	 * @param id
	 * @return
	 */
	Dept findById(Long id);

	/**
	 * 查找所有部门
	 * @return
	 */
	List<Dept> findAll();
}
