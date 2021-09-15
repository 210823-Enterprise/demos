package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.SuperVillain;

/**
 * Servlet implementation class HelperSessionServlet
 */
public class HelperSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// when we trigger a get request at this servlet, it will return the villain
		// object that's saved to the session
		
		// 1. Grab the session
		HttpSession session = request.getSession();
		
		// 2. Save the object retrieved from the session to a SuperVIllain object
		SuperVillain vill = (SuperVillain) session.getAttribute("the-villain");  // we set the villain objects to the session with the key(name) "the-villain"
		
		// 3/ After capturing the object, print the object's info to the screen
		PrintWriter out = response.getWriter();
		
		// Let's generate an html page on the fly!
		out.println("<html><body>");
		
			if (vill != null) {
				
				out.println("We have captured the villain from the session!");
				
				// Print out html that shows the properties of the villain object captured
				out.println("<h1>Villain Name: " + vill.getName() + "</h1><br />");
				out.println("<b>SUperpower: " + vill.getSuperPower() + " </b><br/>");
				out.println("<i>Bounty " + vill.getBounty() + " </i><br />");
				
			} else {
				out.println("<i>Couln't find any villains.</i>");
			}
		
		out.println("</body></html>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
