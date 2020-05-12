package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaCliente {

	
	private ArrayList<Cliente> cli;
	private Scanner sc = new Scanner(System.in);
	
	public GerenciaCliente(ArrayList<Cliente> cli) {
		this.cli = cli;

	}

	
	
	public void cadastrar(){
		
		int id;
		String nome, log, numero, bairro, municipio, estado, cep, telefone;
		boolean idDisponivel = true;
		
		do {
			idDisponivel = true;
		System.out.println("Digite a identificação do cliente: ");
		id = sc.nextInt();
		for(Cliente c : cli) {
			if(c.getIdentificacao() == id) {
				System.out.println("Esta identificação já está em uso");
				idDisponivel = false;
			}
		}
		
		}while(idDisponivel == false);
		sc.nextLine();
		
		System.out.println("Digite o nome do cliente");
		nome = sc.nextLine();
		System.out.println("Digite o logradouro: ");
		log = sc.nextLine();
		System.out.println("Digite o número: ");
		numero = sc.nextLine();
		System.out.println("Digite o bairro: ");
		bairro = sc.nextLine();
		System.out.println("Ditie o município: ");
		municipio = sc.nextLine();
		System.out.println("Digite o estado: ");
		estado = sc.nextLine();
		System.out.println("Digite o CEP: ");
		cep = sc.nextLine();
		System.out.println("Digite o telefone: ");
		telefone = sc.nextLine();
		
		cli.add(new Cliente(id, nome, log, numero, bairro, municipio, estado, cep, telefone));
		System.out.println("Cliente provavelmente cadastrado com sucesso;");
		
		
	}
	
	
	
	public void relatorio() {
		
		for(Cliente c : cli) {
			c.imprimir();
		}
	}
	
	
}
