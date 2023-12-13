package br.com.landucci.nuttrifit.dao.antropometria;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.landucci.nuttrifit.modelo.GrupoMedicao;

@Repository
public class GrupoMedicaoDAOImpl implements GrupoMedicaoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void salvar(GrupoMedicao grupoMedicao) {
		this.manager.persist(grupoMedicao);
	}
	
	@Override
	public void alterar(GrupoMedicao grupoMedicao) {
		this.manager.merge(grupoMedicao);
	}
	
	@Override
	public void excluir(GrupoMedicao grupoMedicao) {
		this.manager.remove(grupoMedicao);
	}

	@Override
	public GrupoMedicao buscar(Long id) {
		return (GrupoMedicao) this.manager.find(GrupoMedicao.class, id);
	}

	@Override
	public List<GrupoMedicao> listar() {
		return this.manager.createQuery("from GrupoMedicao grupoMedicao", GrupoMedicao.class).getResultList();
	}
}