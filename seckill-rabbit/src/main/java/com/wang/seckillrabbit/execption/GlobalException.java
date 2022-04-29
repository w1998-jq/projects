package com.wang.seckillrabbit.execption;

import com.wang.seckillrabbit.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jqwang
 * @version 1.0
 * @description: TODO
 * @date 2022/4/25 12:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException {
    private RespBeanEnum respBeanEnum;
}