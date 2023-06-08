package com.berkansahan.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AkbankFinalCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(AkbankFinalCaseApplication.class, args);
    }

}
