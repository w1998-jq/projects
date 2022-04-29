package com.wang.seckillrabbit.utils;

import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author jqwang
 * @version 1.0
 * @description: TODO
 * @date 2022/4/24 13:08
 */
public class MD5Util {
    private static String slat = "1a2b3c4d";
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    public static String inputPasswordToFromPass(String inputPass){
        String str = "" + slat.charAt(0) + slat.charAt(2) + inputPass + slat.charAt(5) + slat.charAt(4);
        return md5(str);

    }
    public static String fromPassToDBPass(String fromPass,String slat){
        String str = "" + slat.charAt(0) + slat.charAt(2) + fromPass + slat.charAt(5) + slat.charAt(4);
        return md5(str);
    }
    public static String inputPassToDBPass(String inputPass,String salt){
        String fromPass = inputPasswordToFromPass(inputPass);
        String dbPass = fromPassToDBPass(fromPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        //System.out.println(fromPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9", slat));
        //System.out.println(inputPasswordToFromPass("123456"));
        //System.out.println(inputPassToDBPass("123456",slat));
    }

}