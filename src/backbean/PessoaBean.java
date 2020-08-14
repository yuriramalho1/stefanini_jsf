package backbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import enumeration.Estado;
import enumeration.Sexo;
import model.entitys.Pessoa;
import repository.PessoaRepository;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 6725991683911475750L;

	@Inject
	private PessoaRepository pessoaRepository;
	
	private Pessoa pessoa;
	private Pessoa pessoaSelecionada;
	private List<Pessoa> listPessoasCadastradas;
	
	public PessoaBean() {
	 if(pessoa == null) {
	    pessoa = new Pessoa();
	 }
	}
	
	@PostConstruct
	public void init() {
	 this.consulta();	 
	}

	public Sexo[] listaSexo() {
		return Sexo.values();
	}
	
	public Estado[] listaEstado() {
		return Estado.values();
	}

	public void cadastrar() {
		try {
			setPessoaSelecionada(pessoaRepository.salvar(pessoa));
			if(getPessoaSelecionada() != null && getPessoaSelecionada().getId() != null) {
				this.consulta();
				FacesContext.getCurrentInstance().addMessage(
					  null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados salvos com sucesso", ""));
			}else {
			  FacesContext.getCurrentInstance().addMessage(
					  null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar salvar os dados", "")); 	
			}
			this.limpar();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(":growlMsg",
			new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
	
	public void consulta() {
		try {
			listPessoasCadastradas = pessoaRepository.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(":growlMsg",
			new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
	
	public void excluir() {
		try {
			if(getPessoaSelecionada() != null && getPessoaSelecionada().getId() != null) {
			  pessoaRepository.delete(getPessoaSelecionada(), getPessoaSelecionada().getId());
			  FacesContext.getCurrentInstance().addMessage(":growlMsg",
			  new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados excluídos com sucessi", null));
			  this.consulta();
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(":growlMsg",
			new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public void limpar() {
	  setPessoa(new Pessoa());
	  setPessoaSelecionada(new Pessoa());
	}
	public List<Pessoa> getListPessoasCadastradas() {
		return listPessoasCadastradas;
	}

	public void setListPessoasCadastradas(List<Pessoa> listPessoasCadastradas) {
		this.listPessoasCadastradas = listPessoasCadastradas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	
}
