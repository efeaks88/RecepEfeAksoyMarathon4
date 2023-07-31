package com.efeak.rabbitmq.producer;

import com.efeak.rabbitmq.model.SaveKullaniciModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateKullaniciProducer {
    private final RabbitTemplate rabbitTemplate;
    public void convertAndSend(SaveKullaniciModel model){
        rabbitTemplate.convertAndSend("direct-exchange-auth","save-binding-key",model);
    }
}
