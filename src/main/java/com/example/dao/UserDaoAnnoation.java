package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserDaoAnnoation {

    @Select("select * from user where id=#{id}")
    public User selById(Integer id);

}
