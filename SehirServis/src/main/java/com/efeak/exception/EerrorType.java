package com.efeak.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EerrorType {
    SEHIR_BULUNAMADI(1003,"Böyle bir şehir yoktur bulunamadı.",NOT_FOUND),
    REGISTER_PASSWORD_MISMATCH(1004,"Girilen parolalar uyuşmadı.",BAD_REQUEST),
    URUN_EKLEME_HATASI(2001,"Ürün ekleme başarısız oldu",INTERNAL_SERVER_ERROR);

    private int code;
    private String mesaj;
    private HttpStatus status;
}
