package com.cbms.common;

/**
 * PRODUCT        : CBMS
 * FUNCTION       : WebFilter
 * AUTHOR         : Dilan Indrajith
 * CREATED DATE   : February 2016
 * VERSION        : 1.0
 * REMARKS        :  
 */

import java.io.IOException;

/**
 * PRODUCT        : Stock Management
 * FUNCTION       : Web Filter
 * AUTHOR         : Asela Liyanage
 * CREATED DATE   : October 2014
 * VERSION        : 2.0
 * REMARKS        :  
 * PROPERTY OF WISDOM
 */
import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cbms.web.login.LoginBean;

public class WebFilter implements Filter {

	/**
	 * Checks if user is logged in. If not it redirects to the login.xhtml page.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Get the loginBean from session attribute

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		if (!httpRequest.getRequestURI().startsWith(httpRequest.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) {

			httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

			httpResponse.setHeader("Pragma", "no-cache");
			httpResponse.setDateHeader("Expires", 0);
		}

		LoginBean loginBean = (LoginBean) ((HttpServletRequest) request).getSession().getAttribute("LoginBean");

		// For the first application request there is no LoginBean in the
		// session so user needs to log in
		// For other requests loginBean is present but we need to check if user
		// has logged in successfully

		if (loginBean == null || !loginBean.isLoggedIn()) {

			String contextPath = ((HttpServletRequest) request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath + "/sessionTimeout.xhtml");
		}

		chain.doFilter(request, response);

	}

	public void init(FilterConfig config) throws ServletException {
		// Nothing to do here!
	}

	public void destroy() {
		// Nothing to do here!
	}

}
