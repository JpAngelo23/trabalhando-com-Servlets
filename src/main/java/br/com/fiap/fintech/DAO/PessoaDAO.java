package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {

    private Connection conexao;

    // Método Construtor - que recebe a conexão como parâmetro da classe DAO.
    public PessoaDAO(Connection conexao){
        this.conexao = conexao;
    }

//------------------------------------------------------------------------------------------------------------------------
    //Método gravar Pessoa (Persistência de Dados)
    public void gravarPessoa(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO T_PESSOA (CD_PESSOA, NM_PESSOA, NR_CEP, DS_COMPLEMENTO, TEL_CONTATO) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setLong(1, pessoa.getCdPessoa());
            ps.setString(2, pessoa.getNomePessoa());
            ps.setString(3, pessoa.getCep());
            ps.setString(4, pessoa.getComplemento());
            ps.setLong(5, pessoa.getTel());
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Pessoa gravada com sucesso!");
            } else {
                System.out.println("Nenhum dado foi cadastrado.");
            }

            if (!conexao.getAutoCommit()) {
                conexao.commit();
            }

        } catch (SQLException e) {
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao gravar a Instituição Financeira.");
            throw e; // Relançar a exceção para que possa ser tratada ou logada adequadamente
        }
    } // Fim Método Gravar Pessoa
//---------------------------------------------------------------------------------------------------------------------
    //Método para excluir Pessoa (Persistência dados):
    public void excluirPessoa(Pessoa pessoa) throws SQLException {
        long excluaPessoa = pessoa.getCdPessoa();
        String sql = "DELETE FROM T_PESSOA WHERE CD_PESSOA = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setLong(1, excluaPessoa);
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("O registro da pessoa " + pessoa.getNomePessoa() + " foi excluído com sucesso.");
            }  else {
                System.out.println("Nenhum dado foi alterado.");
            }

            if (!conexao.getAutoCommit()) {
                conexao.commit();
            }

        } catch (SQLException e) {
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao gravar a Instituição Financeira.");
            throw e; // Relançar a exceção para que possa ser tratada ou logada adequadamente
        }
    } //Fim do Métodoo excluir
 //----------------------------------------------------------------------------------------------------------------------

}//Fim da Classe.
