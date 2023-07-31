package com.efeak.rabbitmq.producer;

import com.efeak.rabbitmq.model.SaveSkorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSkorProducer {
    private final RabbitTemplate rabbitTemplate;
    public void convertAndSend(SaveSkorModel model){
        rabbitTemplate.convertAndSend("direct-exchange-auth","save-binding-key",model);
    }
}
