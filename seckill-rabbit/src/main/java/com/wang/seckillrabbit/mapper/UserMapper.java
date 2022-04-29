package com.wang.seckillrabbit.mapper;

import com.wang.seckillrabbit.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2022-04-24
 */
@Repository
public interface UserMapper  {
    User selectById(String mobile);
}
