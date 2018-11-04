package com.lwh.springcloud.service;

import com.lwh.springcloud.entity.Dept;
import java.util.List;


/**
 * @author lwh
 * @date 2018-11-04
 * @desp
 */
public interface DeptService {
	boolean add(Dept dept);

	Dept get(Long id);

	List<Dept> list();
}
