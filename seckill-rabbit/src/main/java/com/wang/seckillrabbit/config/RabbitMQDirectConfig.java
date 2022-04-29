/*
package com.wang.seckillrabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @ClassName RabbitMQDirectConfig
 * Description
 * @Author jqWang
 * Date 2022/4/29 16:45
 **//*

@Configuration
public class RabbitMQDirectConfig {
    private static final  String QUEUE1 = "direct_fanout01";
    private static final  String QUEUE2 = "direct_fanout02";
    private static final String EXCHANGE = "directExchange";
    private static final String ROUTINGKEY01 = "queue.red";
    private static final String ROUTINGKEY02 = "queue.green";

    @Bean
    public Queue queue01(){
        return new Queue(QUEUE1);
    }

    @Bean
    public Queue queue02(){
        return new Queue(QUEUE2);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding binding01(){
        return BindingBuilder.bind(queue01()).to(directExchange()).with(ROUTINGKEY01);
    }


    @Bean
    public Binding binding02(){
        return BindingBuilder.bind(queue01()).to(directExchange()).with(ROUTINGKEY02);
    }
}
*/
