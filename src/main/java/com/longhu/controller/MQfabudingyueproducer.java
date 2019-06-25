package com.longhu.controller;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author: houyong
 * @description:发布订阅模式 exchange设置为fanout模式
 * 手机充值：短信和email都通知
 * @create: 2019-06-11 11:24
 */
public class MQfabudingyueproducer {
    public static void main(String[] args) throws Exception {
        final String EXCHANGE_NAME = "fanout";
        final String QUEUE_PHONE_NAME = "phone_queue";
        final String QUEUE__EMAIL_NAME = "email_queue";
        //1.连接  2.创建通道
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);

        Connection connection =
                connectionFactory.newConnection();

        Channel channel =
                connection.createChannel();

        //参数String exchange, BuiltinExchangeType type
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        //参数String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
        channel.queueDeclare(QUEUE_PHONE_NAME, true, false, false, null);
        channel.queueDeclare(QUEUE__EMAIL_NAME, true, false, false, null);

        //参数：String queue, String exchange, String routingKey
        channel.queueBind(QUEUE_PHONE_NAME, EXCHANGE_NAME, "");
        channel.queueBind(QUEUE__EMAIL_NAME, EXCHANGE_NAME, "");

        //工作队列模式，不需要交换机
        //参数：String exchange, String routingKey, BasicProperties props, byte[] body
        String message = "你好，hello" + System.currentTimeMillis();
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
    }
}
