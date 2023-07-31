package com.efeak.manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import static com.efeak.constants.EndPoints.*;

@FeignClient(name = "sehir-manager",url = "http://localhost:9093/sehir",decode404 = true)
public interface ISehirManager {
    @GetMapping(SEHIRPICK)
    public ResponseEntity<String> sehirpick();
}
