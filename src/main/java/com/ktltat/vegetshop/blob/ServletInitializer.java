package com.ktltat.vegetshop.blob;

import com.ktltat.vegetshop.VegetshopApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 21/11/2020
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VegetshopApplication.class);
    }
}