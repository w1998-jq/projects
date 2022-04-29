package com.wang.seckillrabbit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.seckillrabbit.mapper.SeckillOrderMapper;
import com.wang.seckillrabbit.pojo.SeckillOrder;
import com.wang.seckillrabbit.service.ISeckillOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 秒杀订单表 服务实现类
 * </p>
 *
 * @author jqwang
 * @since 2022-04-25
 */
@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements ISeckillOrderService {

}
