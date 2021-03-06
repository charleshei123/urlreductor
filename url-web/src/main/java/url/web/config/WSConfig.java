package url.web.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import url.core.config.AppConfig;
import url.web.controller.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Thomas on 25/02/2017.
 */
@Configuration
@ComponentScan(basePackages = "url.web.controller")
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
public class WSConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Inject
    private Bus cxfBus;

    @Inject
    private List<RestController> controllers;

    @Bean
    public Server jaxrsServer(JacksonJsonProvider jsonProvider){
        LOGGER.info("WSConfig jaxrsServer(jsonProvider)");

        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        List<Object> serviceBeans = new ArrayList<Object>();
        serviceBeans.addAll(controllers);
        sf.setServiceBeans(serviceBeans);
        sf.setProviders(Arrays.asList(jsonProvider));
        sf.setAddress("/");
        sf.setBus(cxfBus);

        return sf.create();
    }

    @Bean
    public JacksonJsonProvider jsonProvider() {
        LOGGER.info("WSConfig jsonProvider()");

        return new JacksonJsonProvider();
    }
}
