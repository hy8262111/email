package com.longhu.controller;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author: houyong
 * @description:
 * @create: 2019-06-11 11:36
 */
public class MQtopicsproducer {
    public static void main(String[] args) throws Exception {
        final String EXCHANGE_NAME = "topics_exchange";
        final String ROUTINGKEY_INFO = "info.#.info.#";
        final String ROUTINGKEY_ERROR = "info.#.error.#";
        final String QUEUE_INFO_NAME = "info_queue";
        final String QUEUE__ERROR_NAME = "error_queue";
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
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        //参数String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
        channel.queueDeclare(QUEUE_INFO_NAME, true, false, false, null);
        channel.queueDeclare(QUEUE__ERROR_NAME, true, false, false, null);

        //参数：String queue, String exchange, String routingKey
        channel.queueBind(QUEUE_INFO_NAME, EXCHANGE_NAME, ROUTINGKEY_INFO);
        channel.queueBind(QUEUE__ERROR_NAME, EXCHANGE_NAME, ROUTINGKEY_ERROR);

        //工作队列模式，不需要交换机
        //参数：String exchange, String routingKey, BasicProperties props, byte[] body
        String message = "你好，hello" + System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            channel.basicPublish(EXCHANGE_NAME, "info.info", null, message.getBytes());
        }


        for (int i = 0; i < 5; i++) {
            channel.basicPublish(EXCHANGE_NAME, "info.error", null, message.getBytes());
        }

    }
}
