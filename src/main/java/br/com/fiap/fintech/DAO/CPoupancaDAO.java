package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.model.CPoupanca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CPoupancaDAO {

    private Connection conexao;

    public CPoupancaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrarContaPoupanca(CPoupanca conta) {
        String sql = "INSERT INTO T_CPOUPANCA (CD_CONTA, TX_RENDIMENTOS) VALUES (?, ?)";


        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, conta.getCdConta());
            ps.setDouble(2, conta.getTxRendimento());
            ps.execute();
            System.out.println("Conta poupança cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar conta poupança.");
            e.printStackTrace();
        }
    }

    public boolean excluirContaPoupanca(int cdConta) {
        String sql = "DELETE FROM T_CPOUPANCA WHERE CD_CONTA = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, cdConta);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir conta poupança.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizarTxRendimento(int cdConta, double novoTxRendimento) {
        return atualizarCampoContaPoupanca(cdConta, "TX_RENDIMENTOS", novoTxRendimento);
    }

    private boolean atualizarCampoContaPoupanca(int cdConta, String nomeCampo, double novoValor) {
        String sql = "UPDATE T_CPOUPANCA SET " + nomeCampo + " = ? WHERE CD_CONTA = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setDouble(1, novoValor);
            ps.setInt(2, cdConta);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar " + nomeCampo + " da conta poupança.");
            e.printStackTrace();
            return false;
        }
    }
}
