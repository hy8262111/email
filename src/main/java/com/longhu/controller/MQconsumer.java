package com.longhu.controller;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author: houyong
 * @description:
 * @create: 2019-06-11 11:07
 */
public class MQconsumer {
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


        //参数：String queue, boolean autoAck, Map<String, Object> arguments, com.rabbitmq.client.Consumer callback

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(consumerTag);
                System.out.println(envelope.getExchange());
                System.out.println(envelope.getRoutingKey());
                System.out.println(new String(body, "utf-8"));
            }
        };

        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
