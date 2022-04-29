package com.wang.seckillrabbit.vo;

import com.wang.seckillrabbit.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author jqwang
 * @version 1.0
 * @description: TODO
 * @date 2022/4/24 15:07
 */
@Data
public class LoginVo {
    @NotNull
    @IsMobile
    private String mobile;


    @NotNull
    @Length(min = 32)
    private String password;
}