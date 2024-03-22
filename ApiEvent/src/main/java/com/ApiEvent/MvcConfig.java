package com.ApiEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.ServletContext;

@Configuration
public class MvcConfig implements WebMvcConfigurer  {
	
	@Autowired
	ServletContext context;
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {		
        registry
          .addResourceHandler("/**")
          .addResourceLocations("file:"+context.getRealPath("/"))
          .setCachePeriod(0);
    }
}
