package com.production;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")

@WebServlet(
        name = "loginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    private static final Map<String, String> userDatabase = new Hashtable<>();

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
	        userDatabase.put("Nicholas", "password");
	        userDatabase.put("Sarah", "drowssap");
	        userDatabase.put("Mike", "wordpass");
	        userDatabase.put("John", "green");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//return;
		
		HttpSession session = request.getSession();
        
		if(session.getAttribute("username") != null)
        {
            response.sendRedirect("home");
            return;
        }
 
        request.setAttribute("loginFailed", false);
        
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
               .forward(request, response);
	}

	


	 

	
	
	
	
	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//doGet(request, response);
	
		HttpSession session = request.getSession();
        
		
		
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username == null || password == null ||
                !LoginServlet.userDatabase.containsKey(username) ||
                !password.equals(LoginServlet.userDatabase.get(username)))
        {
            request.getRequestDispatcher("WEB-INF/jsp/login.jsp")
                   .forward(request, response);
        }
        else
        {
            session.setAttribute("username", username);
            request.changeSessionId();
            response.sendRedirect("home");
        }	
        
	}

}
