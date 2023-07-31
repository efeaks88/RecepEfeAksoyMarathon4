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
    Kullanici_BULUNAMADI(1003,"Böyle bir kullanici yoktur bulunamadı.",NOT_FOUND),
    REGISTER_PASSWORD_MISMATCH(1004,"Girilen parolalar uyuşmadı.",BAD_REQUEST),
    DOLOGIN_USERNAMEORPASSWORD_NOTEXISTS(1006,"Kullanıcı adı veya şifre hatalı.",HttpStatus.BAD_REQUEST),
    REGISTER_USERNAME_EXISTS(1005,"Kullanıcı adı daha önce alınmış.",HttpStatus.BAD_REQUEST);
    private int code;
    private String mesaj;
    private HttpStatus status;
}
