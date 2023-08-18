package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dao;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/controller", "/main", "/insert", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Dao dao = new Dao();
	JavaBeans usuario = new JavaBeans();

    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			usuarios(request, response);
		} else if (action.equals("/insert")) {
			novoUsuario(request, response);
		} else if (action.equals("/select")) {
			listarUsuario(request, response);
		} else if (action.equals("/update")) {
			editarUsuario(request, response);
		} else if (action.equals("/delete")) {
			removerUsuario(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		//dao.testeConexao();
	}
	protected void usuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarUsuarios();
		request.setAttribute("usuarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
		rd.forward(request, response);
	}
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario.setNome(request.getParameter("nome"));
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setDocumento(request.getParameter("documento"));
		dao.inserirUsuario(usuario);
		response.sendRedirect("main");
	}
	protected void listarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricula = request.getParameter("matricula");
		usuario.setMatricula(matricula);
		dao.selecionarUsuario(usuario);
		request.setAttribute("matricula", usuario.getMatricula());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("endereco", usuario.getEndereco());
		request.setAttribute("documento", usuario.getDocumento());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
		
	}
	protected void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario.setMatricula(request.getParameter("matricula"));
		usuario.setNome(request.getParameter("nome"));
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setDocumento(request.getParameter("documento"));
		dao.alterarUsuario(usuario);
		response.sendRedirect("main");
	}
	protected void removerUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricula = request.getParameter("matricula");
		usuario.setMatricula(matricula);
		dao.excluirUsuario(usuario);
		response.sendRedirect("main");
	}
}
