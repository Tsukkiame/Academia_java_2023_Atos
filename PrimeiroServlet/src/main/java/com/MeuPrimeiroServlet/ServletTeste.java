package com.MeuPrimeiroServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTeste
 */
@WebServlet(urlPatterns = {"/get", "/", "/main"})
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   /* public ServletTeste() {
        super();
        // TODO Auto-generated constructor stub
    } não usaremos metodos*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/get")||request.getServletPath().equals("/")) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<!doctype html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Hello Servlet Teste</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello Servlet Teste</h1>");
            out.println("Gustavo Andrés Diaz - Teste Servlet\n");
            out.println("Primeira página dinâmica em HTML");
            out.println("</body>");
            out.println("</html>");
		}
            
		response.getWriter().append("\nServed at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
