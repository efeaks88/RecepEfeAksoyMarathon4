package com.efeak.controller;

import com.efeak.exception.EerrorType;
import com.efeak.exception.SehirServiceException;
import com.efeak.repository.entity.Sehir;
import com.efeak.service.SehirService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.efeak.constants.EndPoints.*;

@RestController
@RequestMapping(SEHIR)
public class SehirController {
    private final SehirService sehirservice;
    public SehirController(SehirService sehirservice) {
        this.sehirservice = sehirservice;
    }

    @PostMapping(EKLE)
    public ResponseEntity<Sehir> sehirEkle(@RequestBody Sehir sehir) {
        Sehir yeniSehir = sehirservice.sehirEkle(sehir);
        return ResponseEntity.ok(yeniSehir);
    }

    @GetMapping("/{sehirId}")
    public ResponseEntity<Sehir> sehirGetir(@PathVariable Long sehirId) {
        Optional<Sehir> sehir = sehirservice.sehirGetir(sehirId);
        if (sehir != null) {
            return ResponseEntity.ok(sehir.get());
        } else {
            throw new SehirServiceException(EerrorType.SEHIR_BULUNAMADI);
        }
    }


    @GetMapping(SEHIRPICK)
    public ResponseEntity<String> sehirpick(){
        return ResponseEntity.ok(sehirservice.sehirpick()); //burası tahmin etme oyunu için bir tane şehir getiricek.
    }

}


