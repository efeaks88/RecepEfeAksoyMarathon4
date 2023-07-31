package com.efeak.exception;

import lombok.Getter;

@Getter
public class TahminServiceException extends RuntimeException{
    private final EerrorType type;

    public TahminServiceException(EerrorType type){
        super(type.getMesaj());
        this.type=type;
    }
    public TahminServiceException(EerrorType type, String mesaj){
        super(mesaj);
        this.type=type;
    }

}
