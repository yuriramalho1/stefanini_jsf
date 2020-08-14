package repository;

import java.util.List;

import model.entitys.Pessoa;

public interface PessoaRepository  {

	Pessoa salvar(Pessoa Pessoa) throws Exception;

	Pessoa getPessoaPorCpf(String cpf);
	List<Pessoa> selectAll();
	void delete(Pessoa entity, Long id);
	
}
