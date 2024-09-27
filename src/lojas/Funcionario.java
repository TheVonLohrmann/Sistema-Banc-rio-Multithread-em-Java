package lojas;

import sistemabanco.Banco;
import sistemabanco.Conta;

public class Funcionario extends Thread {
    private String nome;
    private Conta contaSalario;
    private Conta contaInvestimentos;
    private Banco banco;
    private Loja loja;

    public Funcionario(String nome, Loja loja, Banco banco) {
        this.nome = nome;
        this.loja = loja;
        this.banco = banco;
        this.contaSalario = new Conta(0, nome + " - Salário");
        this.contaInvestimentos = new Conta(0, nome + " - Investimentos");
        banco.adicionarConta(contaSalario);
        banco.adicionarConta(contaInvestimentos);
    }

    public void investirSalario() {
        double valorInvestido = contaSalario.getSaldo() * 0.2;
        banco.realizarTransacao(contaSalario, contaInvestimentos, valorInvestido);
        System.out.println(nome + " investiu R$ " + valorInvestido);
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void run() {
        // Implementação adicional se necessária
    }
}
