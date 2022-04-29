package com.wang.seckillrabbit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.seckillrabbit.pojo.User;
import com.wang.seckillrabbit.vo.LoginVo;
import com.wang.seckillrabbit.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2022-04-24
 */
public interface IUserService {

    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    /**
     * @description:  根据cookie获取用户
     * @param: userTicket
     * @return: com.wang.seckillrabbit.pojo.User
     * @author jqwang
     * @date: 2022/4/25 14:38
     */
    User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response);
}
