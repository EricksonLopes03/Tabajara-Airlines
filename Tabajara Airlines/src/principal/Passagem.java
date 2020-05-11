package principal;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Passagem {

	private int codigo;
	private Cliente cliente;
	private Voo voo;
	private LocalDate dataVenda;
	private LocalTime horaVenda;
	private double precoFinalViagem;
	private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Passagem(Cliente cliente, int codigo, Voo voo, LocalDate dataVenda, LocalTime horaVenda, double precoFinalViagem) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.voo = voo;
		this.dataVenda = dataVenda;
		this.horaVenda = horaVenda;
		this.precoFinalViagem = precoFinalViagem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public LocalTime getHoraVenda() {
		return horaVenda;
	}

	public void setHoraVenda(LocalTime horaVenda) {
		this.horaVenda = horaVenda;
	}

	public double getPrecoFinalViagem() {
		return precoFinalViagem;
	}

	public void setPrecoFinalViagem(double precoFinalViagem) {
		this.precoFinalViagem = precoFinalViagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	public void imprimir() {
		System.out.println("--- Passagem código: " + codigo + " ---");
		System.out.println(" Identificação do cliente: " + cliente.getIdentificacao());
		System.out.println(" Codigo do vôo: " + voo.getCodigo());
		System.out.println(" Data da venda: " + dataVenda.format(formato));
		System.out.println(" Horário da venda: " + horaVenda);
		System.out.println(" Preço da Viagem: " + precoFinalViagem);
		
	}
	
	
}
