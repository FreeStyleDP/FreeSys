package com.free.shiro.dao;

import java.util.List;

import com.free.shiro.entity.DO.Menu;


public interface MenuMapper {
    /**
     *
     * @mbggenerated 2018-05-11
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-11
     */
    int insert(Menu record);

    /**
     *
     * @mbggenerated 2018-05-11
     */
    int insertSelective(Menu record);

    /**
     *
     * @mbggenerated 2018-05-11
     */
    Menu selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-11
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     *
     * @mbggenerated 2018-05-11
     */
    int updateByPrimaryKey(Menu record);

	List<Menu> selectMenuByUserId(String id);

	List<Menu> selectAll();
}