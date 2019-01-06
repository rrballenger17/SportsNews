package com.production;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.production.objects.User;

/**
 * Servlet implementation class ExpressionLanguageExample
 */
@WebServlet("/ExpressionLanguageExample")
public class ExpressionLanguageExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpressionLanguageExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		User newUser = new User();
		
		newUser.setAge(28);
		newUser.setFavoriteLanguage("Java");
		newUser.setFirstName("Ryan");
		newUser.setLastName("Ballenger");
		newUser.setLocation("Boston");
		
		request.setAttribute("user", newUser);
		
        request.getRequestDispatcher("/WEB-INF/jsp/expressionLanguageJsp.jsp")
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
