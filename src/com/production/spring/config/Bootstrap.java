package com.production.spring.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.production.spring.config.RestServletContextConfiguration;
import com.production.spring.config.WebServletContextConfiguration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@SuppressWarnings("unused")
public class Bootstrap implements WebApplicationInitializer
{
	
    @Override
    public void onStartup(ServletContext container) throws ServletException
    {
    	// resources
        container.getServletRegistration("default").addMapping("/resource/*");

        // AnnotationConfigWebApplicationContext for root context 
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        // register the root context configuration class
        rootContext.register(RootContextConfiguration.class);
        // add context loader listener for root context AnnotationConfigWebApplicationContext
        container.addListener(new ContextLoaderListener(rootContext));

        
        // AnnotationConfigWebApplicationContext for web context
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        // register web context configuration class
        webContext.register(WebServletContextConfiguration.class);
        // add servlet named springWebDispatcher and servlet context dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet(
        		"springWebDispatcher", new DispatcherServlet(webContext)
        );
        // add load on startup and mapping for spring dispatcher
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/spring/*");
        
        
        // AnnotationConfigWebApplicationContext for rest context
        AnnotationConfigWebApplicationContext restContext = new AnnotationConfigWebApplicationContext();
        // register rest context configuration class
        restContext.register(RestServletContextConfiguration.class);
        // add servlet named springRestDispatcher and rest dispatcher servlet
        DispatcherServlet servlet = new DispatcherServlet(restContext);
        servlet.setDispatchOptionsRequest(true); // HTTP Options request handling
        ServletRegistration.Dynamic dispatcherTwo = container.addServlet(
                "springRestDispatcher", servlet
        );
        dispatcherTwo.setLoadOnStartup(2);
        dispatcherTwo.addMapping("/services/rest/*");
    
    }
}
