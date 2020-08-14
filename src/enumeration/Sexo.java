package enumeration;

public enum Sexo {
	M("Masculino"),
	F("Feminino");

	
	private String descricao;
	
	Sexo(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	@Override
	public String toString() {
		return this.descricao;
	}
	
	

}
