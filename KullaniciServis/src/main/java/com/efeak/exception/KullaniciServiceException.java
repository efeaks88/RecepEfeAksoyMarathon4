package com.efeak.exception;

import lombok.Getter;

@Getter
public class KullaniciServiceException extends RuntimeException{
    private final EerrorType type;

    public KullaniciServiceException(EerrorType type){
        super(type.getMesaj());
        this.type=type;
    }
    public KullaniciServiceException(EerrorType type, String mesaj){
        super(mesaj);
        this.type=type;
    }

}
