package com.wang.seckillrabbit.execption;

import com.wang.seckillrabbit.vo.RespBean;
import com.wang.seckillrabbit.vo.RespBeanEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



/**
 * @author jqwang
 * @version 1.0
 * @description: TODO
 * @date 2022/4/25 12:45
 */
@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(Exception.class)
    public RespBean ExceptionHandler(Exception e){
        if(e instanceof GlobalException){
           GlobalException ex = (GlobalException) e;
            return RespBean.error(ex.getRespBeanEnum());

        }else if(e instanceof BindException){
            BindException ex = (BindException) e;
            RespBean respBean = RespBean.error(RespBeanEnum.BIND_ERROR);
            respBean.setMessage("参数校验异常：" +
                    ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return respBean;
        }
        return RespBean.error(RespBeanEnum.ERROR);
    }
}