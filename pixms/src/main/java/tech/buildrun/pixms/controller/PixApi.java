package tech.buildrun.pixms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static tech.buildrun.pixms.config.RabbitMqConfig.PIX_EFETUADO_EXCHANGE;

@RestController
public class PixApi {

    private final Logger logger = LoggerFactory.getLogger(PixApi.class);

    private final RabbitTemplate rabbitTemplate;

    public PixApi(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<Void> pix(@RequestBody PixReq req) {
        rabbitTemplate.convertAndSend(PIX_EFETUADO_EXCHANGE, req.channel(), req);
        logger.info("PIX MS - PIX SENT {}", req);
        return ResponseEntity.accepted().build();
    }
}
