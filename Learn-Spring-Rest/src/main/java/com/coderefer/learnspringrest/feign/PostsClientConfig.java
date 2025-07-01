package com.coderefer.learnspringrest.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class PostsClientConfig {

    @Bean
    public Decoder feignDecoder() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        MappingJackson2HttpMessageConverter jacksonConverter = 
            new MappingJackson2HttpMessageConverter(objectMapper);

        ObjectFactory<HttpMessageConverters> objectFactory = 
            () -> new HttpMessageConverters(jacksonConverter);

        return new SpringDecoder(objectFactory);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new PostsClientErrorDecoder();
    }
} 