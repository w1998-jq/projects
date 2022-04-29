package com.wang.seckillrabbit.controller;


import com.wang.seckillrabbit.pojo.User;
import com.wang.seckillrabbit.vo.RespBean;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubin
 * @since 2022-04-24
 */
@Controller
@RequestMapping("/User")
public class UserController {

    /**
     * @description:  用户信息，测试专用
     * @param: user
     * @return: com.wang.seckillrabbit.vo.RespBean
     * @author jqwang
     * @date: 2022/4/26 13:34
     */
    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user){
        return RespBean.success(user);
    }

}
