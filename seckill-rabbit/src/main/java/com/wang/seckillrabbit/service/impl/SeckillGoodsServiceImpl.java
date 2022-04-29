package com.wang.seckillrabbit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.seckillrabbit.mapper.SeckillGoodsMapper;
import com.wang.seckillrabbit.pojo.SeckillGoods;
import com.wang.seckillrabbit.service.ISeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 秒杀商品表 服务实现类
 * </p>
 *
 * @author jqwang
 * @since 2022-04-25
 */
@Service
public class SeckillGoodsServiceImpl extends ServiceImpl<SeckillGoodsMapper, SeckillGoods> implements ISeckillGoodsService {
    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    @Override
    public void delStock(Long goodsId) {
        seckillGoodsMapper.delStock(goodsId);
    }
}
