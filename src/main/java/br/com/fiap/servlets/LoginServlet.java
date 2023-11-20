package br.com.fiap.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.com.fiap.fintech.DAO.*;
import br.com.fiap.fintech.DataBase.*;
import br.com.fiap.fintech.model.*;


/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    // Simulando dados de usuário cadastrado
    private static final String USUARIO_EMAIL = "usuario@fiap.com";
    private static final String USUARIO_SENHA = "senha123";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.setContentType("text/html"); // Define o tipo de conteúdo como HTML
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); // Define o tipo de conteúdo como HTML
		
		
		
		//Tentativa de Login:
		//Recuperando os Parâmetros do formulário HTML
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		// Simulando verificação de login
        String emailDoUsuario = USUARIO_EMAIL;
        String senhaDoUsuario = USUARIO_SENHA;

        // Convertendo ambos para minúsculas (ou maiúsculas) antes de comparar
        if (email.toLowerCase().equals(emailDoUsuario.toLowerCase()) && senha.equals(senhaDoUsuario)) {
            // Login correto, redireciona para sucesso.jsp
            request.getRequestDispatcher("paginainicial.jsp").forward(request, response);
        } else {
            // Login incorreto, redireciona para 404.html
            response.sendRedirect("logininvalido.html");
        }
		
		doGet(request, response);
	}
	
    // Inclusão de método para manipular erros 404
    @Override
    protected void doError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        if (statusCode == 404) {
            // Erro 404, redireciona para 404.html
            response.sendRedirect("404.html");
        } else {
            // Outro erro, encaminha para a página de erro padrão
            super.doError(request, response);
        }
    }
}
