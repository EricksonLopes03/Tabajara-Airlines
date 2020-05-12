package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaCliente {

	private ArrayList<Cliente> cli;
	private Scanner scString = new Scanner(System.in);
	private Scanner scInt = new Scanner(System.in);

	public GerenciaCliente(ArrayList<Cliente> cli) {
		this.cli = cli;

	}

	public void cadastrar() {

		int id;
		String nome, log, numero, bairro, municipio, estado, cep, telefone;
		boolean idDisponivel = true;

		do {
			idDisponivel = true;
			System.out.println("Digite a identificação do cliente: ");
			id = scInt.nextInt();
			for (Cliente c : cli) {
				if (c.getIdentificacao() == id) {
					System.out.println("Esta identificação já está em uso");
					idDisponivel = false;
				}
			}

		} while (idDisponivel == false);
		System.out.println("Digite o nome do cliente");
		nome = scString.nextLine();
		System.out.println("Digite o logradouro: ");
		log = scString.nextLine();
		System.out.println("Digite o número: ");
		numero = scString.nextLine();
		System.out.println("Digite o bairro: ");
		bairro = scString.nextLine();
		System.out.println("Ditie o município: ");
		municipio = scString.nextLine();
		System.out.println("Digite o estado: ");
		estado = scString.nextLine();
		System.out.println("Digite o CEP: ");
		cep = scString.nextLine();
		System.out.println("Digite o telefone: ");
		telefone = scString.nextLine();

		cli.add(new Cliente(id, nome, log, numero, bairro, municipio, estado, cep, telefone));
		System.out.println("Cliente cadastrado com sucesso;");

	}

	public void relatorio() {
		if (cli.isEmpty()) {
			System.out.println("Não há clientes cadastrados");
		} else {

			for (Cliente c : cli) {
				c.imprimir();
			}
		}
	}

	public void alterar() {
		for (Cliente c : cli) {
			c.imprimir();
		}
		
		int id = 0, pos;
		for (Cliente c : cli) {
			System.out.println("Posição: " + id);
			c.imprimir();
			id++;
		}
		System.out.println("Digite a posição do cliente que deseja alterar: ");
		pos = scInt.nextInt();
		Cliente cliente = cli.get(pos);
		System.out.println("Insira os novos dados para...");
		System.out.println("Digite o nome do cliente");
		cliente.setNome(scString.nextLine());
		System.out.println("Digite o logradouro: ");
		cliente.setNome(scString.nextLine());
		System.out.println("Digite o número: ");
		cliente.setNumero(scString.nextLine());
		System.out.println("Digite o bairro: ");
		cliente.setBairro(scString.nextLine());
		System.out.println("Ditie o município: ");
		cliente.setMunicipio(scString.nextLine());
		System.out.println("Digite o estado: ");
		cliente.setEstado(scString.nextLine());
		System.out.println("Digite o CEP: ");
		cliente.setCep(scString.nextLine());
		System.out.println("Digite o telefone: ");
		cliente.setTelefone(scString.nextLine());
		System.out.println("Alterações feitas com sucesso!");
	}

	public void consultar() {
		if (cli.isEmpty()) {
			System.out.println("Não há clientes cadastrados");
		} else {
			System.out.println("Digite a identificação do cliente que deseja buscar: ");
			int id = scInt.nextInt();
			boolean achou = false;
			for (Cliente c : cli) {
				if (c.getIdentificacao() == id) {
					c.imprimir();
					achou = true;
					break;
				}
			}

			if (achou == false) {
				System.out.println("Não foi encontrado nenhum cadastro para o identificador informado!");

			}

		}
	}

	public void excluir() {
		if (cli.isEmpty()) {
			System.out.println("Não há clientes cadastrados");
		} else {
			System.out.println("Digite a identificação que deseja excluir: ");
			int id = scInt.nextInt();
			for (Cliente c : cli) {
				if (c.getIdentificacao() == id) {
					c.imprimir();
					System.out.println("Confirma a exclusão desse cadastro? 1 p/ sim ou 2 p/ não");
					int confirma = scInt.nextInt();
					if(confirma == 1) {
						cli.remove(c);
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
