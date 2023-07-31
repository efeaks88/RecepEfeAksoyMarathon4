package com.efeak.service;

import com.efeak.dto.request.KullaniciGirisDto;
import com.efeak.dto.request.KullaniciKayitDto;
import com.efeak.exception.EerrorType;
import com.efeak.exception.KullaniciServiceException;
import com.efeak.mapper.IKullaniciMapper;
import com.efeak.repository.IKullaniciRepository;
import com.efeak.repository.entity.Kullanici;
import com.efeak.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KullaniciService extends ServiceManager<Kullanici,Long> {
    private final IKullaniciRepository kullaniciRepository;

    public KullaniciService(IKullaniciRepository kullaniciRepository ) {
        super(kullaniciRepository);
        this.kullaniciRepository = kullaniciRepository;
    }

    public Kullanici kullaniciKayit(KullaniciKayitDto dto) {
        if (kullaniciRepository.existsByUsername(dto.getUsername())){
            throw new KullaniciServiceException(EerrorType.REGISTER_USERNAME_EXISTS);
        }
        Kullanici kullanici= IKullaniciMapper.INSTANCE.toKullanici(dto);
        save(kullanici);
        return kullanici;
    }

    public String kullaniciGiris(KullaniciGirisDto dto) {
        Optional<Kullanici> kullanici=kullaniciRepository.findOptionalByUsernameAndPassword(dto.getUsername(),dto.getPassword());
        if (kullanici.isEmpty()) throw new KullaniciServiceException(EerrorType.DOLOGIN_USERNAMEORPASSWORD_NOTEXISTS);
        return "Giriş başarılı";
    }

    public List<Kullanici> kullaniciListele() {
        return kullaniciRepository.findAll();
    }
}
