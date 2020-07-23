package com.dzc.platoomcloud.search.biz.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * rabbitmq配置类
 * @author dzc
 * @date 2020/7/23
 */
public class RabbitmqConfig {

    //队列bean的名称
    public static final String QUEUE_SEARCH_BEAN = "queue_search_bean";
    //交换机的名称
    public static final String EX_ROUTING_SEARCH_EXCHANGE = "ex_routing_search_exchange";

    //队列的名称
    @Value("${search.mq.queue}")
    private String queue_name;
    //routingkey的名称
    @Value("${search.mq.routingkey}")
    private String routingkey;


    //声明交换机
    @Bean(EX_ROUTING_SEARCH_EXCHANGE)
    public Exchange EX_ROUTING_SEARCH_EXCHANGE(){
        //durable(true) 持久化，mq重启后交换机还在
        return ExchangeBuilder.topicExchange(EX_ROUTING_SEARCH_EXCHANGE).durable(true).build();
    }

    //声明队列
    @Bean(QUEUE_SEARCH_BEAN)
    public Queue QUEUE_SEARCH_BEAN(){
        return new Queue(queue_name);
    }


    //QUEUE_INFORM队列绑定交换机,指定routingkey
    @Bean
    public Binding BINDING_QUEUE_INFORM(@Qualifier(QUEUE_SEARCH_BEAN) Queue queue,
                                              @Qualifier(EX_ROUTING_SEARCH_EXCHANGE) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(routingkey).noargs();
    }
}
