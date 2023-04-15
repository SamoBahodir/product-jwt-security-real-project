package com.productexseption.rabbit.rabbit2.comsumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AmqpConfig {
    public static final String ROUTING_KEY = "default";

    public static final String RABBIT1_LEGAL_ENTITY_REQUEST = "rabbit1.legal_entity.integration.request";
    public static final String RABBIT1_LEGAL_ENTITY_RESPONSE = "rabbit1.legal_entity.integration.response";

    @Bean
    public RabbitTemplate rabbitTemplate( ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean()
    public SimpleRabbitListenerContainerFactory applicationListenerContainerFactory(ConnectionFactory connectionFactory,
                                                                                    Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jackson2JsonMessageConverter);
        factory.setConcurrentConsumers(10);
        factory.setMaxConcurrentConsumers(10);
        return factory;
    }

    @Bean
    public TopicExchange exchangeRequest() {
        return new TopicExchange(RABBIT1_LEGAL_ENTITY_REQUEST);
    }

    @Bean
    public Queue queueRequest() {
        return new Queue(RABBIT1_LEGAL_ENTITY_REQUEST, true);
    }

    @Bean
    public Binding bindingRequest() {
        return BindingBuilder
                .bind(queueRequest())
                .to(exchangeRequest())
                .with(ROUTING_KEY);
    }

    @Bean
    public TopicExchange exchangeResponse() {
        return new TopicExchange(RABBIT1_LEGAL_ENTITY_RESPONSE);
    }

    @Bean
    public Queue queueResponse() {
        return new Queue(RABBIT1_LEGAL_ENTITY_RESPONSE, true);
    }

    @Bean
    public Binding bindingResponse() {
        return BindingBuilder
                .bind(queueResponse())
                .to(exchangeResponse())
                .with(ROUTING_KEY);
    }

}
