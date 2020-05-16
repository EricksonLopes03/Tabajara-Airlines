package principal;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Voo {

	private Aviao aviao;
	private Aeroporto aeroportoPartida, aeroportoChegada;
	private LocalDate dataPartida, dataChegada;
	private LocalTime horaPartida, horaChegada;
	private int lotacao, codigo;
	private double pesoCargaEmbrcada, precoViagem, precoVoo;
	private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	public Voo() {
		
	}
	
	public Voo(Aviao aviao, Aeroporto aeroportoPartida, Aeroporto aeroportoChegada, LocalDate dataPartida,
			LocalDate dataChegada, LocalTime horaPartida, LocalTime horaChegada, int lotacao, double pesoCargaEmbrcada,
			double precoViagem, double precoVoo) {
		super();
		this.aviao = aviao;
		this.aeroportoPartida = aeroportoPartida;
		this.aeroportoChegada = aeroportoChegada;
		this.dataPartida = dataPartida;
		this.dataChegada = dataChegada;
		this.horaPartida = horaPartida;
		this.horaChegada = horaChegada;
		this.lotacao = lotacao;
		this.pesoCargaEmbrcada = pesoCargaEmbrcada;
		this.precoViagem = precoViagem;
		this.precoVoo = precoVoo;
	}

	public double getPrecoVoo() {
		return precoVoo;
	}

	public void setPrecoVoo(double precoVoo) {
		this.precoVoo = precoVoo;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	public Aeroporto getAeroportoPartida() {
		return aeroportoPartida;
	}

	public void setAeroportoPartida(Aeroporto aeroportoPartida) {
		this.aeroportoPartida = aeroportoPartida;
	}

	public Aeroporto getAeroportoChegada() {
		return aeroportoChegada;
	}

	public void setAeroportoChegada(Aeroporto aeroportoChegada) {
		this.aeroportoChegada = aeroportoChegada;
	}

	public LocalDate getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(LocalDate dataPartida) {
		this.dataPartida = dataPartida;
	}

	public LocalDate getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(LocalDate dataChegada) {
		this.dataChegada = dataChegada;
	}

	public LocalTime getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(LocalTime horaPartida) {
		this.horaPartida = horaPartida;
	}

	public LocalTime getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(LocalTime horaChegada) {
		this.horaChegada = horaChegada;
	}

	public int getLotacao() {
		return lotacao;
	}

	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}

	public double getPesoCargaEmbrcada() {
		return pesoCargaEmbrcada;
	}

	public void setPesoCargaEmbrcada(double pesoCargaEmbrcada) {
		this.pesoCargaEmbrcada = pesoCargaEmbrcada;
	}

	public double getPrecoViagem() {
		return precoViagem;
	}

	public void setPrecoViagem(double precoViagem) {
		this.precoViagem = precoViagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	public void imprimir() {
		System.out.println("Identificação do avião: " + aviao.getIdentificacao());
		System.out.println("ID Aeroporto de partida: " + aeroportoPartida.getIdentificacao());
		System.out.println("Data/hora partida: " + dataPartida.format(formato) + " às " + horaPartida);
		System.out.println("ID Aeroporto de chegada: " + aeroportoChegada.getIdentificacao());
		System.out.println("Data/hora chegada:" + dataChegada.format(formato) + " às " + horaChegada);
		System.out.println("Lotação: " + lotacao + "/" + aviao.getCapacPassageiros());
		System.out.println("Peso da carga embarcada: " + pesoCargaEmbrcada + "/" + aviao.getCapacCarga());
		System.out.println("Preço da viagem: " + precoViagem);
		System.out.println("\n\n");
	}
	
	
	
	
}
