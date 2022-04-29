package com.wang.seckillrabbit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.seckillrabbit.pojo.SeckillGoods;

/**
 * <p>
 * 秒杀商品表 服务类
 * </p>
 *
 * @author jqwang
 * @since 2022-04-25
 */
public interface ISeckillGoodsService extends IService<SeckillGoods> {

    void delStock(Long goodsId);
}
