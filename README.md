# Sistema Bancário Multithread em Java
Este projeto implementa um sistema bancário básico usando Java e threads para simular transações financeiras entre clientes, funcionários, lojas e um banco. O sistema gerencia operações de compra de clientes, pagamentos de salários de funcionários e investimento automático de uma parte do salário.
# Objetivo
O principal objetivo é simular transações financeiras entre os clientes e as lojas, e também o pagamento e investimento dos salários dos funcionários. Cada cliente realiza compras em duas lojas, enquanto as lojas pagam seus funcionários com base no saldo disponível.
# Estrutura do Projeto
O projeto está dividido em quatro principais pacotes/classes:

* Banco: Classe responsável por armazenar as contas, realizar transações e exibir os saldos finais.
* Conta: Representa a conta bancária de qualquer entidade (clientes, funcionários, lojas), com operações de crédito e débito.
* Cliente: Cada cliente é uma thread que realiza compras em duas lojas. Os clientes possuem uma conta com saldo inicial e realizam transações financeiras.
* Loja: Lojas onde os clientes realizam compras. Cada loja paga seus funcionários com base no saldo disponível após receber os pagamentos dos clientes.
*Funcionário: Funcionários de lojas que recebem um salário e automaticamente investem parte dele. Eles também são implementados como threads, mas sem comportamento adicional durante o runtime.

# Funcionalidades
* Transações Multithread: As transações financeiras são realizadas de forma síncrona entre as contas, assegurando que não haja inconsistências nos saldos.
* Compra de Clientes: Cada cliente realiza 4 compras (2 em cada loja) em valores aleatórios entre R$200 e R$500.
* Pagamentos de Salário: As lojas pagam seus funcionários com um salário fixo de R$1400. Se o saldo da loja for insuficiente, o pagamento é adiado.
* Investimento Automático: Cada funcionário investe automaticamente 20% de seu salário em uma conta de investimentos após ser pago.
* Exibição dos Saldos Finais: Ao final da execução do programa, os saldos de todas as contas (clientes, lojas e funcionários) são exibidos.

# Como Executar
* Clone este repositório.
* Compile e execute o arquivo Main.java.
* O programa exibirá os logs das transações e, ao final, os saldos de todas as contas.

Este projeto é uma simulação básica de um sistema bancário com múltiplas entidades, criado como um exercício para o uso de threads e sincronização em Java
