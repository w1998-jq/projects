package com.wang.seckillrabbit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SeckillMessage
 * Description
 * @Author jqWang
 * Date 2022/4/29 19:52
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeckillMessage {
    private User user;
    private Long goodId;
}
