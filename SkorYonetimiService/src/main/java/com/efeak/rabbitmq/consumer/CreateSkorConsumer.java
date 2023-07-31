package com.efeak.rabbitmq.consumer;

import com.efeak.rabbitmq.model.SaveSkorModel;
import com.efeak.repository.entity.Skor;
import com.efeak.service.SkorService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSkorConsumer {
    private final SkorService skorService;
    @RabbitListener(queues = "queue-auth")
    private void createUserfromqueue(SaveSkorModel model){
        skorService.save(Skor.builder()
                        .username(model.getUsername())
                        .id(model.getSkorid())
                        .skor(model.getSkor())
                .build());
    }
}
