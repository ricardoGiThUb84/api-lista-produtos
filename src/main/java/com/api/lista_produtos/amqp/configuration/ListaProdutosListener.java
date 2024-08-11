package com.api.lista_produtos.amqp.configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListaProdutosListener {

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){

        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory con, Jackson2JsonMessageConverter converter){

        RabbitTemplate rabbitTemplate = new RabbitTemplate(con);

        rabbitTemplate.setMessageConverter(converter);

        return rabbitTemplate;
    }
}
