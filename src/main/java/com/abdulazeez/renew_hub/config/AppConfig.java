package com.abdulazeez.renew_hub.config;

import com.cloudinary.Cloudinary;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {


    @Value("${api_key}")
    private String API_KEY;

    @Value("${cloud.name}")
    private String CLOUD_NAME;

    @Value("${api.secret}")
    private String API_SECRET;

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", CLOUD_NAME);
        config.put("api_key", API_KEY);
        config.put("api_secret", API_SECRET);
        return new Cloudinary(config);
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }



}
