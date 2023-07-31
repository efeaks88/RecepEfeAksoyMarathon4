package com.efeak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SkorServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkorServiceApplication.class);
    }
}