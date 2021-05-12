package com.real.demo.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @ClassName LeetCode
 * @Description: TODO
 * @Author Smile
 * @Date 2021/5/12
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeeCode {
    //给定数组删除排序数组的重复项
    @Test
    public int removeDuplicates(int[] nums) {
        //算法思路就是计算出出现
        if (null != nums && nums.length > 0) {
            int count = 0;
            for (int right = 1; right < nums.length; right++) {
                if (nums[right] == nums[right - 1]) {
                    count++;
                } else nums[right - count] = nums[right];
            }
            return nums.length - count;
        }
        return 0;
    }
    //判读是否包含重复项
    @Test
    public boolean containsDuplicate(int[] nums) {
        if (null != nums && nums.length > 0) {
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }




}
