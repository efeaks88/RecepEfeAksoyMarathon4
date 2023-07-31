package com.efeak.service;

import com.efeak.repository.ISehirRepository;
import com.efeak.repository.entity.Sehir;
import com.efeak.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class SehirService extends ServiceManager<Sehir,Long> {
    private final ISehirRepository sehirRepository;

    public SehirService(ISehirRepository sehirRepository ) {
        super(sehirRepository);
        this.sehirRepository = sehirRepository;
    }

    public Sehir sehirEkle(Sehir sehir) {
        return sehirRepository.save(sehir);
    }

    public Optional<Sehir> sehirGetir(Long sehirId) {
        return sehirRepository.findById(sehirId);
    }

    public String sehirpick(){
        Random rd = new Random();
        Long x =rd.nextLong(0,sehirRepository.findAll().size()); //toplam şehir listesi kadar gidicek ve random bir x değeri dönsün
        return sehirRepository.findById(x).get().getBlurlu();
    }

}
