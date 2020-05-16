package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<>();
		ArrayList<Voo> voos = new ArrayList<>();
		ArrayList<Aviao> avioes = new ArrayList<>();
		ArrayList<Aeroporto> aeroportos = new ArrayList<>();
		ArrayList<Passagem> passagens = new ArrayList<>();

		GerenciaCliente gc = new GerenciaCliente(clientes);
		GerenciaAeroporto ga = new GerenciaAeroporto(aeroportos);
		GerenciaAviao gav = new GerenciaAviao(avioes);
		GerenciaPassagem gp = new GerenciaPassagem(passagens, avioes, aeroportos, voos, clientes);
		GerenciaVoo gv = new GerenciaVoo(avioes, aeroportos, voos);


		Scanner sc = new Scanner(System.in);
		int op, sop;

		do {
			System.out.println("1 - Clientes");
			System.out.println("2 - Aviões");
			System.out.println("3 - Aeroportos");
			System.out.println("4 - Voos");
			System.out.println("5 - Passagens");
			System.out.println("0 - Encerrar aplicação");
			op = sc.nextInt();
			switch(op) {
			case 1:
				do {
					System.out.println("1 - Cadastrar");
					System.out.println("2 - Alterar");
					System.out.println("3 - Excluir");
					System.out.println("4 - Relatório");
					System.out.println("0 - Voltar");
					sop = sc.nextInt();
					switch(sop) {
					case 1:
						gc.cadastrar();
						break;
					case 2:
						gc.alterar();
						break;
					case 3:
						gc.excluir();
						break;
					case 4:
						gc.relatorio();
						break;
					case 0:
						break;
					default:
						System.out.println("OPÇÃO INVÁLIDA");
						break;
					
					}
					}while(sop != 0);
				case 2:
					do {
						System.out.println("1 - Cadastrar");
						System.out.println("2 - Alterar");
						System.out.println("3 - Excluir");
						System.out.println("4 - Relatório");
						System.out.println("0 - Voltar");
						sop = sc.nextInt();
						switch(sop) {
						case 1:
							gav.cadastrar();
							break;
						case 2:
							gav.alterar();
							break;
						case 3:
							gav.excluir();
							break;
						case 4:
							gav.relatorio();
							break;
						case 0:
							break;
						default:
							System.out.println("OPÇÃO INVÁLIDA");
							break;
						}
						break;

					}while(sop != 0);
					
					
				case 3:
					do {
						System.out.println("1 - Cadastrar");
						System.out.println("2 - Alterar");
						System.out.println("3 - Excluir");
						System.out.println("4 - Relatório");
						System.out.println("0 - Voltar");
						sop = sc.nextInt();
						switch(sop) {
						case 1:
							ga.cadastrar();
							break;
						case 2:
							ga.alterar();
							break;
						case 3:
							ga.excluir();
							break;
						case 4:
							ga.relatorio();
							break;
						case 0:
							break;
						default:
							System.out.println("OPÇÃO INVÁLIDA");
							break;
						}
						break;

					}while(sop != 0);
					
				case 4:
					do {
						System.out.println("1 - Cadastrar");
						System.out.println("2 - Alterar");
						System.out.println("3 - Excluir");
						System.out.println("4 - Relatório");
						System.out.println("0 - Voltar");
						sop = sc.nextInt();
						switch(sop) {
						case 1:
							gv.cadastrar();
							break;
						case 2:
							gv.alterar();
							break;
						case 3:
							gv.excluir();
							break;
						case 4:
							gv.relatorio();
							break;
						case 0:
							break;
						default:
							System.out.println("OPÇÃO INVÁLIDA");
							break;
						}
						break;

					}while(sop != 0);
					
					
				case 5:
					do {
						System.out.println("1 - Venda");
						System.out.println("2 - Cancelamento");
						System.out.println("3 - Relatórios");
						System.out.println("0 - Voltar");
						
						sop = sc.nextInt();
						switch(sop) {
						case 1:
							gp.venda();
							break;
						case 2:
							// ainda não feito
							break;
						case 3:
							ga.relatorio();
							break;
						case 0:
							break;
						default:
							System.out.println("OPÇÃO INVÁLIDA");
							break;
						}
						break;

					}while(sop != 0);
					
					
					
			case 0:
				System.out.println("Encerrado");
			}
		}while(op != 0);
			
			
	}
}