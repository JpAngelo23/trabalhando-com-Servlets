package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    //--------------------------------------------------------------------------------------------------------------
    //Método para adicionar Cliente
    public void adicionarCliente(Cliente cliente) throws SQLException {
        // Consulta SQL para verificar se a pessoa existe
        String sqlVerificaPessoa = "SELECT COUNT(*) FROM T_PESSOA WHERE CD_PESSOA = ?";

        // Código SQL para inserir um novo cliente
        String sqlInsereCliente = "INSERT INTO T_CLIENTE (CD_CLIENTE, CD_PESSOA, DS_SENHA, DS_CONTA, DS_EMAIL) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement psVerifica = conexao.prepareStatement(sqlVerificaPessoa);
             PreparedStatement psInsere = conexao.prepareStatement(sqlInsereCliente)) {

            // Verifica se a pessoa existe
            psVerifica.setLong(1, cliente.getCdPessoa());
            ResultSet rs = psVerifica.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                throw new SQLException("Chave estrangeira para pessoa não existe.");
            }

            // Insere o cliente
            psInsere.setLong(1, cliente.getCdCliente());
            psInsere.setLong(2, cliente.getCdPessoa());
            psInsere.setString(3, cliente.getDsSenha());
            psInsere.setString(4, cliente.getDsConta());
            psInsere.setString(5, cliente.getEmail());
            int affectedRows = psInsere.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cliente adicionado com sucesso.");
                if (!conexao.getAutoCommit()) {
                    conexao.commit();
                }
            } else {
                System.out.println("Nenhuma linha inserida, falha ao adicionar cliente.");
            }
        } catch (SQLException e) {
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
            throw e;
        }
    }
//-------------------------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------------
//Método para Excluir Cliente:

    // Método para Excluir Cliente
    public void excluirCliente(long cdCliente) throws SQLException {
        // Código SQL para excluir um cliente com base no CD_CLIENTE
        String sqlExcluiCliente = "DELETE FROM T_CLIENTE WHERE CD_CLIENTE = ?";

        try (PreparedStatement psExclui = conexao.prepareStatement(sqlExcluiCliente)) {
            // Configura o CD_CLIENTE para a exclusão
            psExclui.setLong(1, cdCliente);

            // Executa o comando de exclusão
            int affectedRows = psExclui.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cliente com ID " + cdCliente + " excluído com sucesso.");
                if (!conexao.getAutoCommit()) {
                    conexao.commit();
                }
            } else {
                System.out.println("Nenhum cliente foi excluído. Cliente com ID " + cdCliente + " pode não existir.");
            }
        } catch (SQLException e) {
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
            throw e;
        }
    }




}//Fim da Classe
