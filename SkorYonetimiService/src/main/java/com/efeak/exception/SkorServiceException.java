package com.efeak.exception;

import lombok.Getter;

@Getter
public class SkorServiceException extends RuntimeException{
    private final EerrorType type;

    public SkorServiceException(EerrorType type){
        super(type.getMesaj());
        this.type=type;
    }
    public SkorServiceException(EerrorType type, String mesaj){
        super(mesaj);
        this.type=type;
    }

}
