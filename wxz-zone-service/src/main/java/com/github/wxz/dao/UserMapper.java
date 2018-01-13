package com.github.wxz.dao;

import com.github.wxz.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -18:07
 */
@Mapper
public interface UserMapper {

    /**
     * getUserById
     *
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * getUserByName
     *
     * @param name
     * @return
     */
    User  getUserByName(@Param("name") String name);

    /**
     * updateProfilePhoto
     *
     * @param user
     */
    void updateProfilePhoto(User user);

    /**
     * updatePassWord
     *
     * @param user
     */
    void updatePassWord(User user);

    /**
     * addUser
     *
     * @param user
     * @return
     */
    User addUser(User user);

    /**
     * del
     *
     * @param user
     */
    @Delete("delete from wxz_zone_user where id =#{id}")
    void delete(User user);

}
