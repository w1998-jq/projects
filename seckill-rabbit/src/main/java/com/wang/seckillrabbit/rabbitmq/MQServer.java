package com.wang.seckillrabbit.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MQServer
 * Description
 * @Author jqWang
 * Date 2022/4/29 15:50
 **/
@Service
@Slf4j
public class MQServer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /*public void send(Object msg){
        log.info("发送消息：" + msg);
        rabbitTemplate.convertAndSend("fanoutExchange","",msg);
    }

    public void send01(Object msg){
        log.info("发送red消息 ：" + msg);
        rabbitTemplate.convertAndSend("directExchange","queue.red",msg);
    }
    public void send02(Object msg){
        log.info("发送green消息 ：" + msg);
        rabbitTemplate.convertAndSend("directExchange","queue.green",msg);
    }*/

    public void sendSeckillMessage(String message){
        log.info("发送消息：" + message);
        rabbitTemplate.convertAndSend("seckillExchange","seckill.message",message);
    }
}
