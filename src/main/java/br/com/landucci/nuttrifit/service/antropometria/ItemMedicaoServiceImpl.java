package br.com.landucci.nuttrifit.service.antropometria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.landucci.nuttrifit.dao.antropometria.ItemMedicaoDAO;
import br.com.landucci.nuttrifit.modelo.ItemMedicao;
import br.com.landucci.nuttrifit.service.ServiceException;

@Service
public class ItemMedicaoServiceImpl implements ItemMedicaoService {

	private ItemMedicaoDAO itemMedicaoDao;

	@Autowired
	public ItemMedicaoServiceImpl(ItemMedicaoDAO itemMedicaoDao) {
		this.itemMedicaoDao = itemMedicaoDao;
	}

	public ItemMedicao buscar(Long id) {
		return this.itemMedicaoDao.buscar(id);
	}
	
	public List<ItemMedicao> listar() {
		return this.itemMedicaoDao.listar();
	}
	
	public void salvar(ItemMedicao itemMedicao) {
		this.itemMedicaoDao.salvar(itemMedicao);
	}
	
	public void alterar(ItemMedicao itemMedicao) {
		this.itemMedicaoDao.alterar(itemMedicao);
	}
	
	public void excluir(ItemMedicao itemMedicao) throws ServiceException {
		this.itemMedicaoDao.excluir(itemMedicao);
	}
}