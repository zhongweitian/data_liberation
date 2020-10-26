package com.zwt.data_liberation.controller;

import com.zwt.data_liberation.pojo.master.User;
import com.zwt.data_liberation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 10:24
 */
@Controller
@RequestMapping(value = "/api/v1/test")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public User getUser(@RequestParam(value = "id") Long id) {
        User user = userService.getUser(id);
        //System.out.println(user.getUserName());
        return userService.getUser(id);
    }
}

