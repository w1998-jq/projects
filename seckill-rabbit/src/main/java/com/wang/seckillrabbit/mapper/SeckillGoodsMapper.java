package com.wang.seckillrabbit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.seckillrabbit.pojo.SeckillGoods;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 秒杀商品表 Mapper 接口
 * </p>
 *
 * @author jqwang
 * @since 2022-04-25
 */
@Repository
public interface SeckillGoodsMapper extends BaseMapper<SeckillGoods> {

    void delStock(Long goodsId);
}
