package com.wang.seckillrabbit.controller;

import com.wang.seckillrabbit.pojo.User;
import com.wang.seckillrabbit.service.IGoodsService;
import com.wang.seckillrabbit.service.IUserService;
import com.wang.seckillrabbit.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author jqwang
 * @version 1.0
 * @description: TODO
 * @date 2022/4/25 13:13
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IGoodsService goodsService;

    /*@RequestMapping("/toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model, @CookieValue("userTicket") String ticket){
        if(StringUtils.isEmpty(ticket)){
            return "login";
        }
        User user = userService.getUserByCookie(ticket, request, response);
        //User user = (User)session.getAttribute(ticket);
        if(user == null){
            return "login";
        }
        model.addAttribute("user",user);

        return "goodsList";
    }*/
    /**
     * windows 优化前QPS ： 3765
     * @description:
     * @param: model
     * @param: user
     * @return: java.lang.String
     * @author jqwang
     * @date: 2022/4/26 14:03
     */
    @RequestMapping("/toList")
    public String toList(Model model, User user) {
        model.addAttribute("user", user);
        model.addAttribute("goodsList", goodsService.findGoodsVo());
        return "goodsList";
    }

    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId) {
        model.addAttribute("user", user);
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        int secKillStatus = 0;
        int remainSeconds = 0;
        if(nowDate.before(startDate)){
            //秒杀未开始
            remainSeconds = ((int) ((startDate.getTime() - nowDate.getTime()) / 1000));
        }else if(nowDate.after(endDate)){
            //秒杀已经结束
            remainSeconds = -1;
            secKillStatus = 2;
        }else{
            secKillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("remainSeconds",remainSeconds);
        model.addAttribute("secKillStatus",secKillStatus);
        model.addAttribute("goods",goodsVo);
        return "goodsDetail";
    }
}