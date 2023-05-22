package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Produto;
import Services.Services;


@WebServlet(urlPatterns = {"", "/home", "/novoproduto", "/produtos", "/alterarproduto"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Services service = new Services();

	public Controller() throws IOException {

    }
	



	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
        String method = request.getMethod();
        if(method.equals("GET")) {
        	System.out.println("teeeeeeste 1");
            doGet(request, response);
        }
        if(method.equals("POST")) {
        	String path = request.getServletPath();
        	
    		if (path.equals("/novoproduto")) {
    			doPost(request, response);
    		}
    		if (path.equals("/alterarproduto")) {
    			doPut(request, response);
    		}
            
        }
        if(method.equals("DELETE")) {
        	System.out.println("teeeeeeste 3");
            doDelete(request, response);
        }

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id =  Integer.parseInt(request.getParameter("id")) ;
		System.out.println(request.getParameter("id"));
		try {
			service.excluirProduto(id);
			response.setStatus(400, "deletado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String codigo = request.getParameter("codigo");
	 	String nome = request.getParameter("nome");
	 	String categoria = request.getParameter("categoria");
		float valor = Float.parseFloat(request.getParameter("valor"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade")) ;
		try {
			service.attProduto(id, codigo, nome, categoria, valor, quantidade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			request.setAttribute("listaProdutos", service.buscarTodosProduto());
			RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		// Entrara neste if caso o caminho passado seja vazio e redireciona para o /home
		if (path.equals("")) {
			response.sendRedirect("/projeto-backend/home");
		}
		
		if (path.equals("/home")) {

				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);

		}
		
		if (path.equals("/novoproduto")) {
			RequestDispatcher rd = request.getRequestDispatcher("novo-produto.jsp");
			rd.forward(request, response);
			System.out.println("Teste GET /novoproduto");			
		}
		if (path.equals("/produtos")) {
			try {
				request.setAttribute("listaProdutos", service.buscarTodosProduto());
				RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		if (path.equals("/alterarproduto")) {
			System.out.println(request.getParameter("id"));
			try {
				Produto produto = service.buscarProduto(request.getParameter("id"));
				request.setAttribute("produto", produto);
				RequestDispatcher rd = request.getRequestDispatcher("editar-produto.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Teste GET /alterarproduto");			
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	String codigo = request.getParameter("codigo");
	 	String nome = request.getParameter("nome");
	 	String categoria = request.getParameter("categoria");
		float valor = Float.parseFloat(request.getParameter("valor"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade")) ;
		try {
			service.novoProduto(codigo, nome, categoria, valor, quantidade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			request.setAttribute("listaProdutos", service.buscarTodosProduto());
			RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}




}
