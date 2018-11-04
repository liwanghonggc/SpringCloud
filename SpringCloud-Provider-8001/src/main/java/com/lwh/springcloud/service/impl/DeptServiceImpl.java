package com.lwh.springcloud.service.impl;

import java.util.List;

import com.lwh.springcloud.dao.DeptDao;
import com.lwh.springcloud.entity.Dept;
import com.lwh.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author lwh
 * @date 2018-11-04
 * @desp
 */
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao dao;
	
	@Override
	public boolean add(Dept dept)
	{
		return dao.addDept(dept);
	}

	@Override
	public Dept get(Long id)
	{
		return dao.findById(id);
	}

	@Override
	public List<Dept> list()
	{
		return dao.findAll();
	}

}
