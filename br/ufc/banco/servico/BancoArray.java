package br.ufc.banco.servico;

import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaPoupanca;
import br.ufc.banco.conta.ContaEspecial;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.interfaces.IBanco;

public class BancoArray implements IBanco{

  private ContaAbstrata[] contas;
  private int indice = 0;
  private double taxa = 0.6;

  public BancoArray(){
    contas = new ContaAbstrata[100];
  }
  
  public void cadastrar(ContaAbstrata conta){
    contas[indice] = conta;
    indice++;
  }

  public int numeroContas(){
    return indice;
  }
  
  public ContaAbstrata procurar(String numero){
    int i=0;
    for(i=0; i<(indice+1);i++){
      if(contas[i].getNumero().equals(numero)){
        return contas[i];
      }
    }
    return null;
  }

  public double saldoTotal(){
    int i=0;
    double saldoTotal = 0;
    for (i=0; i<(indice+1); i++) {
      // if (contas[i].getSaldo() != 0) {
      //   saldoTotal = saldoTotal + contas[i].getSaldo();
      // }
      //System.out.println(contas[i].getNumero());
    }

    return 0;
  }

  public void creditar(String numero, double valor){
      ContaAbstrata conta;
      conta = procurar(numero);
      if(conta != null){
        conta.creditar(valor);
      }else{
        System.out.println("Conta Inexistente!"); 
      }
  }

  public void debitar(String numero, double valor){
    ContaAbstrata conta = procurar(numero);
     if (conta != null) {
       conta.debitar(valor); 
      } else {
       System.out.println("Conta Inexistente!");
     }
  }

  public double saldo(String numero) {
    ContaAbstrata conta;
    conta = procurar(numero);
    if(conta != null){
      return conta.getSaldo();
    }else{
      //Retornar mensagem de que conta nao existe 
      System.out.println("Conta Inexistente!");
      return 0;
    }
  }

  public void transferir(String origem, String destino, double valor) {
    ContaAbstrata contaOrigem, contaDestinor;
    contaOrigem = procurar(origem);
    contaDestinor = procurar(destino);
    if(contaOrigem != null || contaDestinor != null){
      contaOrigem.debitar(valor);
      contaDestinor.creditar(valor);
    }else{
      System.out.println("Uma ou as duas contas não existe"); 
    }
  }

  public void renderBonus(String numero){
    ContaAbstrata conta;
    conta = procurar(numero);
    if(conta != null && conta instanceof ContaEspecial){
      ((ContaEspecial) conta).renderBonus();
    }
  }

  public void renderJuros(String numero){
    ContaAbstrata conta;
    conta = procurar(numero);
    if(conta != null && conta instanceof ContaPoupanca){
      ((ContaPoupanca) conta).renderJuros(taxa);
    }
  }
}