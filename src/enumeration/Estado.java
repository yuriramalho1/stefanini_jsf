package enumeration;



public enum Estado {
	AC("AC", "Acre"), 
	AL("AL", "Alagoas"), 
	AP("AP", "Amapa"), 
	AM("AM", "Amazonas"), 
	BA("BA", "Bahia"), 
	CE("CE", "Cear�"), 
	DF("DF", "Distrito Federal"), 
	ES("ES", "Espirito Santo"), 
	GO("GO", "Goiaiss"), 
	MA("MA", "Maranh�o"), 
	MT("MT", "Mato Grosso"), 
	MS("MS", "Mato Grosso do Sul"), 
	MG("MG", "Minas Gerais"), 
	PA("PA", "Par�"), 
	PB("PB", "Para�a"), 
	PR("PA", "Paran�"), 
	PE("PE", "Pernambuco"), 
	PI("PI","Piau�"),
	RJ("RJ", "Rio de Janeiro"), 
	RN("RN", "Rio Grande do Norte"), 
	RS("RS","Rio Grande do Sul"), 
	RO("RO", "Rondonia"), 
	RR("RR","Roraima"), 
	SC("SC", "Santa Catarina"), 
	SP("SP","S�o Paulo"), 
	SE("SE", "Sergipe"), 
	TO("TO", "Tocantins");

	private String sigla;
	private String nome;

	private Estado(String sigla, String nome) {
		this.sigla = sigla;
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
