package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.model.PessoaFisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaFisicaDAO {

    private Connection conexao;

    //Método construtor que recebe a conexão como parâmetro
    public PessoaFisicaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // ----------------------------------------------------------------------------------------------------------------------
    //Método adicionarPF
    public void adicionarPf(PessoaFisica pf) throws SQLException {

        // Consulta SQL para verificar se O CLIENTE existe:
        String sqlVerificaCliente = "SELECT COUNT(*) FROM T_CLIENTE WHERE CD_CLIENTE = ?";

        // Código SQL para inserir um novo cliente PF:
        String sqlInserePF = "INSERT INTO T_PF (CD_CLIENTE, NR_CPF, NR_RG) "
                + "VALUES (?, ?, ?)";

        try(PreparedStatement psVerifica = conexao.prepareStatement(sqlVerificaCliente);
            PreparedStatement psInserePF = conexao.prepareStatement(sqlInserePF)) {

            //Verifica se o cliente existe:
            psVerifica.setLong(1, pf.getCdCliente());
            ResultSet rs = psVerifica.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                throw new SQLException("Chave estrangeira para o Cliente não existe.");
            }

            //Insere o Cliente PF:
            psInserePF.setLong(1, pf.getCdCliente());
            psInserePF.setLong(2, pf.getCpf());
            psInserePF.setString(3, pf.getNrRg());

            int affectedRows = psInserePF.executeUpdate();
            if (affectedRows > 0){
                System.out.println("Cliente Cadastrado como Pessoa Física");
                if (!conexao.getAutoCommit()) {
                    conexao.commit();
                }
            } else {
                System.out.println("Nenhuma linha inserida, falha ao adicionar cliente como PF.");
            }
        } catch (SQLException e) {
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao adicionar cliente PF: " + e.getMessage());
            throw e;
        }

    } //Fim método AdicionarPF
// ----------------------------------------------------------------------------------------------------------------------

// ----------------------------------------------------------------------------------------------------------------------
    //Método Excluir PF:

    public void excluirPF(long cdCliente) throws SQLException {
        // Código SQL para excluir uma Pessoa Física (PF) com base no CD_CLIENTE
        String sqlExcluiPF = "DELETE FROM T_PF WHERE CD_CLIENTE = ?";

        try (PreparedStatement psExcluiPF = conexao.prepareStatement(sqlExcluiPF)) {
            // Configura o CD_CLIENTE para a exclusão
            psExcluiPF.setLong(1, cdCliente);

            // Executa o comando de exclusão
            int affectedRows = psExcluiPF.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Pessoa Física (PF) com CD_CLIENTE " + cdCliente + " excluída com sucesso.");
                if (!conexao.getAutoCommit()) {
                    conexao.commit();
                }
            } else {
                System.out.println("Nenhuma Pessoa Física (PF) foi excluída. PF com CD_CLIENTE " + cdCliente + " pode não existir. Tente Novamente.");
            }
        } catch (SQLException e) {
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao excluir Pessoa Física (PF): " + e.getMessage());
            throw e;
        }
    } //Fim do método Excluir PF.
//-----------------------------------------------------------------------------------------------------------------------

}//Fim da classe

