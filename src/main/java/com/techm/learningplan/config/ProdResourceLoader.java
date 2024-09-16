package com.techm.learningplan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdResourceLoader implements ResourceLoader{
    @Override
    public String loadFile() {
        return "Prod Resource File Loaded";
    }
}
