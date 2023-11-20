package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.model.InstFinanc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InstFinancDAO {

    private Connection conexao;

    // Método Construtor:
    public InstFinancDAO(Connection conexao) {
        this.conexao = conexao;
    }

//--------------------------------------------------------------------------------------------------------
// Método para Adicionar uma instituição financeira (Persistência de dados)

    public void gravarInstFinanceira(InstFinanc instituicao) throws SQLException {

        String sql = "INSERT INTO T_INSTFINANC (NR_CNPJ, NM_INSTFINANC) VALUES (?, ?)";

        // O try-with-resources garante que o PreparedStatement será fechado após o uso.
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setLong(1, instituicao.getCnpj()); // Aqui usamos setLong, assumindo que, getCnpj retorna um "long".
            ps.setString(2, instituicao.getNome());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Instituição Financeira gravada com sucesso!");
            } else {
                System.out.println("Nenhuma linha inserida.");
            }

            // Se o auto-commit estiver desligado, o commit precisa ser chamado explicitamente
            if (!conexao.getAutoCommit()) {
                conexao.commit();
            }

        } catch (SQLException e) {
            // Em um caso real, reverter a transação se algo der errado durante a inserção
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao gravar a Instituição Financeira.");
            throw e; // Relançar a exceção para que possa ser tratada ou logada adequadamente
        }
        // Conexão não é fechada aqui; quem gerencia a conexão deve cuidar disso.
    }
//--------------------------------------------------------------------------------------------------------

    // Método para excluir uma instituição financeira baseado em seu CNPJ
    public void excluirInstFinanceira(long cnpj) throws SQLException {
        String sql = "DELETE FROM T_INSTFINANC WHERE NR_CNPJ = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setLong(1, cnpj); // Define o CNPJ do registro a ser excluído

            int affectedRows = ps.executeUpdate(); // Executa o comando de exclusão

            // Verifica se o registro foi excluído com sucesso
            if (affectedRows > 0) {
                System.out.println("Instituição Financeira excluída com sucesso!");
                if (!conexao.getAutoCommit()) {
                    conexao.commit();
                }
            } else {
                System.out.println("Nenhuma instituição financeira foi excluída.");
            }
        } catch (SQLException e) {
            // Em caso de erro, tenta reverter a transação se o auto-commit estiver desligado
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao excluir Instituição Financeira.");
            throw e;
        }
    }
} //FIM

