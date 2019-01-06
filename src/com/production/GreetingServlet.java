package com.production;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetingServlet
 */
@WebServlet("/welcome")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreetingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException
    {
        System.out.println("Servlet " + this.getServletName() + " has started.");
    }    
    
    
    @Override
    public void destroy()
    {
        System.out.println("Servlet " + this.getServletName() + " has stopped.");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user = request.getParameter("user");
		
		String[] topics = request.getParameterValues("topic");
		
		String topicOutput = "";
		
		if(topics != null) {
			for(String topic: topics) {
				
				if(!topicOutput.equals("")) {
					topicOutput += ", ";
				}
				
				topicOutput += topic;
			}
		}
		

		
		
		
		if(user == null || user.equals("")) {
			user = "";
		}else {
			user += ", ";
		}
            
		
		
		LocalDateTime now =LocalDateTime.now();
		
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
              .append("<html>\r\n")
              .append("    <head>\r\n")
              .append("        <title>Welcome</title>\r\n")
              .append("    </head>\r\n")
              .append("    <body>\r\n")
             
      		.append("Welcome " + user + "to Sports News!")
			.append("<br/>The current time is: " + now.toString());
        
        
        	if(topics != null) {

            	writer.append("<br/>")
            		.append("Your favorite topics: " +topicOutput);
        		
        		
        	}


			
			
			writer.append("\n")
						.append("<br/><br/><br/>")
						.append("<form action='welcome' method='POST'>")
						.append("Enter your name: <input type='text' name='user' />")
						.append("<br/><br/>")
						.append("Select your favorite topics:")
						.append("<br/><input type='checkbox' name='topic' value='Politics' />Politics")
						.append("<br/><input type='checkbox' name='topic' value='Sports' />Sports")
						.append("<br/><input type='checkbox' name='topic' value='Technology' />Technology")

						
						.append("<br/><br/><input type='submit' value='Submit' />")
						.append("</form>");
			
              
              writer.append("    </body>\r\n")
              .append("</html>\r\n");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
