package tech.buildrun.auditms.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String AUDIT_QUEUE = "audit-queue";
    public static final String PIX_EFETUADO_EXCHANGE = "pix-efetuado";

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue auditQueue() {
        return new Queue(AUDIT_QUEUE);
    }

    @Bean
    public TopicExchange pixEfetuadoExchange() {
        return new TopicExchange(PIX_EFETUADO_EXCHANGE);
    }

    @Bean
    public Binding bindingQueueExchange(Queue auditQueue, TopicExchange pixEfetuadoExchange) {
        return BindingBuilder.bind(auditQueue).to(pixEfetuadoExchange).with("*");
    }

}
