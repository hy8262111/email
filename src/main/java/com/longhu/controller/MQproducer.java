package com.longhu.controller;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author: houyong
 * @description:
 * @create: 2019-06-11 10:59
 */
public class MQproducer {
    public static void main(String[] args) throws Exception {
        final String QUEUE_NAME = "queue1";
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

        //参数String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        //工作队列模式，不需要交换机
        //参数：String exchange, String routingKey, BasicProperties props, byte[] body
        String message = "你好，hello" + System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }

    }
}
