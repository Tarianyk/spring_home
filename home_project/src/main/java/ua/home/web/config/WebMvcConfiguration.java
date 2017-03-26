package ua.home.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@Configuration
@EnableWebMvc
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    private static final String DIRECTORY = "E:\\images\\";

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("10MB");
        factory.setMaxRequestSize("10MB");
        createDirectory();
        factory.setLocation(DIRECTORY);
        return factory.createMultipartConfig();
    }

    private void createDirectory() {
        File file = new File(DIRECTORY);
        if (!file.exists()) {
            if (file.mkdir()) {
                log.info("Directory is created!");
            } else {
                log.warn("Failed to create directory!");
            }
        }
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/pages/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

}
