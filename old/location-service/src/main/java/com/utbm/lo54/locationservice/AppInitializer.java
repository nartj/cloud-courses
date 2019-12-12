package com.utbm.lo54.locationservice;

import com.utbm.lo54.common.PersistenceConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() { return new Class[] { PersistenceConfiguration.class }; }

    @Override
    protected Class<?>[] getServletConfigClasses() { return new Class[] { WebMvcConfiguration.class }; }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
