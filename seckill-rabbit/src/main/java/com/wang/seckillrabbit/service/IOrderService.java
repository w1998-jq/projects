package com.wang.seckillrabbit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.seckillrabbit.pojo.Order;
import com.wang.seckillrabbit.pojo.User;
import com.wang.seckillrabbit.vo.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jqwang
 * @since 2022-04-25
 */
public interface IOrderService extends IService<Order> {

    Order secKill(User user, GoodsVo goodsVo);
}
