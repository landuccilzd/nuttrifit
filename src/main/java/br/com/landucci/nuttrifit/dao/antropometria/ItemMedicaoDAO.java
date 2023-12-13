package br.com.landucci.nuttrifit.dao.antropometria;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.ItemMedicao;

public interface ItemMedicaoDAO {
	public void salvar(ItemMedicao itemMedicao);
	public void alterar(ItemMedicao itemMedicao);
	public void excluir(ItemMedicao itemMedicao);
	public ItemMedicao buscar(Long id);
	public List<ItemMedicao> listar();
}
