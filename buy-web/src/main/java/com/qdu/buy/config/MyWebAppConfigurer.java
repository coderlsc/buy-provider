package com.qdu.buy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
public class MyWebAppConfigurer  extends WebMvcConfigurerAdapter {



    @Override

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

      registry.addResourceHandler("*/**").addResourceLocations("classpath:/static/");

        super.addResourceHandlers(registry);

    }



}
