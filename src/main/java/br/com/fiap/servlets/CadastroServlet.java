package br.com.fiap.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.com.fiap.fintech.model.*;

@WebServlet("/cadastroservlet")
public class CadastroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CadastroServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Captura dos dados do formulário HTML
        String nome = request.getParameter("nm_nome");
        String telefone = request.getParameter("tel_contato");
        String email = request.getParameter("ds_email");
        String tipoConta = request.getParameter("tipo_conta");

        // Verifica se é Pessoa Física ou Jurídica
        if ("pf".equals(tipoConta)) {
            String cpf = request.getParameter("nr_cpf");
            String rg = request.getParameter("nr_rg");

            
        } else if ("pj".equals(tipoConta)) {
            String cnpj = request.getParameter("nr_cnpj");
            String inscMunicipal = request.getParameter("ds_inscmunic");

            // Agora você tem os dados, e pode utilizá-los conforme necessário
        }

        String cep = request.getParameter("nr_cep");
        String complemento = request.getParameter("ds_complemento");
        String senha = request.getParameter("ds_senha");

        // Agora você tem todos os dados e pode utilizá-los conforme necessário

        // Exemplo de como imprimir os dados para verificar
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
        System.out.println("Tipo de Conta: " + tipoConta);

        // Aqui você pode prosseguir com o armazenamento ou processamento dos dados

        // Redirecionamento ou resposta ao usuário
        response.sendRedirect("pagina-de-sucesso.html");
    }
}
