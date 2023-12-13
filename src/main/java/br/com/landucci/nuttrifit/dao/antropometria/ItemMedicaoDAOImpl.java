package br.com.landucci.nuttrifit.dao.antropometria;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.landucci.nuttrifit.modelo.ItemMedicao;

@Repository
public class ItemMedicaoDAOImpl implements ItemMedicaoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void salvar(ItemMedicao itemMedicao) {
		this.manager.persist(itemMedicao);
	}
	
	@Override
	public void alterar(ItemMedicao itemMedicao) {
		this.manager.merge(itemMedicao);
	}
	
	@Override
	public void excluir(ItemMedicao itemMedicao) {
		this.manager.remove(itemMedicao);
	}

	@Override
	public ItemMedicao buscar(Long id) {
		return (ItemMedicao) this.manager.find(ItemMedicao.class, id);
	}

	@Override
	public List<ItemMedicao> listar() {
		return this.manager.createQuery("from ItemMedicao itemMedicao", ItemMedicao.class).getResultList();
	}
}