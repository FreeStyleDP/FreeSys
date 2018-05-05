package com.free.dao;

import com.free.entity.DO.Role;
import com.free.entity.DO.UserRole;
import java.util.List;

public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbggenerated Tue May 01 12:54:10 CST 2018
     */
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbggenerated Tue May 01 12:54:10 CST 2018
     */
    List<UserRole> selectAll();

	List<Role> selectByUserId(String id);
}