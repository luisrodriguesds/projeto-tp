
// package br.ufc.banco.servico;

import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaPoupanca;
import br.ufc.banco.conta.ContaEspecial;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.interfaces.IBanco;
import br.ufc.banco.interfaces.IRepositorioConta;

public class BancoIndependente implements IBanco {
    private IRepositorioConta contas;

    public BancoIndependente(IRepositorioConta contas) {
        this.contas = contas;
    }

    public void cadastrar(ContaAbstrata conta) {
        contas.inserir(conta);
    }

    public int numeroContas() {
        return contas.tamanho();
    }

    public double saldoTotal() {
        return 0;
    }

    public void creditar(String numero, double valor) {
        ContaAbstrata conta;
        conta = contas.procurar(numero);
        if (conta != null) {
            conta.creditar(valor);
        } else {
            System.out.println("Conta Inexistente!");
        }
    }

    public ContaAbstrata procurar(String numero) {
        return contas.procurar(numero);
    }

    public double saldo(String numero) {
        ContaAbstrata conta;
        conta = contas.procurar(numero);
        if (conta != null) {
            return conta.getSaldo();
        } else {
            // Retornar mensagem de que conta nao existe
            System.out.println("Conta Inexistente!");
            return 0;
        }
    }

    public void debitar(String numero, double valor) {
        ContaAbstrata conta = contas.procurar(numero);
        if (conta != null) {
            conta.debitar(valor);
        } else {
            System.out.println("Conta inexistente!");
        }
    }

    public void transferir(String origem, String destino, double valor) {
        ContaAbstrata contaOrigem, contaDestinor;
        contaOrigem = contas.procurar(origem);
        contaDestinor = contas.procurar(destino);
        if (contaOrigem != null || contaDestinor != null) {
            contaOrigem.debitar(valor);
            contaDestinor.creditar(valor);
        } else {
            System.out.println("Uma ou as duas contas não existe");
        }
    }
}