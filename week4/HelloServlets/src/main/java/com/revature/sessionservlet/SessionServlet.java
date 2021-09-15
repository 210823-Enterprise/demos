package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SuperVillain mudman = new SuperVillain("Mud Man", "mud armor", 300);
		
		/**
		 * HttpSession is an interface provides us with the funcionality to store user information across our application
		 */
		HttpSession session = request.getSession();
		
		// this session can be retrieved later by a separate servlet 
		session.setAttribute("the-villain", mudman);
		
		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(mudman));
		out.println("Mud man is on the loose and the session is set");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Capture the input from the HTTP post request and create a java objhe
		
		String name = request.getParameter("name");
		String superpower = request.getParameter("superpower");
		double bounty = Double.parseDouble(request.getParameter("bounty")); // need to convert String to double
		
		
		// 2. Convert the capture params into an object by passing it thru the SuperVIllain Constructor
		SuperVillain vill = new SuperVillain(name, superpower, bounty);
		
		// 3. Grab the HttpSession from the request obj, 
		HttpSession session = request.getSession();
		
		// 4. and send the custom villain to the session
		session.setAttribute("the-villain", vill);
		
		
		// 5. Print to the screen that the villain obj has been set to the session
		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(vill));
		out.println("A villain is on the loose...(in the session)");
		
		// now we have to create a serv;et to retrieve the session
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
