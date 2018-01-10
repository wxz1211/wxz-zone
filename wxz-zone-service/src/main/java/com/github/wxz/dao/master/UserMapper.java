package com.github.wxz.dao.master;

import com.github.wxz.entity.User;
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


}
