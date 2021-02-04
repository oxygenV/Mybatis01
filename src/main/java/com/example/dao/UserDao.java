package com.example.dao;

import com.example.entity.User;

import java.util.List;

public interface UserDao {

    public User selById(Integer id);

    public Integer saveUser(User user);



}
