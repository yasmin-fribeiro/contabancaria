package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub

		var conta = buscarNaCollection(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA conta número: " + numero + " não foi encontrada");
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void cadastrar(Conta conta) {
		// TODO Auto-generated method stub
		listaContas.add(conta);
		System.out.println("\nA Conta número: " + conta.getNumero() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		var buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\n A conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println("\n A conta número: " + conta.getNumero() + " não foi encontrada!");
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if (listaContas.remove(conta) == true) {
				System.out.println("\n A conta numero: " + numero + " foi deletada com sucesso!");
			} else
				System.out.println("\nA conta numero: " + numero + "não foi encontrada");

		}
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var contas : listaContas) {
			if (contas.getNumero() == numero) {
				return contas;
			}
		}
		return null;
	}

}
