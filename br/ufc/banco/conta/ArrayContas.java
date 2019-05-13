
package br.ufc.banco.conta;

import br.ufc.banco.interfaces.IRepositorioConta;

public class ArrayContas implements IRepositorioConta {

    private ContaAbstrata[] contas;
    private int indice = 0;

    public ArrayContas(){
        contas = new ContaAbstrata[100];
    }

    public void inserir(ContaAbstrata conta) {
        contas[indice] = conta;
        indice++;
    }

    public void remover(String numero) {
        
    }

    public ContaAbstrata procurar(String numero) {
        int i = 0;
        for (i = 0; i < (indice + 1); i++) {
            if (contas[i].getNumero().equals(numero)) {
                return contas[i];
            }
        }
        return null;
    }

    public ContaAbstrata[] listar() {
        return null;
    }

    public int tamanho() {
        return indice;
    }
}