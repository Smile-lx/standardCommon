package com.real.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.real.demo.model.po.User;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author Smile
 * @Date 2021/4/7
 * @Version V1.0
 **/
public interface UserService extends IService<User> {
    User getUserByName(String name);
}
