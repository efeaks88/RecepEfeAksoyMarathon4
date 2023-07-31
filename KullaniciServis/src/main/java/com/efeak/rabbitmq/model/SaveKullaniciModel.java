package com.efeak.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveKullaniciModel implements Serializable {
    Long kullaniciid;
    String username;
    Long skor;
}
