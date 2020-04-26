package com.dressup.demo.config;

import com.dressup.demo.models.Brand;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import com.dressup.demo.models.UserAuthority;
import com.dressup.demo.utils.StringToEntityConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.dressup.demo.utils")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/static/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/static/css/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/resources/static/fonts/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/403").setViewName("error/access_denied");
        registry.addViewController("/about").setViewName("static/about");
    }

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addConverter(itemGenericConverter());
        formatterRegistry.addConverter(lookGenericConverter());
        formatterRegistry.addConverter(userAuthorityGenericConverter());
        formatterRegistry.addConverter(brandGenericConverter());
    }

    @Bean
    public StringToEntityConverter itemGenericConverter(){
        return new StringToEntityConverter(Item.class);
    }
    @Bean
    public StringToEntityConverter lookGenericConverter(){
        return new StringToEntityConverter(Look.class);
    }
    @Bean
    public StringToEntityConverter brandGenericConverter(){
        return new StringToEntityConverter(Brand.class);
    }
    @Bean
    public StringToEntityConverter userAuthorityGenericConverter(){
        return new StringToEntityConverter(UserAuthority.class);
    }
}