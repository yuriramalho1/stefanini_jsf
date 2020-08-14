package view;

public enum Mensagem implements MensagemGenerica {

	CPF_JA_CADASTRADO("CPF JÃ? CADASTRADO");

	
	private String codigo;

	private Mensagem(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String getCodigo() {
		return this.codigo;
	}
}