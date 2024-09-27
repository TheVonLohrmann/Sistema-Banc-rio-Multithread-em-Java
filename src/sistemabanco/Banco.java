package sistemabanco;

import java.util.ArrayList;


public class Banco {

    private ArrayList<Conta> contas = new ArrayList<>();

    public synchronized void realizarTransacao(Conta de, Conta para, double valor) {
        try {
            de.debitar(valor);
            para.creditar(valor);
            // Log da transação
            System.out.println("Transferência de R$ " + valor + " de " + de + " para " + para);
        } catch (Exception e) {
            System.out.println("Transferência falhou: saldo insuficiente na conta de origem.");
        }
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void mostrarSaldos() {
        for (Conta conta : contas) {
            System.out.println(conta.getProprietario() + " - Saldo: R$ " + conta.getSaldo());
        }
    }
}
