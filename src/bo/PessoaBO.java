package bo;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dao.GenericHibernateDAO;
import model.entitys.Pessoa;
import repository.PessoaRepository;
import view.Erro;

public class PessoaBO extends GenericHibernateDAO<Pessoa> implements PessoaRepository, Serializable {
		

	/**
     *
     */
	private static final long serialVersionUID = -137260470483200068L;

	public PessoaBO() {
		super(Pessoa.class);
	}

	@Override
	public Pessoa salvar(Pessoa Pessoa) throws Exception {
		// TODO Auto-generated method stub
		if (Pessoa.getCpf() != null && !Pessoa.getCpf().equals("")) {
			Pessoa.setCpf(Pessoa.getCpf().replaceAll("\\.", "").replaceAll("\\/", "").replace("-", ""));
		}
		try {
			if (Pessoa != null && Pessoa.getId() == null) {
				if (!this.existeCpf(Pessoa)) {
					Pessoa.setDataCadastro(new Date(System.currentTimeMillis()));
					super.create(Pessoa);
				} else {
				  FacesContext.getCurrentInstance().addMessage(":growlMsg",
				  new FacesMessage(FacesMessage.SEVERITY_ERROR, Erro.REGISTRO_DUPLICADO.getCodigo(), null));
				}
			} else {
				super.update(Pessoa);
			}
		} catch (Exception e) {
			return null;
		}
		return Pessoa;

	}

	public boolean existeCpf(Pessoa Pessoa) throws Exception {
		try {
			Query queryPessoaes = em
					.createQuery("SELECT COUNT(c) FROM Pessoa c WHERE "
							+ "c.cpf =:cpf ");
			queryPessoaes.setParameter("cpf", Pessoa.getCpf());

			Number Pessoaes = (Number) queryPessoaes.getSingleResult();

			if (Pessoaes.longValue() > 0) {
				return true;
			}
			
			return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Pessoa getPessoaPorCpf(String cpf) {
		try {
			String cpfFormatado = cpf.replaceAll("\\.", "")
					.replaceAll("\\/", "").replace("-", "");
			TypedQuery<Pessoa> query = em.createQuery(
					"SELECT c FROM Pessoa c WHERE c.cpf =:cpf",
					Pessoa.class);
			query.setParameter("cpf", cpfFormatado);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}



}
