package com.wang.seckillrabbit.config;

import net.sf.jsqlparser.statement.select.Top;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitMQTopicConfig
 * Description
 * @Author jqWang
 * Date 2022/4/29 17:01
 **/

@Configuration
public class RabbitMQTopicConfig {
    /*private static final  String QUEUE1 = "queue_topic01";
    private static final  String QUEUE2 = "queue_topic02";
    private static final String EXCHANGE = "topicExchange";
    private static final String ROUTINGKEY01 = "#.queue.#";
    private static final String ROUTINGKEY02 = "*.queue.#";
    @Bean
    public Queue queue01(){
        return new Queue(QUEUE1);
    }

    @Bean
    public Queue queue02(){
        return new Queue(QUEUE2);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding01(){
        return BindingBuilder.bind(queue01()).to(topicExchange()).with(ROUTINGKEY01);
    }


    @Bean
    public Binding binding02(){
        return BindingBuilder.bind(queue01()).to(topicExchange()).with(ROUTINGKEY02);
    }*/

    private static final String QUEUE = "seckillQueue";
    private static final String EXCHANGE = "seckillExchange";
    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE);
    }
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(topicExchange()).with("seckill.#");
    }
}
