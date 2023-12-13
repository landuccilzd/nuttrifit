package br.com.landucci.nuttrifit.dao.regra;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.landucci.nuttrifit.modelo.Regra;

@Repository
public class RegraDAOImpl implements RegraDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void salvar(Regra regra) {
		this.manager.persist(regra);
	}
	
	@Override
	public void alterar(Regra regra) {
		this.manager.merge(regra);
	}
	
	@Override
	public void excluir(Regra regra) {
		this.manager.remove(regra);
	}

	@Override
	public Regra buscar(String id) {
		return this.manager.find(Regra.class, id);
	}

	@Override
	public List<Regra> listar() {
		return this.manager.createQuery("from Regra regra", Regra.class).getResultList();
	}
}