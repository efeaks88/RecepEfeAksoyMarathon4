package com.efeak.controller;

import com.efeak.repository.entity.Skor;
import com.efeak.service.SkorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.efeak.constants.EndPoints.SKOR;

@RestController
@RequestMapping(SKOR)
public class SkorController {
    private final SkorService skorService;

    public SkorController(SkorService skorService) {
        this.skorService = skorService;
    }

    @PutMapping
    public ResponseEntity<Skor> skorGuncelle(@RequestBody String username, Long yeniSkor){
        return ResponseEntity.ok(skorService.skorguncelle(username,yeniSkor));
    }

    @PostMapping
    public ResponseEntity<Skor> skorartis(String username){
        return ResponseEntity.ok(skorService.skorArtis(username));
    }
    @PostMapping
    public ResponseEntity<Skor> skorazalis(String username){
        return ResponseEntity.ok(skorService.skorAzalis(username));
    }
}
