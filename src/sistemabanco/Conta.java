package sistemabanco;

public class Conta {
    private double saldo;
    private String proprietario;

    public Conta(double saldoInicial, String proprietario) {
        this.saldo = saldoInicial;
        this.proprietario = proprietario;
    }

    public synchronized void creditar(double valor) {
        saldo += valor;
    }

    public synchronized void debitar(double valor) throws Exception {
        if (valor > saldo) {
            throw new Exception("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getProprietario() {
        return proprietario;
    }
}