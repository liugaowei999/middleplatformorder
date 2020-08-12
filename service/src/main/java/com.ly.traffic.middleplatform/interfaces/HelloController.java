package com.ly.traffic.middleplatform.interfaces;

import com.alibaba.fastjson.JSON;
import com.ly.traffic.middleplatform.domain.order.repository.mapper.UserService;
import com.ly.traffic.middleplatform.domain.order.repository.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @Autowired
//    JdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;


    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String hello() {
//        String sql = "SELECT name FROM test_demo WHERE id = ?";
//        String mobile = "11";
//                // 通过jdbcTemplate查询数据库
//        mobile = (String)jdbcTemplate.queryForObject(
//                sql, new Object[] { 1 }, String.class);
        User user = userService.getUserById(1);
        System.out.println(JSON.toJSONString(user));

        return addUser();
    }

    @RequestMapping(value="/addUser", method=RequestMethod.POST)
    public String addUser() {
        User user = new User(1,"Json","157122","123","admin");
        userService.add(user);
        return JSON.toJSONString(user);
    }
}
