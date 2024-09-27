package lojas;

import sistemabanco.Banco;
import sistemabanco.Conta;

public class Loja {
    private String nome;
    private Conta contaLoja;
    private Funcionario[] funcionarios;
    private Banco banco;

    public Loja(String nome, Banco banco, double saldoInicial) {
        this.nome = nome;
        this.banco = banco;
        this.contaLoja = new Conta(saldoInicial, nome);
        banco.adicionarConta(contaLoja);
    }

    public synchronized void receberPagamento(double valor) {
        contaLoja.creditar(valor);
        pagarFuncionarios();
    }

    private synchronized void pagarFuncionarios() {
        for (Funcionario func : funcionarios) {
            if (contaLoja.getSaldo() >= 1400) {
                banco.realizarTransacao(contaLoja, func.getContaSalario(), 1400);
                System.out.println("Loja " + this.nome + " pagou o funcionário: " + func.getNome());
                func.investirSalario();
            } else {
                System.out.println("Loja " + this.nome);
                System.out.println("Saldo insuficiente para pagar " + func.getNome());
            }
        }
    }

    public void setFuncionarios(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Conta getConta() {
        return contaLoja;
    }

    public String getNome() {
        return nome;
    }
}
