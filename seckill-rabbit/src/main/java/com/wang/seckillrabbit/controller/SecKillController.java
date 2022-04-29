package com.wang.seckillrabbit.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wang.seckillrabbit.pojo.Order;
import com.wang.seckillrabbit.pojo.SeckillOrder;
import com.wang.seckillrabbit.pojo.User;
import com.wang.seckillrabbit.service.IGoodsService;
import com.wang.seckillrabbit.service.IOrderService;
import com.wang.seckillrabbit.service.ISeckillOrderService;
import com.wang.seckillrabbit.vo.GoodsVo;
import com.wang.seckillrabbit.vo.RespBean;
import com.wang.seckillrabbit.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jqwang
 * @version 1.0
 * @description: TODO
 * @date 2022/4/25 22:36
 */
@Controller
@RequestMapping("/seckill")
public class SecKillController {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ISeckillOrderService seckillOrderService;

    @Autowired
    private IOrderService orderService;

    /**
     * @description:  秒杀前优化：2699
     * @param: model
     * @param: user
     * @param: goodsId
     * @return: java.lang.String
     * @author jqwang
     * @date: 2022/4/26 15:21
     */
    @RequestMapping("/doSeckill")
    public String doSecKill(Model model, User user,Long goodsId) {
        if(user == null){
            return "login";
        }
        model.addAttribute("user",user);
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        if(goodsVo.getStockCount() < 1){
            System.out.println("没有库存");
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return "secKillFail";
        }
        //判断是否重复抢购
        SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));
        if(seckillOrder != null){
            model.addAttribute("errmsg",RespBeanEnum.REPEATE_KILL.getMessage());
            return "secKillFail";
        }
        Order order =  orderService.secKill(user,goodsVo);
        model.addAttribute("order",order);
        model.addAttribute("goods",goodsVo);
        return "orderDetail";
    }
}