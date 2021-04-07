package com.real.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.real.demo.model.po.User;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author Smile
 * @Date 2021/4/7
 * @Version V1.0
 **/

@Repository
public interface UserMapper extends BaseMapper<User> {
}
