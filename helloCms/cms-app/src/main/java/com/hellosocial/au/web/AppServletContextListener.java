package com.hellosocial.au.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.logging.Logger;

import com.hellosocial.au.audit.AuditDAO;

@WebListener
public class AppServletContextListener implements ServletContextListener {

	private static final Logger logger = Logger
			.getLogger(AppServletContextListener.class);

	public void contextDestroyed(ServletContextEvent event) {

		logger.info(AuditDAO.Factory.get().destory());
	}

	public void contextInitialized(ServletContextEvent event) {
		logger.info(AuditDAO.Factory.get().ping());
	}

}
