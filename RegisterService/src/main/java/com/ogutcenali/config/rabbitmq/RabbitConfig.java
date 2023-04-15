package com.ogutcenali.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private String exchange = "direct-exchange-register-auth";
    private String quequeRegisterUser = "queque-register-user";
    private String keyRegisterUser = "keyRegisterUser";

    private String quequeRegisterFromSupport = "queuqe-register-from-support";

    private String keyRegisterFromSupport = "key-register-support";

    private String quequeRegisterRestaurant = "queque-register-restaurant";
    private String keyRegisterRestaurant = "keyRegisterRestaurant";

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Queue quequeRegisterUser() {
        return new Queue(quequeRegisterUser);
    }

    @Bean
    Binding registerUser(DirectExchange directExchange, Queue quequeRegisterUser) {
        return BindingBuilder.bind(quequeRegisterUser).to(directExchange).with(keyRegisterUser);
    }


    @Bean
    Queue quequeRegisterFromSupport() {
        return new Queue(quequeRegisterFromSupport);
    }

    @Bean
    Binding registerRestaurantFromSupport(DirectExchange directExchange, Queue quequeRegisterFromSupport) {
        return BindingBuilder.bind(quequeRegisterFromSupport).to(directExchange).with(keyRegisterFromSupport);
    }


    @Bean
    Queue quequeRegisterRestaurant() {
        return new Queue(quequeRegisterRestaurant);
    }

    @Bean
    Binding registerRestaurant(DirectExchange directExchange, Queue quequeRegisterRestaurant) {
        return BindingBuilder.bind(quequeRegisterRestaurant).to(directExchange).with(keyRegisterRestaurant);
    }

}
