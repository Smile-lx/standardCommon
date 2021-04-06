package com.real.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName RealTestApi
 * @Description: 测试类
 * @Author Smile
 * @Date 2021/4/6
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RealTestApi.class)
public class RealTestApi {
    @Test
    public void test(){
        System.out.println("real");
    }
}
