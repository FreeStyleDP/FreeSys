package com.dp.dao;

import com.dp.entity.Permission;

public interface PermissionMapper {
    /**
     *
     * @mbggenerated 2018-05-05
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    int insert(Permission record);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    int insertSelective(Permission record);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    Permission selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    int updateByPrimaryKey(Permission record);
}