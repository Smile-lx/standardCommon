package com.real.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description: 项目与初始化执行类
 * @author: xpl
 * @date: 2019-12-05 18:29
 */
@Component
@Slf4j
public class
InitUtils {

    /**
     * 预加载数据
     */
    @PostConstruct
    public void init() {
        System.out.println("项目初始化打印一句话~~~~~~~");
    }
}
