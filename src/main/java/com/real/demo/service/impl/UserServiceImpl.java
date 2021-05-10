package com.real.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.real.demo.mapper.UserMapper;
import com.real.demo.model.po.User;
import com.real.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Author Smile
 * @Date 2021/4/7
 * @Version V1.0
 **/
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
