package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.model.Movimentacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovimentacaoDAO {

    private Connection conexao;

    // Método construtor que recebe a conexão como parâmetro
    public MovimentacaoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    //---------------------------------------------------------------------------------------
    // Método para cadastrar movimentação:
    public void cadastrarMovimentacao(Movimentacao movimentacao) throws SQLException {
        // Consulta SQL para verificar se a conta existe
        String sqlVerificaConta = "SELECT COUNT(*) FROM T_CONTA WHERE CD_CONTA = ?";

        // Código SQL para inserir uma nova movimentação
        String sqlInsereMovimentacao = "INSERT INTO T_MOVIMENTACAO (CD_MOVIMENTACAO, CD_CONTA, DS_MOVIMENTACAO, " +
                "VL_MOVIMENTACAO, TP_CATEGORIA, DT_DATA, DS_RECORRENCIA) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement psVerificaConta = conexao.prepareStatement(sqlVerificaConta);
             PreparedStatement psInsereMovimentacao = conexao.prepareStatement(sqlInsereMovimentacao)) {

            // Verifica se a conta existe
            int cdConta = movimentacao.getCdConta();
            psVerificaConta.setInt(1, cdConta);
            ResultSet rsConta = psVerificaConta.executeQuery();
            if (rsConta.next() && rsConta.getInt(1) == 0) {
                throw new SQLException("Chave estrangeira para conta não existe.");
            }

            // Insere a movimentação
            psInsereMovimentacao.setInt(1, movimentacao.getCdMovimentacao());
            psInsereMovimentacao.setInt(2, movimentacao.getCdConta());
            psInsereMovimentacao.setString(3, movimentacao.getDsMovimentacao());
            psInsereMovimentacao.setDouble(4, movimentacao.getValorMovimentacao());
            psInsereMovimentacao.setString(5, movimentacao.getCategoria());
            psInsereMovimentacao.setString(6, movimentacao.getData());
            psInsereMovimentacao.setString(7, movimentacao.getRecorrencia());

            int affectedRows = psInsereMovimentacao.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Movimentação cadastrada com sucesso.");
                if (!conexao.getAutoCommit()) {
                    conexao.commit();
                }
            } else {
                System.out.println("Nenhuma linha inserida, falha ao cadastrar movimentação.");
            }
        } catch (SQLException e) {
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao cadastrar movimentação: " + e.getMessage());
            throw e;
        }
    }

    //---------------------------------------------------------------------------------------
    // Método para excluir movimentação
    public void excluirMovimentacao(Movimentacao movimentacao) throws SQLException {
        // Código SQL para excluir a movimentação
        String sqlExcluiMovimentacao = "DELETE FROM T_MOVIMENTACAO WHERE CD_MOVIMENTACAO = ?";

        try (PreparedStatement psExcluiMovimentacao = conexao.prepareStatement(sqlExcluiMovimentacao)) {
            // Exclui a movimentação
            psExcluiMovimentacao.setInt(1, movimentacao.getCdMovimentacao());
            int affectedRows = psExcluiMovimentacao.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Movimentação excluída com sucesso.");
                if (!conexao.getAutoCommit()) {
                    conexao.commit();
                }
            } else {
                System.out.println("Nenhuma linha excluída, falha ao excluir movimentação.");
            }
        } catch (SQLException e) {
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao excluir movimentação: " + e.getMessage());
            throw e;
        }
    }
}
