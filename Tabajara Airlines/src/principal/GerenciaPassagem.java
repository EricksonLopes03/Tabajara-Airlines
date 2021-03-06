package principal;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaPassagem {



	private ArrayList<Aviao> avioes;
	private ArrayList<Aeroporto> aeroportos;
	private ArrayList<Voo> voos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Passagem> passagens;
	private Scanner sc = new Scanner(System.in);
	private DecimalFormat formatador = new DecimalFormat("0.00");

	public GerenciaPassagem(ArrayList<Passagem> passagens, ArrayList<Aviao> avioes, ArrayList<Aeroporto> aeroportos, ArrayList<Voo> voos, ArrayList<Cliente> clientes) {
		this.avioes = avioes;
		this.aeroportos = aeroportos;
		this.voos = voos;
		this.clientes = clientes;
		this.passagens = passagens;
	}


	public void venda() {
		int pos, codigo;
		LocalDate data;
		LocalTime hora;
		double preco;

		if(clientes.isEmpty()) {
			System.out.println(" N�o h� clientes cadastrados");
		}else if(voos.isEmpty()){
			System.out.println(" N�o h� v�os cadastrados");
		}else {

			System.out.println("Digite a posi��o do cliente: ");
			pos = sc.nextInt();
			if(pos < 0 || pos >= clientes.size()) {
				System.out.println("\n Posi��o inv�lida");
			}else {
				Cliente cli = clientes.get(pos);
				System.out.println("Digite a posi��o do voo");
				pos = sc.nextInt();
				if(pos < 0 || pos >= voos.size()) {
					System.out.println("\n Posi��o inv�lida");
				}else {
					Voo voo = voos.get(pos);

					if(voo.getLotacao() < voo.getAviao().getCapacPassageiros()) {
						System.out.println("Data da venda da passagem:");
						System.out.println("Dia:");
						int dia = sc.nextInt();
						System.out.println("M�s: ");
						int mes = sc.nextInt();
						System.out.println("Ano: ");
						int ano = sc.nextInt();
						data = LocalDate.of(ano, mes, dia);
						System.out.println("Hora: ");
						int hor = sc.nextInt()	;
						System.out.println("Minuto");
						int min = sc.nextInt();
						hora = LocalTime.of(hor, min);
						System.out.println("Digite o peso da bagagem do cliente");
						double peso = sc.nextDouble();


						preco = voo.getPrecoViagem();

						double pesotot = voo.getPesoCargaEmbrcada() + peso;

						if(pesotot > voo.getAviao().getCapacCarga()) {
							System.out.println("Imposs�vel embarcar o passageiro no voo, carga total excede o limite do avi�o.");
						}else {
							if(data.isAfter(voo.getDataPartida())) {
								System.out.println("Imposs�vel vender passagem ap�s a partida do voo");


							}else if(data.isBefore(voo.getDataPartida().minusDays(10))) {
								preco = ( voo.getPrecoViagem() - (voo.getPrecoViagem() * 0.074));
								if(passagens.isEmpty()) {
									codigo = 1;
								}else {
									codigo = 1;
									for(Passagem p : passagens) {
										if(p.getCodigo() == codigo) {
											codigo = (p.getCodigo() + 1);
										}
									}
								}

								passagens.add(new Passagem(cli, codigo, voo, data, hora, preco, peso));
								voo.setLotacao(voo.getLotacao() + 1);
								voo.setPesoCargaEmbrcada(pesotot);
								voo.setPrecoVoo(voo.getPrecoVoo() + preco);
								System.out.println(" Venda de passagem conclu�da! ");

							}else {
								preco = ( voo.getPrecoViagem() - (voo.getPrecoViagem() * 0.053));
								if(passagens.isEmpty()) {
									codigo = 1;
								}else {
									codigo = 1;
									for(Passagem p : passagens) {
										if(p.getCodigo() == codigo) {
											codigo = (p.getCodigo() + 1);
										}
									}
								}

								passagens.add(new Passagem(cli, codigo, voo, data, hora, preco, peso));
								voo.setLotacao(voo.getLotacao() + 1);
								voo.setPesoCargaEmbrcada(pesotot);
								voo.setPrecoVoo(voo.getPrecoVoo() + preco);
								System.out.println(" Venda de passagem conclu�da! ");
							}

						}




					}else {
						System.out.println("\n Voo lotado");
					}
				}}}
	}



	public void cancelar() {

		int pos;

		System.out.println("Digite a posi��o da passagem que deseja cancelar");
		pos = sc.nextInt();

		if(pos < 0 || pos >= passagens.size()) {
			System.out.println("\n Posi��o inv�lida");
		}else {

			Passagem p = passagens.get(pos);
			p.imprimir();
			System.out.println("Deseja realmente cancelar essa passagem?");
			System.out.println("    1 - SIM       |       2 - N�O ");
			int opc = sc.nextInt();
			if(opc == 1) {
				Voo v = p.getVoo();
				v.setPesoCargaEmbrcada(v.getPesoCargaEmbrcada() - p.getPeso());
				v.setLotacao(v.getLotacao() - 1);
				v.setPrecoVoo(v.getPrecoVoo() - p.getPrecoFinalViagem());
				passagens.remove(pos);
				System.out.println("\n Passagem cancelada com sucesso, informa��es atualizadas na base de dados");
			}else if(opc == 2) {
				System.out.println("Cancelamento n�o realizado");
			}else {
				System.out.println("Op��o inv�lida");
			}
		}

	}











	public void relatorio() {
		int pos, op;
		Voo voo;
		System.out.println("\n\n====[ Menu relat�rios de voo e passagens ]====");
		System.out.println(" 1 - Quantidade de lugares dispon�veis no voo ");
		System.out.println(" 2 - Capacidade de carga dispon�vel no voo ");
		System.out.println(" 3 - Total arrecadado no voo ");
		System.out.println(" 4 - Listagem de passageiros no voo ");
		System.out.println(" 5 - Listagem de passageiros no voo junto do valor da passagem e desconto total oferecido");
		System.out.println(" 6 - Retornar");
		op = sc.nextInt();

		switch(op) {
		case 1:
			System.out.println("Digite a posi��o do voo");
			pos = sc.nextInt();
			if(pos < 0 || pos >= voos.size()) {
				System.out.println("\n Posi��o inv�lida");
			}else {
			voo = voos.get(pos);
			int lugares = (voo.getAviao().getCapacPassageiros() - voo.getLotacao());

			System.out.println("\n\n Voo posi��o: " + pos);
			System.out.println("Lugares Dispon�veis: " + lugares + "\n");
			}
			break;

		case 2:
			System.out.println("Digite a posi��o do voo");
			pos = sc.nextInt();
			if(pos < 0 || pos >= voos.size()) {
				System.out.println("\n Posi��o inv�lida");
			}else {
			voo = voos.get(pos);
			double carga = (voo.getAviao().getCapacCarga() - voo.getPesoCargaEmbrcada());
			System.out.println("\n\n Voo posi��o: " + pos);
			System.out.println("Capacidade de carga dispon�vel: " + carga + "\n");
			break;
			}
		case 3:

			System.out.println("Digite a posi��o do voo");
			pos = sc.nextInt();
			if(pos < 0 || pos >= voos.size()) {
				System.out.println("\n Posi��o inv�lida");
			}else {
			voo = voos.get(pos);
			System.out.println("\n\n Voo posi��o: " + pos);
			System.out.println(" Total arrecadado: R$ " + formatador.format(voo.getPrecoVoo()) + "\n");

			}
			break;

		case 4:

			System.out.println("Digite a posi��o do voo");
			pos = sc.nextInt();
			voo = voos.get(pos);
			System.out.println("\n\n Voo posi��o: " + pos);
			for(Passagem p : passagens) {
				if(p.getVoo().equals(voo)) {
					System.out.println("Passageiro identifica��o " + p.getCliente().getIdentificacao() + " incluso no v�o");
				}
			}

			break;

		case 5:

			System.out.println("Digite a posi��o do voo");
			pos = sc.nextInt();
			if(pos < 0 || pos >= voos.size()) {
				System.out.println("\n Posi��o inv�lida");
			}else {
			voo = voos.get(pos);
			System.out.println("\n\n Voo posi��o: " + pos);
			for(Passagem p : passagens) {
				if(p.getVoo().equals(voo)) {
					System.out.println("Passageiro identifica��o " + p.getCliente().getIdentificacao() + " incluso no voo, valor passagem: R$ " + p.getPrecoFinalViagem());
				}
			}

			double tot = ((voo.getLotacao() * voo.getPrecoViagem()) - voo.getPrecoVoo());
			System.out.println("\n Valor total de descontos condedidos na viagem: R$ " + formatador.format(tot));

			}
			break;

		case 6:
			break;

		default:
			System.out.println("OP��O INV�LIDA");
			break;


		}


	}









}
