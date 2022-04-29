package com.wang.seckillrabbit.utils;

import java.util.UUID;

/**
 * @author jqwang
 * @version 1.0
 * @description: TODO
 * @date 2022/4/25 13:07
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}