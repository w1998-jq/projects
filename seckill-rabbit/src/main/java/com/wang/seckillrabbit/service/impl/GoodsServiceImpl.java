package com.wang.seckillrabbit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.seckillrabbit.mapper.GoodsMapper;
import com.wang.seckillrabbit.pojo.Goods;
import com.wang.seckillrabbit.service.IGoodsService;
import com.wang.seckillrabbit.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author jqwang
 * @since 2022-04-25
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * @description: 获取商品列表
     * @param:
     * @return: java.util.List<com.wang.seckillrabbit.vo.GoodsVo>
     * @author jqwang
     * @date: 2022/4/25 21:25
     */
    @Override
    public List<GoodsVo> findGoodsVo() {
        return goodsMapper.findGoodsVo();
    }

    /**
     * @param goodsId
     * @description: 根据商品id查询商品详情
     * @param: goodsId
     * @return: java.lang.String
     * @author jqwang
     * @date: 2022/4/25 21:48
     */
    @Override
    public GoodsVo findGoodsVoByGoodsId(Long goodsId) {
        return goodsMapper.findGoodsVoByGoodsId(goodsId);
    }
}
