package com.wang.seckillrabbit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.seckillrabbit.pojo.Goods;
import com.wang.seckillrabbit.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author jqwang
 * @since 2022-04-25
 */
public interface IGoodsService extends IService<Goods> {

    /**
     * @description:  获取商品列表
     * @param:
     * @return: java.util.List<com.wang.seckillrabbit.vo.GoodsVo>
     * @author jqwang
     * @date: 2022/4/25 21:25
     */
    List<GoodsVo> findGoodsVo();

    /**
     * @description: 根据商品id查询商品详情
     * @param: goodsId
     * @return: java.lang.String
     * @author jqwang
     * @date: 2022/4/25 21:48
     */
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
