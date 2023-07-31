package com.efeak.controller;

import com.efeak.service.TahminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.efeak.constants.EndPoints.*;

@RestController
@RequestMapping(TAHMIN)
public class TahminController {
    private final TahminService service;

    public TahminController(TahminService service) {
        this.service = service;
    }

    public ResponseEntity<String> tahminet(@RequestBody String tahmin) {
        if (service.tahminet(tahmin)) {
            return ResponseEntity.ok("Tahmininiz doğru");
            //skor arttırımı
        } else {
            return ResponseEntity.ok("Tahmininiz yanlış.");
            //skor azaltımı
        }
    }

}
