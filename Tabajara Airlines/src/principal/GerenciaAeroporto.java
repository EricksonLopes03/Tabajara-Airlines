package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaAeroporto {

	private ArrayList<Aeroporto> aeroportos;
	private Scanner scString = new Scanner(System.in);
	private Scanner scInt = new Scanner(System.in);

	public GerenciaAeroporto(ArrayList<Aeroporto> aeroportos) {
		this.aeroportos = aeroportos;
	}

	public GerenciaAeroporto() {

	}

	public void cadastrar() {
		String id, nome, municipio, estado, pais;
		boolean idDisponivel;
		System.out.println("Insira os dados a seguir...");
		do {
			idDisponivel = true;
			System.out.println("Identificação: ");
			id = scString.nextLine();
			for (Aeroporto a : aeroportos) {
				if (a.getIdentificacao() == id) {
					System.out.println("Esta identificação já está em uso");
					idDisponivel = false;
				}
			}

		} while (idDisponivel == false);
		System.out.println("Nome: ");
		nome = scString.nextLine();
		System.out.println("Município: ");
		municipio = scString.nextLine();
		System.out.println("Estado: ");
		estado = scString.nextLine();
		System.out.println("País: ");
		pais = scString.nextLine();
		aeroportos.add(new Aeroporto(id, nome, municipio, estado, pais));
		System.out.println("Aeroporto cadastrado com sucesso!");

	}

	public void relatorio() {
		if (aeroportos.isEmpty()) {
			System.out.println("Não há aeroportos cadastrados");
		} else {
			for (Aeroporto a : aeroportos) {
				a.imprimir();

			}
		}
	}
	
	public void alterar() {
		if (aeroportos.isEmpty()) {
			System.out.println("Não há aeroportos cadastrados");
		} else {
			int id = 0;
			for (Aeroporto a : aeroportos) {
				System.out.println("Posição: " + id);
				a.imprimir();
				id++;

			}

			System.out.println("Digite a posição do aeroporto que deseja alterar: ");
			int pos = scInt.nextInt();
			Aeroporto aero = aeroportos.get(pos);
			System.out.println("Insira os novos dados para...");
			System.out.println("Nome: ");
			aero.setNome(scString.nextLine());
			System.out.println("Município: ");
			aero.setMunicipio(scString.nextLine());
			System.out.println("Estado: ");
			aero.setEstado(scString.nextLine());
			System.out.println("País: ");
			aero.setPais(scString.nextLine());
			System.out.println("Alterações feitas com sucesso!");
			
			
		}
	}

	public void consultar () {
		if (aeroportos.isEmpty()) {
			System.out.println("Não há aeroportos cadastrados");
		} else {
			System.out.println("Digite a identificação do aeroporto que deseja buscar: ");
			String id = scString.nextLine();
			boolean achou = false;
			for (Aeroporto a : aeroportos) {
				if (a.getIdentificacao() == id) {
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
		if (aeroportos.isEmpty()) {
			System.out.println("Não há aeroportos cadastrados");
		} else {
			System.out.println("Digite a identificação que deseja excluir: ");
			String id = scString.nextLine();
			for (Aeroporto a : aeroportos) {
				if (a.getIdentificacao() == id) {
					a.imprimir();
					System.out.println("Confirma a exclusão desse cadastro? 1 p/ sim ou 2 p/ não");
					int confirma = scInt.nextInt();
					if(confirma == 1) {
						aeroportos.remove(a);
						System.out.println("Exclusão realizada!");
					}else {
						System.out.println("Exclusão não realizada!");					
					}
					break;
				}
			}
		}
		
	}
}
