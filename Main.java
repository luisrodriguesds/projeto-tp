import  br.ufc.banco.servico.BancoArray;
import  br.ufc.banco.conta.Conta;
import  br.ufc.banco.conta.ContaPoupanca;
import  br.ufc.banco.conta.ContaEspecial;
import  br.ufc.banco.conta.ContaAbstrata;

public class Main {

  public static void main(String[] args) {
    BancoArray banco = new BancoArray();

    ContaAbstrata conta1 = new Conta("27.123");
    ContaAbstrata conta2 = new Conta("27.456");
    ContaAbstrata contaP = new ContaPoupanca("27.789");
    ContaAbstrata contaE = new ContaEspecial("27.741");

    banco.cadastrar(conta1);
    banco.cadastrar(conta2);
    banco.cadastrar(contaP);
    banco.cadastrar(contaE);
    
    banco.creditar("27.789", 100);
    banco.renderJuros("27.789");
    System.out.println(banco.saldo("27.789"));

    banco.creditar("27.741", 100);
    banco.renderBonus("27.741");
    System.out.println(banco.saldo("27.741"));
    System.out.println("Total de contas: "+ banco.numeroContas());
    System.out.println("Saldo total: "+ banco.saldoTotal());


  }
}