package com.real.demo.util;


import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;

/**
 * @ClassName AesEncryptUtils
 * @Description: Aes 数据加密工具类
 * @Author Smile
 * @Date 2020/11/16
 * @Version V1.0
 **/
public class AesEncryptUtils {


    /**
     * 加密
     *
     * @param content    加密的字符串
     * @param encryptKey 加密需要的key
     * @return 返回加密之后的值
     * @throws Exception xx
     */
    public static String encrypt(String content, String encryptKey) {
        //对内容进行处理
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String ts = String.valueOf(timeInMillis);
        String realContent = content + "@" + ts;
        byte[] decodedKey = Base64.getUrlDecoder().decode(encryptKey);
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(realContent.getBytes(StandardCharsets.UTF_8));
            return Base64.getUrlEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            throw new RuntimeException("Error occured while encrypting data", e);
        }

    }

    /**
     * 解密
     *
     * @param encryptStr 解密的字符串
     * @param decryptKey 解密需要的key
     * @return 返回解密之后的值
     * @throws Exception xx
     */
    public static String decrypt(String encryptStr, String decryptKey) {
        byte[] decodedKey = Base64.getUrlDecoder().decode(decryptKey);
        try {
            Cipher cipher = Cipher.getInstance("AES");
            // rebuild key using SecretKeySpec
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.DECRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(Base64.getUrlDecoder().decode(encryptStr));
            return new String(cipherText);
        } catch (Exception e) {
            throw new RuntimeException("Error occured while decrypting data", e);
        }
    }

    /**
     * 校验时间规则
     *
     * @param content     解密的字符串
     * @param millis      限制时间
     * @param realContent 真实信息
     */
    public static boolean checkTime(String content, int millis, String realContent) {
        if (!StringUtils.isEmpty(content)) {
            if (content.contains("@")) {
                String[] split = content.split("@");
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                if (split.length > 2) {
                    int i = content.lastIndexOf("@");
                    String sendTime = content.substring(i, content.length() - 1);
                    if (timeInMillis - Long.parseLong(sendTime) <= millis) {
                        return realContent.equals(content.substring(0, i));
                    }
                } else {
                    String sendTime = split[1];
                    if (timeInMillis - Long.parseLong(sendTime) <= millis * 1000) {
                        return realContent.equals(split[0]);
                    }
                }
            }
        }
        return false;
    }


}
