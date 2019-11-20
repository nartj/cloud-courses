package com.utbm.lo54.adminwebapp;

import com.utbm.lo54.core.SecurityConfiguration;
import com.utbm.lo54.core.courses.PersistenceConfiguration;
import com.utbm.lo54.core.users.UsersPersistenceConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() { return new Class[] { SecurityConfiguration.class, PersistenceConfiguration.class, UsersPersistenceConfiguration.class }; }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
