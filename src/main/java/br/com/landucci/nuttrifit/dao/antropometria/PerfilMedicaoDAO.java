package br.com.landucci.nuttrifit.dao.antropometria;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.PerfilMedicao;

public interface PerfilMedicaoDAO {
	public void salvar(PerfilMedicao perfilMedicao);
	public void alterar(PerfilMedicao perfilMedicao);
	public void excluir(PerfilMedicao perfilMedicao);
	public PerfilMedicao buscar(Long id);
	public List<PerfilMedicao> listar();
}
