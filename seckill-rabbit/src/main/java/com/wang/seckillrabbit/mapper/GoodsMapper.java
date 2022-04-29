package com.wang.seckillrabbit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.seckillrabbit.pojo.Goods;
import com.wang.seckillrabbit.vo.GoodsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author jqwang
 * @since 2022-04-25
 */
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * @description:  获取商品列表
     * @param:
     * @return: java.util.List<com.wang.seckillrabbit.vo.GoodsVo>
     * @author jqwang
     * @date: 2022/4/25 21:27
     */
    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
