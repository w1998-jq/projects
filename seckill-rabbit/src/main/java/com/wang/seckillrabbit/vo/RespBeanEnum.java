package com.wang.seckillrabbit.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 公告返回对象枚举
 * @author jqwang
 * @version 1.0
 * @description: TODO
 * @date 2022/4/24 14:51
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    SUCCESS(200,"SUCCESS"),
    Login_ERROR(500210,"用户名或者密码不正确"),
    MOBILE_ERROR(500211,"手机号不正确"),


    BIND_ERROR(500212,"参数校验异常"),
    ERROR(500,"服务器错误"),

    EMPTY_STOCK(500500,"库存不足"),
    REPEATE_KILL(500501,"重复秒杀")

    ;
    private final Integer code;
    private final String message;
}