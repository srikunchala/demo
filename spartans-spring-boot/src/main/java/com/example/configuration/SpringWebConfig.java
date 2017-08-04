package com.example.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;



@EnableWebMvc
@Configuration
//@Import({DataBaseConfig.class})
@ComponentScan({"com.example"})
@PropertySource("classpath:application.properties")
public class SpringWebConfig extends WebMvcConfigurerAdapter {


	@Resource
	private Environment env;
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean 
	public FreeMarkerViewResolver freemarkerViewResolver() { 
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver(); 
		resolver.setCache(true); 
		resolver.setPrefix(""); 
		resolver.setSuffix(".ftl"); 
		return resolver; 
	}

	@Bean 
	public FreeMarkerConfigurer freemarkerConfig() { 
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer(); 
		freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/ftl/");
		return freeMarkerConfigurer; 
	}

	
	@Bean
	public ViewResolver contentNegotiatingViewResolver(
			ContentNegotiationManager manager) {
		 
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		resolvers.add(freemarkerViewResolver());
		
//		InternalResourceViewResolver r1 = new InternalResourceViewResolver();
//		r1.setPrefix("/WEB-INF/pages/");
//		r1.setSuffix(".jsp");
//		r1.setViewClass(JstlView.class);
//		resolvers.add(r1);
		
		JsonViewResolver r2 = new JsonViewResolver();
		resolvers.add(r2);
		
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(resolvers);
		resolver.setContentNegotiationManager(manager);
	    return resolver;
	    
	}
	public class JsonViewResolver implements ViewResolver {
		public View resolveViewName(String viewName, Locale locale)
				throws Exception {
				MappingJackson2JsonView view = new MappingJackson2JsonView();
				view.setPrettyPrint(true);
				return view;
		}
	}
	
	 
}