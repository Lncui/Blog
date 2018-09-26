package com.zhlh.blog.mapper;


import java.util.List;

public interface BaseMapper<T> {

	/**
	 * 方法描述: 根据主键删除单条数据<br>
	 *
	 * @param id 主键
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);


	/**
	 * 方法描述: 插入数据（全部属性插入）<br>
	 *
	 * @param record 对象
	 * @return
	 */
	int insert(T record);

	/**
	 * 方法描述: 插入数据（只插入不为null的属性）<br>
	 *
	 * @param record 对象
	 * @return
	 */
	int insertSelective(T record);

	/**
	 * 方法描述: 根据主键查询对象<br>
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	T selectByPrimaryKey(Integer id);

	/**
	 * 方法描述: 根据条件分页查询pageList<br>
	 *
	 * @param record 对象
	 * @return List
	 */
	List<T> pageList(T record);

	/**
	 * 方法描述: 根据条分页查询pageListCount<br>
	 *
	 * @param record 对象
	 * @return Integer
	 */
	Integer pageListCount(T record);


	/**
	 * 方法描述: 更新数据（只插入不为null的属性）<br>
	 *
	 * @param record 对象
	 * @return
	 */
	int updateByPrimaryKeySelective(T record);

	/**
	 * 方法描述: 更新数据（全部属性更新）<br>
	 *
	 * @param record 对象
	 * @return
	 */
	int updateByPrimaryKey(T record);

}
