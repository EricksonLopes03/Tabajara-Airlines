package principal;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class GerenciaVoo {


	private ArrayList<Aviao> avioes;
	private ArrayList<Aeroporto> aeroportos;
	private ArrayList<Voo> voos;
	private Scanner sc = new Scanner(System.in);
	


	public GerenciaVoo(ArrayList<Aviao> avioes, ArrayList<Aeroporto> aeroportos, ArrayList<Voo> voos) {
		this.avioes = avioes;
		this.aeroportos = aeroportos;
		this.voos = voos;
	}



	public void cadastrar(){

		int id, pos, dia, mes, ano, hora, minuto;
		LocalDate dataP, dataC;
		LocalTime horaP, horaC;

		if (aeroportos.isEmpty()) {
			System.out.println("Não há aeroportos cadastrados");
		}else {
			if (avioes.isEmpty()) {
				System.out.println("Não há aviões cadastrados");
			}else {

				System.out.println("\n Digite a posição do avião: ");
				pos = sc.nextInt();
				if(pos < 0 || pos >= avioes.size()) {
					System.out.println("\n Posição inválida");
				}else {
					Aviao aviao = avioes.get(pos);


					System.out.println("Digite a posição do aeroporto de partida: ");
					pos = sc.nextInt();
					if(pos < 0 || pos >= aeroportos.size()) {
						System.out.println("\n Posição inválida");
					}else {
					Aeroporto aeroP = aeroportos.get(pos);

					System.out.println("Data da partida:");
					System.out.println("Digite o dia:");
					dia = sc.nextInt();
					System.out.println("Digite o mês");
					mes = sc.nextInt();
					System.out.println("Digite o ano");
					ano = sc.nextInt();
					dataP = LocalDate.of(ano, mes, dia);
					System.out.println("Digite a hora");
					hora = sc.nextInt();
					System.out.println("Digite o minuto");
					minuto = sc.nextInt();
					horaP = LocalTime.of(hora, minuto);

					System.out.println("Digite a posição do aeroporto de chegada: ");
					if(pos < 0 || pos >= aeroportos.size()) {
						System.out.println("\n Posição inválida");
					}else {
					pos = sc.nextInt();
					Aeroporto aeroC = aeroportos.get(pos);


					System.out.println("Data da Chegada:");
					System.out.println("Digite o dia:");
					dia = sc.nextInt();
					System.out.println("Digite o mês");
					mes = sc.nextInt();
					System.out.println("Digite o ano");
					ano = sc.nextInt();
					dataC = LocalDate.of(ano, mes, dia);
					System.out.println("Digite a hora");
					hora = sc.nextInt();
					System.out.println("Digite o minuto");
					minuto = sc.nextInt();
					horaC = LocalTime.of(hora, minuto);

					System.out.println("Digite o preço da viagem: ");
					double preco = sc.nextDouble();

					voos.add(new Voo(aviao, aeroP, aeroC, dataP, dataC, horaP, horaC, 0, 0, preco, 0));

					}
					}
				}
			}
		}

	}



	public void alterar(){

		int pos, dia, mes, ano, hora, minuto;

		if (voos.isEmpty()) {
			System.out.println("Não há voos cadastrados");
		}else {

			System.out.println("Digite a posição do voo que deseja alterar: ");
			pos = sc.nextInt();
			if(pos < 0 || pos >= voos.size()) {
				System.out.println("\n Posição inválida");
			}else {
			Voo voo = voos.get(pos);

			System.out.println("Digite a posição do avião: ");
			
			pos = sc.nextInt();
			if(pos < 0 || pos >= aeroportos.size()) {
				System.out.println("\n Posição inválida");
			}else {
			voo.setAviao(avioes.get(pos));

			System.out.println("Digite a posição do aeroporto de partida: ");
			pos = sc.nextInt();
			if(pos < 0 || pos >= aeroportos.size()) {
				System.out.println("\n Posição inválida");
			}else {
			voo.setAeroportoPartida(aeroportos.get(pos));

			System.out.println("Data da partida:");
			System.out.println("Digite o dia:");
			dia = sc.nextInt();
			System.out.println("Digite o mês");
			mes = sc.nextInt();
			System.out.println("Digite o ano");
			ano = sc.nextInt();
			voo.setDataPartida(LocalDate.of(ano, mes, dia));
			System.out.println("Digite a hora");
			hora = sc.nextInt();
			System.out.println("Digite o minuto");
			minuto = sc.nextInt();
			voo.setHoraPartida(LocalTime.of(hora, minuto));

			System.out.println("Digite a posição do aeroporto de chegada: ");
			pos = sc.nextInt();
			if(pos < 0 || pos >= aeroportos.size()) {
				System.out.println("\n Posição inválida");
			}else {
			voo.setAeroportoChegada(aeroportos.get(pos));


			System.out.println("Data da Chegada:");
			System.out.println("Digite o dia:");
			dia = sc.nextInt();
			System.out.println("Digite o mês");
			mes = sc.nextInt();
			System.out.println("Digite o ano");
			ano = sc.nextInt();
			voo.setDataChegada(LocalDate.of(ano, mes, dia));
			System.out.println("Digite a hora");
			hora = sc.nextInt();
			System.out.println("Digite o minuto");
			minuto = sc.nextInt();
			voo.setHoraChegada(LocalTime.of(hora, minuto));


			System.out.println("Alterado com sucesso");

			}
		}
			}
			}
		}


	}

	public void excluir() {

		int pos;
		if (voos.isEmpty()) {
			System.out.println("Não há voos cadastrados");
		}else {

			System.out.println("Digite a posição do voo que deseja excluir: ");
			pos = sc.nextInt();
			if(pos < 0 || pos >= voos.size()) {
				System.out.println("\n Posição inválida");
			}else {
			Voo voo = voos.get(pos);

			voo.imprimir();
			System.out.println("Digite realmente excluir este voo?");
			System.out.println(" 1 - Sim        |         2 - Não");
			int op = sc.nextInt();
			if(op == 1) {
				voos.remove(voo);
				System.out.println("Excluido com sucesso");
			}else if(op == 2) {
				System.out.println("Exclusão cancelada");
			}else{
				System.out.println("Opção inválida, exclusão cancelada");
			}
		}
		}
	}

	public void relatorio() {
		if (voos.isEmpty()) {
			System.out.println("Não há voos cadastrados");
		}else {
			int pos = 0;
			for(Voo v : voos) {
				System.out.println("\n\n Posição " + pos + ": ");
				v.imprimir();
				pos++;
			}
		}
	}




}
