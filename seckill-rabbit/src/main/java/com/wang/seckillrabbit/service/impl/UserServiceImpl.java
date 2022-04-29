package com.wang.seckillrabbit.service.impl;

import com.wang.seckillrabbit.execption.GlobalException;
import com.wang.seckillrabbit.pojo.User;
import com.wang.seckillrabbit.mapper.UserMapper;
import com.wang.seckillrabbit.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.seckillrabbit.utils.CookieUtil;
import com.wang.seckillrabbit.utils.MD5Util;
import com.wang.seckillrabbit.utils.UUIDUtil;
import com.wang.seckillrabbit.utils.ValidatorUtil;
import com.wang.seckillrabbit.vo.LoginVo;
import com.wang.seckillrabbit.vo.RespBean;
import com.wang.seckillrabbit.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 * @since 2022-04-24
 */
@Service
public class UserServiceImpl  implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        /*if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
            return RespBean.error(RespBeanEnum.Login_ERROR);
        }
        if(!ValidatorUtil.isMobile(mobile)){
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }*/
        User user  = userMapper.selectById(mobile);
        if(user == null){
            //return RespBean.error(RespBeanEnum.Login_ERROR);
            throw new GlobalException(RespBeanEnum.Login_ERROR);
        }
        if(!MD5Util.fromPassToDBPass(password,user.getSalt()).equals(user.getPassword())){
            throw new GlobalException(RespBeanEnum.Login_ERROR);
            //return RespBean.error(RespBeanEnum.Login_ERROR);
        }
        //生成cookie
        String ticket = UUIDUtil.uuid();
        //将用户信息存入redis中
        redisTemplate.opsForValue().set("user:" + ticket,user);

        //request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success(ticket);
    }

    /**
     * @param userTicket
     * @description: 根据cookie获取用户
     * @param: userTicket
     * @return: com.wang.seckillrabbit.pojo.User
     * @author jqwang
     * @date: 2022/4/25 14:38
     */
    @Override
    public User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response) {
        if(StringUtils.isEmpty(userTicket)){
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user:" + userTicket);
        if(user != null){
            CookieUtil.setCookie(request,response,"userTicket",userTicket );
        }
        return user;
    }
}
