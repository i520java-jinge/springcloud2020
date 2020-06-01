package com.i520java.springcloud.util;


import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 *
 * @ClassName:I520JavaBase64Util
 * @author: 金格[JIN_GE]
 * @date: 2020-04-29 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
public class I520JavaBase64Util {


    /**
     * 字符加密返回字符
     *
     * @param string
     * @return
     */
    public static String encode(String string) {
        return new String(Base64.encodeBase64(string.getBytes()));

    }

    /**
     * 指定编码格式 返回加密字符
     *
     * @param string 加密字符
     * @param encode 编码格式UTF-8
     * @return
     */
    public static String encode(String string, String encode) {
        byte[] array = null;
        try {
            array = string.getBytes(encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(array));

    }

    /**
     * 解密字符串
     *
     * @param string
     * @return
     */
    public static String decode(String string) {
        return new String(Base64.decodeBase64(string.getBytes()));
    }

    /**
     * 解密字符串 返回字节数组
     *
     * @param string
     * @return
     */
    public static byte[] decodeByte(String string) {
        return Base64.decodeBase64(string.getBytes());
    }


    public static String decode(byte[] key) {
        return new String(Base64.decodeBase64(key));

    }

    /**
     * 指定编码格式解密字符
     *
     * @param string
     * @param encode
     * @return
     */
    public static String decode(String string, String encode) {
        byte[] array = null;
        try {
            array = string.getBytes(encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new String(Base64.decodeBase64(array));
    }

}