package br.com.crudwebservice.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.crudwebservice.bean.Pessoa;

@Stateless
public class PessoaDao {

	@PersistenceContext(unitName = "webserviceAndroid")
	private EntityManager entityManager;

	public Pessoa insert(Pessoa pessoa) {
		try {
			entityManager.persist(pessoa);
			entityManager.flush();
			return pessoa;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Pessoa update(Pessoa pessoa) {
		try {
			entityManager.merge(pessoa);
			entityManager.flush();
			return pessoa;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Pessoa findByPk(Integer id) {
		try {
			return entityManager.find(Pessoa.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(Pessoa pessoa) {
		try {
			pessoa = entityManager.find(Pessoa.class, pessoa.getId());
			entityManager.remove(pessoa);
			entityManager.flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll() {
		return entityManager.createQuery("FROM Pessoa").getResultList();
	}
}
