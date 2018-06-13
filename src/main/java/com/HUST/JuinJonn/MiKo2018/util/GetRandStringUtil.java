package com.HUST.JuinJonn.MiKo2018.util;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class GetRandStringUtil {

    private static Integer getRandom(int count) {
        Integer charNum = (int) Math.round(Math.random() * (count));
        return charNum;
    }

    private static String string = "abcdefghijklmnopqrstuvwxyz";

    public static String getRandomString(int length) {
        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len - 1)));
        }
        return sb.toString();
    }

    public static String EncoderByMd5(String str) {
        //确定计算方法
        String newstr = null;
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        }catch (NoSuchAlgorithmException e){
            log.error(e.getMessage());
        }catch (UnsupportedEncodingException e){
            log.error(e.getMessage());
        }
        return newstr;
    }
}
