package model.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enumeration.Estado;
import enumeration.Sexo;

@Entity
@Table(name = "pessoa")
@SequenceGenerator(sequenceName="seq_Pessoa", name = "seqPessoa",  allocationSize = 1 )
public class Pessoa implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1085941809606225218L;

	@Id
	@Column(name = "ID_PESSOA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPessoa" )
	private Long id;
	
	@Column(name="NOME", nullable = false)
	private String nome;
	
	@Column(name="CPF", nullable = false, unique = true )
	private String cpf;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="DATA_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name="SEXO")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(name = "naturalidade")
	private String naturalidade;
	
	@Column(name = "naturalidade_uf")
	@Enumerated(EnumType.STRING)
	private Estado naturalidadeUf;
	
	@Column(name = "nacionalidade")
	private String nacionalidade;
	
	@Column(name="DATA_CADASTRO")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj instanceof Pessoa)
			if(((Pessoa)obj).getId().equals(this.id)) return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toUpperCase();;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Estado getNaturalidadeUf() {
		return naturalidadeUf;
	}

	public void setNaturalidadeUf(Estado naturalidadeUf) {
		this.naturalidadeUf = naturalidadeUf;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}


	
}
