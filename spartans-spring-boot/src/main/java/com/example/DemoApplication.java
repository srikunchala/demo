package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import com.example.configuration.MvcConfiguration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
//@Import({MvcConfiguration.class})
@SpringBootApplication
@EnableWebMvc
public class DemoApplication extends SpringBootServletInitializer  {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }
//	  @Override
//	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//	        return application.sources(DemoApplication.class);
//	    }
//	 
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	
}
