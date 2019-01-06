package com.production.filters;

import java.io.IOException;
import java.time.Instant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class RequestLogFilter
 */
@WebFilter("/RequestLogFilter")
public class RequestLogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RequestLogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
        Instant time = Instant.now();
			
        try {
        	chain.doFilter(request, response);
        }finally {

        	HttpServletRequest in = (HttpServletRequest)request;
        	HttpServletResponse out = (HttpServletResponse)response;
            
        	String length = out.getHeader("Content-Length");
            
        	if(length == null || length.length() == 0)
                length = "-";
            
        	System.out.println("Client IP: " +in.getRemoteAddr() + " "
            		+ " Time: " + time + " " +
                    " HTTP Method: " + in.getMethod() + " " 
            		+ "Request URL: " + in.getRequestURI() + " "
                    + "Protocol: " + in.getProtocol() + " " 
            		+ "Status: " + out.getStatus() + " " 
                    + "Length: " + length );
        
        }
	
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
