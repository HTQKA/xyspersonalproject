package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User getJson(int id);

    public User querryLogin(@Param("name") String name, @Param("password")String password);
}
