package com.efeak.rabbitmq.consumer;

import com.efeak.rabbitmq.model.SaveKullaniciModel;
import com.efeak.repository.entity.Kullanici;
import com.efeak.service.KullaniciService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateKullaniciConsumer {
    private final KullaniciService kullaniciService;
    @RabbitListener(queues = "queue-auth")
    private void createUserfromqueue(SaveKullaniciModel model){
        kullaniciService.save(Kullanici.builder()
                        .username(model.getUsername())
                        .id(model.getKullaniciid())
                        .skor(model.getSkor())
                .build());
    }
}
