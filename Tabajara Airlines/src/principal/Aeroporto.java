package principal;

public class Aeroporto {

	private String identificacao, nome, municipio, estado, pais;

	public Aeroporto(String identificacao, String nome, String municipio, String estado, String pais) {
		super();
		this.identificacao = identificacao;
		this.nome = nome;
		this.municipio = municipio;
		this.estado = estado;
		this.pais = pais;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public void imprimir() {
		System.out.println("--- Aeroporto identificação: " + identificacao + " ---");
		System.out.println("Nome: " + nome);
		System.out.println("Municipio: "+ municipio);
		System.out.println("Estado: " + estado);
		System.out.println("País: " + pais);
		System.out.println("\n\n");
	}
	
	
}
