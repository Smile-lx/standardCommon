package com.real.demo.util;

/**
 * @ClassName SM4_Context
 * @Description: TODO
 * @Author Smile
 * @Date 2021/5/19
 * @Version V1.0
 **/
public class SM4_Context {

    public int mode;

    public long[] sk;

    public boolean isPadding;

    public SM4_Context() {
        this.mode = 1;
        this.isPadding = true;
        this.sk = new long[32];
    }
}
