package com.wwy.sample.springdata;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
@Order(1)
public class BootStrap implements WebApplicationInitializer{
    private static final Logger log = LoggerFactory.getLogger(BootStrap.class);

	public void onStartup(ServletContext container) throws ServletException {
		log.info("excute framework bootstrap");
		ServletRegistration defaultServlet = container.getServletRegistration("default");
		defaultServlet.addMapping("/static/*","/favicon.ico");

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootContextConfiguration.class);
		container.addListener(new ContextLoaderListener(rootContext));


		
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebContextConfiguration.class);
		ServletRegistration.Dynamic dispatcher = container.addServlet("springDispatcher",
				new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		

		FilterRegistration.Dynamic encodingFilter = container.addFilter("encodingFilter",
				new CharacterEncodingFilter("UTF-8", true));
		encodingFilter.addMappingForUrlPatterns(null, false, "/*");
		
	}

}
