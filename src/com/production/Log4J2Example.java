package com.production;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class Log4J2Example
 */
@WebServlet("/Log4J2Example")
public class Log4J2Example extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = LogManager.getLogger();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log4J2Example() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		log.info("GET method in the Log4J2 Servlet");
		
		log.warn("GET method in the Log4J2 Servlet - Warning");
		
		log.error("GET method in the Log4J2 Servlet - Error");
		
        request.getRequestDispatcher("/WEB-INF/jsp/log4j2.jsp")
        .forward(request, response);		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
