package controlador;

import sistemabanco.Banco;
import sistemabanco.Cliente;
import lojas.Funcionario;
import lojas.Loja;


public class Main {
    public static void main(String[] args) {
        // Criar o banco
        Banco banco = new Banco();

        // Criar as lojas
        Loja loja1 = new Loja("Informatica LE.", banco, 0);
        Loja loja2 = new Loja("Hey listen", banco, 0);

        // Criar funcionários (2 por loja)
        Funcionario f1 = new Funcionario("Lukas carvalho", loja2, banco);
        Funcionario f2 = new Funcionario("Lucas von lohrmann", loja1, banco);
        Funcionario f3 = new Funcionario("Eduardo coelho", loja2, banco);
        Funcionario f4 = new Funcionario("Guilherme yago", loja1, banco);

        // Atribuir funcionários às lojas
        loja1.setFuncionarios(new Funcionario[]{f1, f2});
        loja2.setFuncionarios(new Funcionario[]{f3, f4});

        // Lista de nomes para os clientes
        String[] nomesClientes = {"Camila", "Juliana", "Isabella", "Breno", "Adam", "Giovana", "Ricardo", "Adriana", "Fernando", "Leonardo"};

        // Criar clientes (10 threads)
        Cliente[] clientes = new Cliente[10];
        for (int i = 0; i < 10; i++) {
            clientes[i] = new Cliente(nomesClientes[i], 2000.0, banco, loja1, loja2);
        }

        // Iniciar as threads dos clientes
        for (Cliente cliente : clientes) {
            cliente.start();
        }

        // Iniciar as threads dos funcionários
        f1.start();
        f2.start();
        f3.start();
        f4.start();

        // Aguardar todas as threads terminarem
        try {
            for (Cliente cliente : clientes) {
                cliente.join();
            }
            f1.join();
            f2.join();
            f3.join();
            f4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibir saldo final das contas
        System.out.println("\n------- Saldos Finais ---------");
        banco.mostrarSaldos();
    }
}

