package sistemabanco;

import lojas.Loja;

public class Cliente extends Thread {
    private String nome;
    private Conta conta;
    private Banco banco;
    private Loja loja1;
    private Loja loja2;


    public Cliente(String nome, double saldoInicial, Banco banco, Loja loja1, Loja loja2) {
        this.nome = nome;
        this.banco = banco;
        this.loja1 = loja1;
        this.loja2 = loja2;
        this.conta = new Conta(saldoInicial, nome);
        banco.adicionarConta(conta);
    }

    @Override
    public void run() {
        try {
            realizarCompras(loja1);
            realizarCompras(loja2);
        } catch (Exception e) {
            System.out.println("Erro durante a transação do cliente " + nome + ": " + e.getMessage());
        }
    }

    public void realizarCompras(Loja loja) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            double valorCompra = 200 + Math.random() * 300; // Gera valor entre 200 e 500
            System.out.println(nome + " está comprando na " + loja.getNome() + " no valor de R$" + valorCompra);
            banco.realizarTransacao(conta, loja.getConta(), valorCompra);
            Thread.sleep(500);
            loja.receberPagamento(valorCompra);
        }
    }
}
