package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;

/**
 * @program: xyspersonalproject
 * @description: 学生类
 * @author: 徐杨顺
 * @created: 2020/12/14 10:04
 */

/*
@Data
注解在 类 上；提供类所有属性的 get 和 set 方法，此外还提供了equals、canEqual、hashCode、toString 方法。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    @NonNull
    private int id;
    private String name;
    private String cla;
    private String sex;
}
