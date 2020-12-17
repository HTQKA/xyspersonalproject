package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

/**
 * @program: xyspersonalproject
 * @description: 测试控制器
 * @author: 徐杨顺
 * @created: 2020/12/12 18:33
 */
@Controller
@Api
public class TestController {
    @Autowired(required = false)
//    @Resource
    private User user;

    @Resource
    private UserService userService;

    @ApiOperation(value = "你好")
    @RequestMapping(value = "/hello")
    public String helloTest(@ApiParam(name = "name", value = "你好geder", required = true) String name) {
        return "hello";
    }

    //控制器返回json格式数据
    @RequestMapping("/returnJson")
    @ResponseBody
    public User returnJson() {
        user = userService.querryOne(1);
        return user;
    }

    //继承mybatis测试
    @RequestMapping("/mybatis")
    @ResponseBody
    public String mybatisTest(User user) {
        user = userService.querryOne(1);
        return user.toString();
    }
}
