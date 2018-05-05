package com.dp.dao;

import com.dp.entity.User;

public interface UserMapper {
    /**
     *
     * @mbggenerated 2018-05-05
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    int insert(User record);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    int insertSelective(User record);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    User selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbggenerated 2018-05-05
     */
    int updateByPrimaryKey(User record);
}