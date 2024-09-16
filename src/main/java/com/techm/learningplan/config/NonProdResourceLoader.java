package com.techm.learningplan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Configuration
@Profile("!prod")
public class NonProdResourceLoader implements ResourceLoader{
    @Override
    public String loadFile() {
        return "NonProd Resource File Loaded";
    }
}
