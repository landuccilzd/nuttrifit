package br.com.landucci.nuttrifit.dao.antropometria;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.GrupoMedicao;

public interface GrupoMedicaoDAO {
	public void salvar(GrupoMedicao grupoMedicao);
	public void alterar(GrupoMedicao grupoMedicao);
	public void excluir(GrupoMedicao grupoMedicao);
	public GrupoMedicao buscar(Long id);
	public List<GrupoMedicao> listar();
}
