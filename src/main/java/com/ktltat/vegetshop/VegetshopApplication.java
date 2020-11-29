package com.ktltat.vegetshop;

import com.ktltat.vegetshop.api.SanPhamAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.io.File;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
public class VegetshopApplication {

    public static void main(String[] args) {
        new File(SanPhamAPI.uploadDirectory).mkdir();
        SpringApplication.run(VegetshopApplication.class, args);
    }

}
