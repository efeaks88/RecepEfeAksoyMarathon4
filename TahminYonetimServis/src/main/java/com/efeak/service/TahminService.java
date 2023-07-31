package com.efeak.service;

import com.efeak.manager.ISehirManager;
import com.efeak.repository.ITahminRepository;
import com.efeak.repository.entity.Tahmin;
import com.efeak.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class TahminService extends ServiceManager<Tahmin,Long> {
    private final ITahminRepository tahminRepository;
    private final ISehirManager sehirManager;


    public TahminService(ITahminRepository tahminRepository, ISehirManager sehirManager) {
        super(tahminRepository);
        this.tahminRepository = tahminRepository;
        this.sehirManager = sehirManager;
    }

    public boolean tahminet(String tahmin){
        String cevap= String.valueOf(sehirManager.sehirpick());
        if (cevap.equals(tahmin)){
            return true;
            //puan artması gleicek
        }
        return false;
        //puan azaltması
    }



}
