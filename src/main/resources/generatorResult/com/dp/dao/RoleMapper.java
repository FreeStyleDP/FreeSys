package com.dp.dao;

import com.dp.entity.Role;

public interface RoleMapper {
    /**
     *
     * @mbggenerated 2018-05-05
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    int insert(Role record);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    int insertSelective(Role record);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    Role selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    int updateByPrimaryKey(Role record);
}