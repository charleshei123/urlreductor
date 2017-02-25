package url.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

/**
 * Created by Thomas on 25/02/2017.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "url.web.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/bootstrap/**").addResourceLocations("/resources/bootstrap/");
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/img/");
    }

    @Bean
    public VelocityConfigurer velocityConfigurer(){
        VelocityConfigurer configurer = new VelocityConfigurer();
        configurer.setResourceLoaderPath("/WEB-INF/velocity");
        return configurer;
    }

    @Bean
    public VelocityViewResolver viewResolver(){
        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setSuffix(".vm");
        return resolver;

    }
}
