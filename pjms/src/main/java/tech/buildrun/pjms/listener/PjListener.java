package tech.buildrun.pjms.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static tech.buildrun.pjms.config.RabbitMqConfig.PJ_QUEUE;

@Component
public class PjListener {

    private final Logger logger = LoggerFactory.getLogger(PjListener.class);

    @RabbitListener(queues = PJ_QUEUE)
    public void listen(Message<PixReq> message){
        logger.info("PJ - Message consumed: {}", message);
    }
}
