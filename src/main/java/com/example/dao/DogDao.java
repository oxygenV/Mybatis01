package com.example.dao;

import com.example.entity.Dog;

public interface DogDao {
    public Dog selectDogById(Integer id);
}
