package com.wang.seckillrabbit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jqwang
 * @version 1.0
 * @description: TODO
 * @date 2022/4/24 10:45
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","hello");
        return "hello";
    }
}