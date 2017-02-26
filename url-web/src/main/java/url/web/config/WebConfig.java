package url.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;
import url.core.config.AppConfig;

/**
 * Created by Thomas on 25/02/2017.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "url.web.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

    private final static Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        LOGGER.info("WebConfig addResourceHandlers(registry)");

        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/bootstrap/**").addResourceLocations("/resources/bootstrap/");
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/img/");
    }

    @Bean
    public VelocityConfigurer velocityConfigurer(){
        LOGGER.info("WebConfig velocityConfigurer()");

        VelocityConfigurer configurer = new VelocityConfigurer();
        configurer.setResourceLoaderPath("/WEB-INF/velocity");

        return configurer;
    }

    @Bean
    public VelocityViewResolver viewResolver(){
        LOGGER.info("WebConfig viewResolver()");

        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setSuffix(".vm");

        return resolver;

    }
}
