package br.com.fiap.fintech.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USUARIO = "rm99328";
    private static final String SENHA = "260390";


    public static Connection abrirConexao() {
        Connection conexao = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conectado com Sucesso!");

        } catch (ClassNotFoundException e) {
            System.out.println("Falha na Conexão! Classe Não Encontrada.");
        } catch (SQLException e) {
            System.out.println("Erro de Conexão!");
        }

        return conexao;
    } //FimDo Método da Classe

} // Fim da Classe
