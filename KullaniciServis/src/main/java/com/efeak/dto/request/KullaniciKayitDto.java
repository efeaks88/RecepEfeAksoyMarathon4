package com.efeak.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KullaniciKayitDto {
    @NotBlank(message = "Kullanıcı adı boş geçilemez.")
    @Size(min=3,max=30)
    String username;
    @NotBlank(message = "Şifre boş geçilemez.")
    @Size(min=3,max = 20)
    String password;
    String repassword;
}
