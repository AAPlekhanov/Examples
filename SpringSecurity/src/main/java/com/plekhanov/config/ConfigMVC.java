package com.plekhanov.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import java.util.List;


@Configuration
public class ConfigMVC extends WebMvcConfigurationSupport {

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(new MappingJackson2HttpMessageConverter());
        //converters.add(new MappingJackson2HttpMessageConverter(objectMapper)); //Можно добавить кастомный  ObjectMapper
    }




}
