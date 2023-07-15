package com.example.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloServlate
 */
@WebServlet("/")
public class HelloServlate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlate() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("HelloServlate.init()");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("HelloServlate.destroy()");
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		System.out.println("HelloServlate.getServletConfig()");
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlate.doGet()");
		HttpSession session = request.getSession(false);
		if(session!= null && session.getAttribute("user")!=null) {
			response.sendRedirect("home.jsp");
		}else {
			response.sendRedirect( "login.jsp");
		}
		if (request.getRequestURI().contains("login")) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		if (request.getRequestURI().contains("logout")) {
			if(session!= null)
				session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp?error= User logout");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlate.doPost()");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(1000);
		System.out.println("Session is new :: " + session.isNew());
		
		if (username.equals(password)) {
			session.setAttribute("user", new User(username, password));

			UserStore userstore = new UserStore();
			userstore.setUsername(username);
			session.setAttribute("UserContext", userstore);
			if (userstore.isAlreadyLoggedIn()) {
				session.removeAttribute("UserContext"); // this will invoke valueUnbound method of UserStore
				throw new RuntimeException("You are already logged in from a different session. Please logout first.");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("login?error=failed");
			session.setAttribute("UserContext", null);
		}

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlate.doPut()");
	}

}
