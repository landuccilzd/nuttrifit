package br.com.landucci.nuttrifit.dao.antropometria;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.landucci.nuttrifit.modelo.PerfilMedicao;

@Repository
public class PerfilMedicaoDAOImpl implements PerfilMedicaoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void salvar(PerfilMedicao perfilMedicao) {
		this.manager.persist(perfilMedicao);
	}
	
	@Override
	public void alterar(PerfilMedicao perfilMedicao) {
		this.manager.merge(perfilMedicao);
	}
	
	@Override
	public void excluir(PerfilMedicao perfilMedicao) {
		this.manager.remove(perfilMedicao);
	}

	@Override
	public PerfilMedicao buscar(Long id) {
		return (PerfilMedicao) this.manager.find(PerfilMedicao.class, id);
	}

	@Override
	public List<PerfilMedicao> listar() {
		return this.manager.createQuery("from PerfilMedicao perfilMedicao", PerfilMedicao.class).getResultList();
	}
}