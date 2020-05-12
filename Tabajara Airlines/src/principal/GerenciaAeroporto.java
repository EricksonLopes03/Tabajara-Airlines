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
			System.out.println("Identifica��o: ");
			id = scString.nextLine();
			for (Aeroporto a : aeroportos) {
				if (a.getIdentificacao() == id) {
					System.out.println("Esta identifica��o j� est� em uso");
					idDisponivel = false;
				}
			}

		} while (idDisponivel == false);
		System.out.println("Nome: ");
		nome = scString.nextLine();
		System.out.println("Munic�pio: ");
		municipio = scString.nextLine();
		System.out.println("Estado: ");
		estado = scString.nextLine();
		System.out.println("Pa�s: ");
		pais = scString.nextLine();
		aeroportos.add(new Aeroporto(id, nome, municipio, estado, pais));
		System.out.println("Aeroporto cadastrado com sucesso!");

	}

	public void relatorio() {
		if (aeroportos.isEmpty()) {
			System.out.println("N�o h� aeroportos cadastrados");
		} else {
			for (Aeroporto a : aeroportos) {
				a.imprimir();

			}
		}
	}
	
	public void alterar() {
		if (aeroportos.isEmpty()) {
			System.out.println("N�o h� aeroportos cadastrados");
		} else {
			int id = 0;
			for (Aeroporto a : aeroportos) {
				System.out.println("Posi��o: " + id);
				a.imprimir();
				id++;

			}

			System.out.println("Digite a posi��o do aeroporto que deseja alterar: ");
			int pos = scInt.nextInt();
			Aeroporto aero = aeroportos.get(pos);
			System.out.println("Insira os novos dados para...");
			System.out.println("Nome: ");
			aero.setNome(scString.nextLine());
			System.out.println("Munic�pio: ");
			aero.setMunicipio(scString.nextLine());
			System.out.println("Estado: ");
			aero.setEstado(scString.nextLine());
			System.out.println("Pa�s: ");
			aero.setPais(scString.nextLine());
			System.out.println("Altera��es feitas com sucesso!");
			
			
		}
	}

	public void consultar () {
		if (aeroportos.isEmpty()) {
			System.out.println("N�o h� aeroportos cadastrados");
		} else {
			System.out.println("Digite a identifica��o do aeroporto que deseja buscar: ");
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
				System.out.println("N�o foi encontrado nenhum cadastro para o identificador informado!");

			}

		}
	}

	public void excluir () {
		if (aeroportos.isEmpty()) {
			System.out.println("N�o h� aeroportos cadastrados");
		} else {
			System.out.println("Digite a identifica��o que deseja excluir: ");
			String id = scString.nextLine();
			for (Aeroporto a : aeroportos) {
				if (a.getIdentificacao() == id) {
					a.imprimir();
					System.out.println("Confirma a exclus�o desse cadastro? 1 p/ sim ou 2 p/ n�o");
					int confirma = scInt.nextInt();
					if(confirma == 1) {
						aeroportos.remove(a);
						System.out.println("Exclus�o realizada!");
					}else {
						System.out.println("Exclus�o n�o realizada!");					
					}
					break;
				}
			}
		}
		
	}
}
