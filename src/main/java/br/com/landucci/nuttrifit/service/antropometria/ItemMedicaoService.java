package br.com.landucci.nuttrifit.service.antropometria;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.ItemMedicao;
import br.com.landucci.nuttrifit.service.ServiceException;

public interface ItemMedicaoService {
	public ItemMedicao buscar(Long id) throws ServiceException;
	public List<ItemMedicao> listar() throws ServiceException;
	public void salvar(ItemMedicao itemMedicao) throws ServiceException;
	public void alterar(ItemMedicao itemMedicao) throws ServiceException;
	public void excluir(ItemMedicao itemMedicao) throws ServiceException;
}