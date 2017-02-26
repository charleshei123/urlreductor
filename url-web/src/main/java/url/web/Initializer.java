package url.web;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import url.core.config.AppConfig;
import url.core.config.DBConfig;
import url.web.config.WSConfig;
import url.web.config.WebConfig;
import url.web.controller.WebController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Thomas on 25/02/2017.
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        LOGGER.info("Initializer onStartup(servletContext)");

        super.onStartup(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("cxfServlet", new CXFServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/api/*");
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        LOGGER.info("Initializer getRootConfigClasses()");

        return new Class<?>[] { AppConfig.class, DBConfig.class, WSConfig.class };
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        LOGGER.info("Initializer getServletConfigClasses()");

        return new Class<?>[] { WebConfig.class };
    }


    @Override
    protected String[] getServletMappings() {
        LOGGER.info("Initializer getServletMappings()");

        return new String[] { "/" };
    }
}
