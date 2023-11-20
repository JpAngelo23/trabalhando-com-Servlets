package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.model.PessoaJuridica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaJuridicaDAO {

    private Connection conexao;


    //Método Contrutor:
    public PessoaJuridicaDAO(Connection conexao){
        this.conexao = conexao;
    }


//-----------------------------------------------------------------------------------------------------------------------
//Método adiciona PJ:

    public void adicionaPj(PessoaJuridica pj) throws SQLException {

        // Consulta SQL para verificar se O CLIENTE existe:
        String sqlVerifica = "SELECT COUNT(*) FROM T_CLIENTE WHERE CD_CLIENTE = ?";

        // Código SQL para inserir um novo cliente PF:
        String sqlAdiciona = "INSERT INTO T_PJ (CD_CLIENTE, NR_CNPJ, DS_INSCMUNIC) "
                + "VALUES (?, ?, ?)";


        try (PreparedStatement psVerifica = conexao.prepareStatement(sqlVerifica);
             PreparedStatement psAdicionaPj = conexao.prepareStatement(sqlAdiciona)) {


            //Verifica se o cliente existe:
            psVerifica.setLong(1, pj.getCdCliente());
            ResultSet rs = psVerifica.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                throw new SQLException("Chave estrangeira para o Cliente não existe.");
            }
            // caso cliente existe, segue execução para o comando SQL de adiocionar:
            //Adiciona o PJ:

            psAdicionaPj.setLong(1, pj.getCdCliente());
            psAdicionaPj.setLong(2, pj.getCnpj());
            psAdicionaPj.setString(3, pj.getDsInscricaoMunic());

            int affectedRows = psAdicionaPj.executeUpdate();
            if (affectedRows > 0){
                System.out.println("Cliente Cadastrado como Pessoa jurídica");

                if (!conexao.getAutoCommit()) {
                    conexao.commit();
                }
            } else {
                System.out.println("Nenhuma linha inserida, falha ao adicionar cliente como PJ.");
            }
        } catch (SQLException e) {
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao adicionar cliente PJ: " + e.getMessage());
            throw e;
        }

    }//Fim do Método Adiciona PJ
    // ----------------------------------------------------------------------------------------------------------------------

// ----------------------------------------------------------------------------------------------------------------------
    //Método Excluir PJ:

    public void excluirPJ(long cdCliente) throws SQLException {
        // Código SQL para excluir uma Pessoa Jurídica (PJ) com base no CD_CLIENTE
        String sqlExcluiPJ = "DELETE FROM T_PJ WHERE CD_CLIENTE = ?";

        try (PreparedStatement psExcluiPJ = conexao.prepareStatement(sqlExcluiPJ)) {
            // Configura o CD_CLIENTE para a exclusão
            psExcluiPJ.setLong(1, cdCliente);

            // Executa o comando de exclusão
            int affectedRows = psExcluiPJ.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Pessoa Jurídica (PJ) com CD_CLIENTE " + cdCliente + " excluída com sucesso.");
                if (!conexao.getAutoCommit()) {
                    conexao.commit();
                }
            } else {
                System.out.println("Nenhuma Pessoa Jurídica (PJ) foi excluída. PJ com CD_CLIENTE " + cdCliente + " pode não existir. Tente Novamente.");
            }
        } catch (SQLException e) {
            if (!conexao.getAutoCommit()) {
                conexao.rollback();
            }
            System.out.println("Erro ao excluir Pessoa Jurídica (PJ): " + e.getMessage());
            throw e;
        }
    } //Fim do método Excluir PJ.
//-----------------------------------------------------------------------------------------------------------------------

} //FIM da classe.
