package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.junit.runners.Parameterized;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;

/**
 * @program: xyspersonalproject
 * @description: 登录控制器
 * @author: 徐杨顺
 * @created: 2020/12/12 20:16
 */
@Controller
public class LoginController {
    @Resource
    UserService userService;
    @RequestMapping("/login")
    public String hello() {

        return "login";
    }

    //接收前端传来的数据的几种方式
    //1.直接接收
    @RequestMapping("/verify_user_login1")
    public String verifyUserLogin1(String name, String password) {
        System.out.println("name is " + name);
        System.out.println("password id " + password);
        return "index";
    }

    //2.通过HttpServletRequest接收，post方式和get方式都可以
    @RequestMapping("/verify_user_login2")
    public String verifyUserLogin(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name);
        System.out.println(password);
        return "index";

    }

    //3.通过一个bean来接收
    @RequestMapping("/verify_user_login3")
    public String verifyUserLogin2(User user) {
        System.out.println("name is " + user.getName());
        System.out.println("password id " + user.getPassword());
        return "index";

    }

    //4.通过@ModelAttribute注解来接收
    @RequestMapping(value = "/verify_user_login4", method = RequestMethod.POST)
    public String verifyUserLogin(@ModelAttribute("user") User user) {
        System.out.println("4name is " + user.getName());
        System.out.println("4password id " + user.getPassword());
        return "index";

    }

    //5.通过绑定参数
    @RequestMapping(value = "/verify_user_login", method = RequestMethod.POST)
    public String verifyUserLogin5(@RequestParam("name") String name, @RequestParam("password") String password) {
        System.out.println("5name is " + name);
        System.out.println("5password id " + password);
        return "index";

    }

    //判断用户登录
    @RequestMapping("/islogin")
    @ResponseBody
    public String isLogin(@RequestParam("name") String name, @RequestParam("password") String password) {
        System.out.println("姓名:"+ name);
        System.out.println("密码:"+ password);

        boolean flag = userService.querryLogin(name, password);
        if (flag == true) {
            return "登录成功,用户名:" + name + "  密码:" + password;
        } else {
            return "登录失败";
        }

    }
}
