import java.sql.SQLException;

import br.com.fiap.fintech.DAO.CCorrenteDAO;
import br.com.fiap.fintech.DAO.CPoupancaDAO;
import br.com.fiap.fintech.DAO.ClienteDAO;
import br.com.fiap.fintech.DAO.ContaDAO;
import br.com.fiap.fintech.DAO.InstFinancDAO;
import br.com.fiap.fintech.DAO.MovimentacaoDAO;
import br.com.fiap.fintech.DAO.PessoaDAO;
import br.com.fiap.fintech.DAO.PessoaFisicaDAO;
import br.com.fiap.fintech.DAO.PessoaJuridicaDAO;
import br.com.fiap.fintech.DataBase.Conexao;
import br.com.fiap.fintech.model.CCorrente;
import br.com.fiap.fintech.model.CPoupanca;
import br.com.fiap.fintech.model.Cliente;
import br.com.fiap.fintech.model.Conta;
import br.com.fiap.fintech.model.InstFinanc;
import br.com.fiap.fintech.model.Movimentacao;
import br.com.fiap.fintech.model.Pessoa;
import br.com.fiap.fintech.model.PessoaFisica;
import br.com.fiap.fintech.model.PessoaJuridica;


    public class Main {

    public static void main(String[] args) throws SQLException {

        InstFinanc brad = new InstFinanc();
        brad.setCnpj(12345678911111L);
        brad.setNome("Bradesco");

        InstFinancDAO instFinanceira = new InstFinancDAO(Conexao.abrirConexao());
//
        instFinanceira.gravarInstFinanceira(brad);
//        instFinanceira.excluirInstFinanceira(12345678911111L);



        Pessoa jp = new Pessoa();
        jp.setCdPessoa(1234567891L);
        jp.setNomePessoa("João Paulo");
        jp.setTel(11911223344L);
        jp.setCep("05868020");
        jp.setComplemento("Bairro: Jardim Das flores");

        Pessoa b3 = new Pessoa();
        b3.setCdPessoa(2023);
        b3.setNomePessoa("Bolsa de Valores de SP");
        b3.setTel(1144611070L);
        b3.setCep("05866090");
        b3.setComplemento("centro");

        PessoaDAO pessoaDao = new PessoaDAO(Conexao.abrirConexao());
//
        pessoaDao.gravarPessoa(jp);
        pessoaDao.gravarPessoa(b3);
//        pessoaDao.excluirPessoa(jp);
//        pessoaDao.excluirPessoa(b3);


        Cliente joao = new Cliente();
        joao.setCdPessoa(1234567891L);
        joao.setCdCliente(12345);
        joao.setDsConta("conta do joao");
        joao.setDsSenha("Password");
        joao.setEmail("jp.angelo23@gmail.com");

        Cliente clienteB3 = new Cliente();
        clienteB3.setCdPessoa(2023);
        clienteB3.setCdCliente(1990);
        clienteB3.setDsConta("conta da BmF Bovespa");
        clienteB3.setDsSenha("PASSWORD!!");
        clienteB3.setEmail("b3@bovespa.com");

        ClienteDAO clienteConexao = new ClienteDAO(Conexao.abrirConexao());
//
        clienteConexao.adicionarCliente(joao);
        clienteConexao.adicionarCliente(clienteB3);
//        clienteConexao.excluirCliente(12345);
//        clienteConexao.excluirCliente(1990);


        PessoaFisica joaoPF = new PessoaFisica();
        joaoPF.setCdCliente(12345);
        joaoPF.setCpf(40235789625L);
        joaoPF.setNrRg("0800");

        PessoaFisicaDAO conexaoPF = new PessoaFisicaDAO(Conexao.abrirConexao());
//
        conexaoPF.adicionarPf(joaoPF);
//        conexaoPF.excluirPF(12345L);


        PessoaJuridica b3PJ = new PessoaJuridica();
        b3PJ.setCdCliente(1990L);
        b3PJ.setCnpj(106223000150L);
        b3PJ.setDsInscricaoMunic("2000SP");

        PessoaJuridicaDAO conexaoPJ = new PessoaJuridicaDAO(Conexao.abrirConexao());
//
        conexaoPJ.adicionaPj(b3PJ);
//        conexaoPJ.excluirPJ(1990);


        Conta contaDoJp = new Conta();
        contaDoJp.setCdConta(505050);
        contaDoJp.setNrConta("633389");
        contaDoJp.setCdAgencia(2856);
        contaDoJp.setCnpjInstFinanc(12345678911111L);
        contaDoJp.setCdCliente(12345L);
        contaDoJp.setValorSaldo(1500.50);

        Conta contaDaB3 = new Conta();
        contaDaB3.setCdConta(707070);
        contaDaB3.setNrConta("1500x");
        contaDaB3.setCdAgencia(2856);
        contaDaB3.setCnpjInstFinanc(12345678911111L);
        contaDaB3.setCdCliente(1990L);
        contaDaB3.setValorSaldo(100.90);


        ContaDAO conexaoContaDAO = new ContaDAO(Conexao.abrirConexao());
//
        conexaoContaDAO.cadastrarConta(contaDoJp);
        conexaoContaDAO.cadastrarConta(contaDaB3);
//        conexaoContaDAO.excluirConta(505050);
//        conexaoContaDAO.excluirConta(707070);


        CPoupanca poupancaB3 = new CPoupanca();
        poupancaB3.setCdConta(707070);
        poupancaB3.setTxRendimento(1.23);

        CPoupancaDAO conexaoCpb3 = new CPoupancaDAO(Conexao.abrirConexao());
//
        conexaoCpb3.cadastrarContaPoupanca(poupancaB3);
//        conexaoCpb3.excluirContaPoupanca(707070);




        CCorrente cCorrenteJP = new CCorrente();
        cCorrenteJP.setCdConta(505050);
        cCorrenteJP.setTxJuros(14.75);
        cCorrenteJP.setTxIof(1.22);
        cCorrenteJP.setTxIr(30.00);

        CCorrenteDAO conexaoCCjp = new CCorrenteDAO(Conexao.abrirConexao());
//
        conexaoCCjp.gravarConta(cCorrenteJP);
//        conexaoCCjp.excluirContaCorrente(505050);


        Movimentacao jPescola = new Movimentacao();
        jPescola.setCategoria("Filhos");
        jPescola.setData("Todo dia 10");
        jPescola.setRecorrencia("Mensal");
        jPescola.setDsMovimentacao("2x R$ 500,00");
        jPescola.setCdMovimentacao(52);
        jPescola.setCdConta(505050);
        jPescola.setCdCliente(12345L);
        jPescola.setValorMovimentacao(1000.00);

        Movimentacao b3debitos = new Movimentacao();
        b3debitos.setCategoria("Funcionarios");
        b3debitos.setData("Todo dia 30");
        b3debitos.setRecorrencia("Mensal");
        b3debitos.setDsMovimentacao("Gerente Pj");
        b3debitos.setCdConta(707070);
        b3debitos.setCdCliente(1990);
        b3debitos.setValorMovimentacao(9000.00);


        MovimentacaoDAO movimentacaoConexao = new MovimentacaoDAO(Conexao.abrirConexao());
//
        movimentacaoConexao.cadastrarMovimentacao(jPescola);
        movimentacaoConexao.cadastrarMovimentacao(b3debitos);

//        movimentacaoConexao.excluirMovimentacao(jPescola);
//        movimentacaoConexao.excluirMovimentacao(b3debitos);



        //---------------------------------------------------------------------------------------------------------------------
// Excluindo os dados do Data Base:

     /*   MovimentacaoDAO movimentacaoConexao = new MovimentacaoDAO(Conexao.abrirConexao());
        movimentacaoConexao.excluirMovimentacao(jPescola);
        movimentacaoConexao.excluirMovimentacao(b3debitos);

        CCorrenteDAO conexaoCCjp = new CCorrenteDAO(Conexao.abrirConexao());
        conexaoCCjp.excluirContaCorrente(505050);

        CPoupancaDAO conexaoCpb3 = new CPoupancaDAO(Conexao.abrirConexao());
        conexaoCpb3.excluirContaPoupanca(707070);

        ContaDAO conexaoContaDAO = new ContaDAO(Conexao.abrirConexao());
        conexaoContaDAO.excluirConta(505050);
        conexaoContaDAO.excluirConta(707070);

        PessoaJuridicaDAO conexaoPJ = new PessoaJuridicaDAO(Conexao.abrirConexao());
        conexaoPJ.excluirPJ(1990);

        PessoaFisicaDAO conexaoPF = new PessoaFisicaDAO(Conexao.abrirConexao());
        conexaoPF.excluirPF(12345L);

        ClienteDAO clienteConexao = new ClienteDAO(Conexao.abrirConexao());
        clienteConexao.excluirCliente(12345);
        clienteConexao.excluirCliente(1990);

        PessoaDAO pessoaDao = new PessoaDAO(Conexao.abrirConexao());
        pessoaDao.excluirPessoa(jp);
        pessoaDao.excluirPessoa(b3);

        InstFinancDAO instFinanceira = new InstFinancDAO(Conexao.abrirConexao());
        instFinanceira.excluirInstFinanceira(12345678911111L); */

//---------------------------------------------------------------------------------------------------------------------

    } //fim main

} //fim da Classe.

