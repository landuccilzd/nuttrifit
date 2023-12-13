package br.com.landucci.nuttrifit.dao.pessoa;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.landucci.nuttrifit.modelo.Pessoa;

@Repository
public class PessoaDAOImpl implements PessoaDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void salvar(Pessoa pessoa) {
		this.manager.persist(pessoa);
	}
	
	@Override
	public void alterar(Pessoa pessoa) {
		this.manager.merge(pessoa);
	}
	
	@Override
	public void excluir(Pessoa pessoa) {
		this.manager.remove(pessoa);
	}

	@Override
	public Pessoa buscar(Long id) {
		return (Pessoa) this.manager.find(Pessoa.class, id);
	}

	@Override
	public List<Pessoa> listar() {
		return this.manager.createQuery("from Pessoa pessoa", Pessoa.class).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Pessoa> listarPorNutricionista(Pessoa nutricionista) {
		Query query = this.manager.createQuery("from Pessoa pessoa where pessoa.nutricionista = :nutricionista", Pessoa.class);
		query.setParameter("nutricionista", nutricionista);
		return query.getResultList();
	}
}