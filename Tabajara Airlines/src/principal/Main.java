package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	ArrayList<Cliente> clientes = new ArrayList<>();
	GerenciaCliente gc = new GerenciaCliente(clientes);
	Scanner sc = new Scanner(System.in);
	int op, sop;
	
	do {
		System.out.println("1 - Clientes");
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
					gc.relatorio();
					break;
				}
				
			}while(sop != 0);
		case 0:
			System.out.println("Encerrado");
		}
	}while(op != 0);
	
	
	}
}