package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.model.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAO {

    private Connection conexao;

    // Método construtor que recebe a conexão como parâmetro
    public ContaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    //----------------------------------------------------------------------------------------------------------------------
    // Método cadastrarConta
    public void cadastrarConta(Conta conta) throws SQLException {
        // Consulta SQL para verificar se a instituição financeira e o cliente existem
        String sqlVerificaInstFinanc = "SELECT COUNT(*) FROM T_INSTFINANC WHERE NR_CNPJ = ?";
        String sqlVerificaCliente = "SELECT COUNT(*) FROM T_CLIENTE WHERE CD_CLIENTE = ?";

        // Código SQL para inserir uma nova conta
        String sqlInsereConta = "INSERT INTO T_CONTA (CD_CONTA, NR_CNPJ_INSTFINANC, CD_CLIENTE, CD_AGENCIA, NR_CONTA, VL_SALDO) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement psVerificaInstFinanc = conexao.prepareStatement(sqlVerificaInstFinanc);
             PreparedStatement psVerificaCliente = conexao.prepareStatement(sqlVerificaCliente);
             PreparedStatement psInsereConta = conexao.prepareStatement(sqlInsereConta)) {

            // Verifica se a instituição financeira existe
            psVerificaInstFinanc.setLong(1, conta.getCnpjInstFinanc());
            ResultSet rsInstFinanc = psVerificaInstFinanc.executeQuery();
            if (rsInstFinanc.next() && rsInstFinanc.getInt(1) == 0) {
                throw new SQLException("Chave estrangeira para instituição financeira não existe.");
            }

            // Verifica se o cliente existe
            long cdCliente = conta.getCdCliente();
            psVerificaCliente.setLong(1, cdCliente);
            ResultSet rsCliente = psVerificaCliente.executeQuery();
            if (rsCliente.next() && rsCliente.getInt(1) == 0) {
                throw new SQLException("Chave estrangeira para cliente não existe.");
            }


            // Insere a conta
            psInsereConta.setInt(1, conta.getCdConta());
            psInsereConta.setLong(2, conta.getCnpjInstFinanc());
            psInsereConta.setLong(3, cdCliente);
            psInsereConta.setInt(4, conta.getCdAgencia());
            psInsereConta.setString(5, conta.getNrConta());
            psInsereConta.setDouble(6, conta.getValorSaldo());
            int affectedRows = psInsereConta.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Conta cadastrada com sucesso.");
                if (!conexao.getAutoCommit()) {
                    conexao.commit();
                }
            } else {
                System.out.println("Nenhuma linha inserida, falha ao cadastrar conta.");
            }
        } catch (SQLException e) {
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao cadastrar conta: " + e.getMessage());
            throw e;
        }
    }
    // ----------------------------------------------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------------------------------------
    // Método excluirConta
    public void excluirConta(int cdConta) throws SQLException {
        // Código SQL para excluir uma conta
        String sqlExcluirConta = "DELETE FROM T_CONTA WHERE CD_CONTA = ?";

        try (PreparedStatement psExcluirConta = conexao.prepareStatement(sqlExcluirConta)) {
            // Configura o parâmetro para a exclusão da conta
            psExcluirConta.setInt(1, cdConta);

            // Executa a instrução SQL de exclusão
            int affectedRows = psExcluirConta.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Conta excluída com sucesso.");
                if (!conexao.getAutoCommit()) {
                    conexao.commit();
                }
            } else {
                System.out.println("Nenhuma linha excluída, conta não encontrada.");
            }
        } catch (SQLException e) {
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao excluir conta: " + e.getMessage());
            throw e;
        }
    }
    // ----------------------------------------------------------------------------------------------------------------------


} //Fim da classe.
