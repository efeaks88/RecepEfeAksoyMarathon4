package com.efeak.service;

import com.efeak.exception.EerrorType;
import com.efeak.exception.SkorServiceException;
import com.efeak.rabbitmq.model.SaveKullaniciModel;
import com.efeak.rabbitmq.producer.CreateKullaniciProducer;
import com.efeak.repository.ISkorRepository;
import com.efeak.repository.entity.Skor;
import com.efeak.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class SkorService extends ServiceManager<Skor,Long> {
    private final ISkorRepository skorRepository;
    private final CreateKullaniciProducer createKullaniciProducer;

    public SkorService(ISkorRepository skorRepository, CreateKullaniciProducer createKullaniciProducer) {
        super(skorRepository);
        this.skorRepository = skorRepository;
        this.createKullaniciProducer = createKullaniciProducer;
    }

    public Skor skorguncelle(String username,Long yeniSkor){
        Skor skor=skorRepository.findByUsername(username);
        if (skor!=null){
            createKullaniciProducer.convertAndSend(SaveKullaniciModel.builder()
                    .username(skor.getUsername())
                    .skor(yeniSkor)
                    .build());
            return skorRepository.save(skor);
        }

        else {
            throw new SkorServiceException(EerrorType.Kullanıcı_BULUNAMADI);
        }
    }

    public Skor skorArtis(String username){
        Skor skor=skorRepository.findByUsername(username);
        if (skor!=null){
            skor.setSkor(skor.getSkor()+10);
            skorguncelle(username,skor.getSkor());
            return skor;
        }else {
            throw new SkorServiceException(EerrorType.Kullanıcı_BULUNAMADI);
        }
    }

    public Skor skorAzalis(String username){
        Skor skor=skorRepository.findByUsername(username);
        if (skor!=null){
             skor.setSkor(skor.getSkor()-5);
            skorguncelle(username,skor.getSkor());
            return skor;
        }else {
            throw new SkorServiceException(EerrorType.Kullanıcı_BULUNAMADI);
        }
    }

}
