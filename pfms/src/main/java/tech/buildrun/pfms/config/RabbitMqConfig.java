package tech.buildrun.pfms.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String PF_QUEUE = "pf-queue";
    public static final String PIX_EFETUADO_EXCHANGE = "pix-efetuado";

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue auditQueue() {
        return new Queue(PF_QUEUE);
    }

    @Bean
    public TopicExchange pixEfetuadoExchange() {
        return new TopicExchange(PIX_EFETUADO_EXCHANGE);
    }

    @Bean
    public Binding bindingQueueExchange(Queue pfQueue, TopicExchange pixEfetuadoExchange) {
        return BindingBuilder.bind(pfQueue).to(pixEfetuadoExchange).with("pf");
    }

}
