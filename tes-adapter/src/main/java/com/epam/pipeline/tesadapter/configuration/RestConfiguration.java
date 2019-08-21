package com.epam.pipeline.tesadapter.configuration;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@Configuration
public class RestConfiguration implements WebMvcConfigurer {

    @Bean
    public HttpMessageConverters customConverters() {
        HttpMessageConverter<Object> addition = new MappingJackson2HttpMessageConverter();
        return new HttpMessageConverters(false, Collections.singletonList(addition));
    }
}