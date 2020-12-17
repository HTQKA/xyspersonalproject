package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

/**
 * @program: xyspersonalproject
 * @description: User实体类
 * @author: 徐杨顺
 * @created: 2020/12/12 20:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
    private String address;
    private String phone;


}
