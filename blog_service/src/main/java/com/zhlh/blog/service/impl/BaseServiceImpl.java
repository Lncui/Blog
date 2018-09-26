package com.zhlh.blog.service.impl;


import com.zhlh.blog.mapper.BaseMapper;
import com.zhlh.blog.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	public abstract BaseMapper<T> getBaseMapper();

	private final static Logger log = LoggerFactory.getLogger(Class.class);

	@Override
	public T getByID(Integer id) {
		return getBaseMapper().selectByPrimaryKey(id);
	}

	@Override
	public List<T> pageList(T record) {
		return getBaseMapper().pageList(record);
	}

	@Override
	public Integer pageListCount(T record) {
		return getBaseMapper().pageListCount(record);
	}

	@Override
	public int insert(T obj) {
		return getBaseMapper().insertSelective(obj);
	}

	@Override
	public int delete(Integer id) {
		return getBaseMapper().deleteByPrimaryKey(id);
	}

	@Override
	public int update(T obj) {
		return getBaseMapper().updateByPrimaryKeySelective(obj);
	}

}
