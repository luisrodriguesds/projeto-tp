import  br.ufc.banco.servico.BancoArray;
import  br.ufc.banco.conta.Conta;
import  br.ufc.banco.conta.ContaPoupanca;
import  br.ufc.banco.conta.ContaEspecial;
import  br.ufc.banco.conta.ContaAbstrata;

public class AuditorBancoGenerico {

	public void auditar(IBanco banco) {
		if ((banco.saldoTotal() / banco.numeroContas()) > 500) {
			System.out.println("Aprovado!");
		} else {
			System.out.println("Não aprovado!");
		}
	}
}