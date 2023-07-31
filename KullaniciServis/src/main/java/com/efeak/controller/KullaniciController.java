package com.efeak.controller;

import com.efeak.dto.request.KullaniciKayitDto;
import com.efeak.exception.EerrorType;
import com.efeak.exception.KullaniciServiceException;
import com.efeak.repository.entity.Kullanici;
import com.efeak.service.KullaniciService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.efeak.constants.EndPoints.*;

@RestController
@RequestMapping(KULLANİCİ)
public class KullaniciController {
    private final KullaniciService kullaniciService;

    public KullaniciController(KullaniciService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }
    @PostMapping(KAYİT)
    public ResponseEntity<Kullanici> kullaniciKayit(@RequestBody @Valid KullaniciKayitDto dto) {
        if (!dto.getPassword().equals(dto.getRepassword()))
            throw new KullaniciServiceException(EerrorType.REGISTER_PASSWORD_MISMATCH);
        return ResponseEntity.ok(kullaniciService.kullaniciKayit(dto));
    }

    @GetMapping(LISTELE)
    public ResponseEntity<List<Kullanici>> findAll() {
        return ResponseEntity.ok(kullaniciService.findAll());
    }

}
