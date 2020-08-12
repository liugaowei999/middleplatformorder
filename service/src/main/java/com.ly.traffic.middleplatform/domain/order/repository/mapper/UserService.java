package com.ly.traffic.middleplatform.domain.order.repository.mapper;

import com.ly.traffic.middleplatform.domain.order.repository.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    // 注入mapper类
    @Resource
    private UserMapper userMapper;

    public User getUserById(long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public void add(User user) {
        userMapper.add(user);
    }
}
