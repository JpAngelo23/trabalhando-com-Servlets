package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.model.CCorrente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CCorrenteDAO {

    private Connection conexao;

    public CCorrenteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravarConta(CCorrente conta) {
        String sql = "INSERT INTO T_CCORRENTE (CD_CONTA, TX_JUROS, TX_IOF, TX_IR) VALUES (?, ?, ?, ?)";


        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, conta.getCdConta());
            ps.setDouble(2, conta.getTxJuros());
            ps.setDouble(3, conta.getTxIof());
            ps.setDouble(4, conta.getTxIr());
            ps.execute();
            ps.close();
            System.out.println("Conta gravada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao gravar a conta..");
            e.printStackTrace();
        }
    }

    // Métodos adicionais para excluir e atualizar

    // Método para excluir uma conta corrente
    public boolean excluirContaCorrente(int cdConta) {
        String sql = "DELETE FROM T_CCORRENTE WHERE CD_CONTA = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, cdConta);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir conta corrente.");
            e.printStackTrace();
            return false;
        }
    }

    // Método para atualizar a taxa de juros de uma conta corrente
    public boolean atualizarTxJuros(int cdConta, double novoTxJuros) {
        return atualizarCampoContaCorrente(cdConta, "TX_JUROS", novoTxJuros);
    }

    // Método para atualizar a taxa de IOF de uma conta corrente
    public boolean atualizarTxIof(int cdConta, double novoTxIof) {
        return atualizarCampoContaCorrente(cdConta, "TX_IOF", novoTxIof);
    }

    // Método para atualizar a taxa de IR de uma conta corrente
    public boolean atualizarTxIr(int cdConta, double novoTxIr) {
        return atualizarCampoContaCorrente(cdConta, "TX_IR", novoTxIr);
    }

    // Método genérico para atualizar campos de uma conta corrente
    private boolean atualizarCampoContaCorrente(int cdConta, String nomeCampo, double novoValor) {
        String sql = "UPDATE T_CCORRENTE SET " + nomeCampo + " = ? WHERE CD_CONTA = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setDouble(1, novoValor);
            ps.setInt(2, cdConta);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar " + nomeCampo + " da conta corrente.");
            e.printStackTrace();
            return false;
        }
    }
} // Fim da Classe.


