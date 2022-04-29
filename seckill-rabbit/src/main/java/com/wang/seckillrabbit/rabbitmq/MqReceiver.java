package com.wang.seckillrabbit.rabbitmq;

import com.wang.seckillrabbit.pojo.SeckillMessage;
import com.wang.seckillrabbit.pojo.User;
import com.wang.seckillrabbit.service.IGoodsService;
import com.wang.seckillrabbit.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MqReceiver
 * Description
 * @Author jqWang
 * Date 2022/4/29 15:53
 **/
@Service
@Slf4j
public class MqReceiver {
    @Autowired
    private IGoodsService goodsService;

    @RabbitListener(queues = "seckillQueue")
    public void receive(String msg) {
        log.info("接受到的消息：" + msg);
        SeckillMessage seckillMessage = JsonUtil.jsonStr2Object(msg, SeckillMessage.class);
        Long goodId = seckillMessage.getGoodId();
        User user = seckillMessage.getUser();
    }

    /*@RabbitListener(queues = "queue_fanout01")
    public void receive01(Object msg){
        log.info("queue01接受消息" + msg);
    }

    @RabbitListener(queues = "queue_fanout02")
    public void receive02(Object msg){
        log.info("queue02接受消息" + msg);
    }

    @RabbitListener(queues = "direct_fanout01")
    public void receive03(Object msg){
        log.info("direct_fanout01" + msg);
    }

    @RabbitListener(queues = "direct_fanout02")
    public void receive04(Object msg){
        log.info("direct_fanout02" + msg);
    }*/

}
