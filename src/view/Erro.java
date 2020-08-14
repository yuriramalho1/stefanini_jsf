package view;

public enum Erro implements MensagemGenerica {
	
	REGISTRO_DUPLICADO("CPF J� FOI CADASTRADRO NO SISTEMA"),
    ACESSO_NEGADO("USU�RIO E/OU SENHA INCORRETO(S)");

	private String codigo;

	private Erro(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String getCodigo() {
		return this.codigo;
	}
}