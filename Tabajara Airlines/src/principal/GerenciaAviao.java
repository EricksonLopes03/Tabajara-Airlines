package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaAviao {

	private ArrayList<Aviao> avioes;
	private Scanner scString = new Scanner(System.in);
	private Scanner scInt = new Scanner(System.in);

	public GerenciaAviao(ArrayList<Aviao> avioes) {
		this.avioes = avioes;
	}

	public void cadastrar() {
		String id, modelo;
		int qtdTurbinas, capacPassageiros;
		double capacCarga;
		boolean idDisponivel = true;
		System.out.println("Insira os dados a seguir...");
		do {
			idDisponivel = true;
			System.out.println("Identificação: ");
			id = scString.nextLine();
			for (Aviao a : avioes) {
				if (a.getIdentificacao().equals(id)) {
					System.out.println("Esta identificação já está em uso");
					idDisponivel = false;
				}
			}

		} while (idDisponivel == false);

		System.out.println("Modelo: ");
		modelo = scString.nextLine();
		System.out.println("Quantidade de Turbinas: ");
		qtdTurbinas = scInt.nextInt();
		System.out.println("Capacidade de Passageiros: ");
		capacPassageiros = scInt.nextInt();
		System.out.println("Capacidade de Carga");
		capacCarga = scInt.nextDouble();
		avioes.add(new Aviao(id, modelo, qtdTurbinas, capacPassageiros, capacCarga));
		System.out.println("Avião cadastrado com sucesso!");
	}

	public void relatorio() {
		if (avioes.isEmpty()) {
			System.out.println("Não há aviões cadastrados");
		} else {
			for (Aviao a : avioes) {
				a.imprimir();
			}
		}
	}

	public void alterar() {
		if (avioes.isEmpty()) {
			System.out.println("Não há aviões cadastrados");
		} else {
			int id = 0;
			for (Aviao a : avioes) {
				System.out.println("Posição: " + id);
				a.imprimir();
				id++;

			}

			System.out.println("Digite a posição do avião que deseja alterar: ");
			int pos = scInt.nextInt();
			if(pos < avioes.size() && pos >=0) {
				Aviao a = avioes.get(pos);
				System.out.println("Digite os novos dados para...");
				System.out.println("Modelo: ");
				a.setModelo(scString.nextLine());
				System.out.println("Quantidade de Turbinas: ");
				a.setQtdTurbinas(scInt.nextInt());
				System.out.println("Capacidade de Passageiros: ");
				a.setCapacPassageiros(scInt.nextInt());
				System.out.println("Capacidade de Carga");
				a.setCapacCarga(scInt.nextDouble());
				System.out.println("Alterações feitas com sucesso!");
			}else {
				System.out.println("Posição inexistente!");
			}
			
		}
	}
	
	public void consultar () {
		if (avioes.isEmpty()) {
			System.out.println("Não há avioess cadastrados");
		} else {
			System.out.println("Digite a identificação do avião que deseja buscar: ");
			String id = scString.nextLine();
			boolean achou = false;
			for (Aviao a : avioes) {
				if (a.getIdentificacao().equals(id)) {
					a.imprimir();
					achou = true;
					break;
				}
			}

			if (achou == false) {
				System.out.println("Não foi encontrado nenhum cadastro para o identificador informado!");

			}

		}
	}
	
	public void excluir () {
		if (avioes.isEmpty()) {
			System.out.println("Não há aviões cadastrados");
		} else {
			System.out.println("Digite a identificação que deseja excluir: ");
			String id = scString.nextLine();
			boolean achou = false;
			for (Aviao a : avioes) {
				if (a.getIdentificacao().equals(id)) {
					a.imprimir();
					System.out.println("Confirma a exclusão desse cadastro? 1 p/ sim ou 2 p/ não");
					int confirma = scInt.nextInt();
					achou = true;
					if(confirma == 1) {
						avioes.remove(a);
						System.out.println("Exclusão realizada!");
					}else {
						System.out.println("Exclusão não realizada!");					
					}
					break;

				}
			} if(!achou) {
				System.out.println("Não foi encontrado nenhum cadastro para o identificador informado!");
			}
		}
		
	}

}
