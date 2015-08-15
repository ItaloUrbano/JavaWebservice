package br.com.crudwebservice.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.crudwebservice.bean.Pessoa;
import br.com.crudwebservice.dao.PessoaDao;

@Stateless
public class PessoaBusiness {

	@Inject
	private PessoaDao pessoaDao;

	public Pessoa insert(Pessoa pessoa) {
		return pessoaDao.insert(pessoa);
	}

	public Pessoa update(Pessoa pessoa) {
		return pessoaDao.update(pessoa);
	}

	public Pessoa findByPk(Integer id) {
		return pessoaDao.findByPk(id);
	}

	public boolean delete(Pessoa pessoa) {
		return pessoaDao.delete(pessoa);
	}

	public List<Pessoa> findAll() {
		return pessoaDao.findAll();
	}
}
