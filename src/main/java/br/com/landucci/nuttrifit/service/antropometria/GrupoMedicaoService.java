package br.com.landucci.nuttrifit.service.antropometria;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.GrupoMedicao;
import br.com.landucci.nuttrifit.service.ServiceException;

public interface GrupoMedicaoService {
	public GrupoMedicao buscar(Long id) throws ServiceException;
	public List<GrupoMedicao> listar() throws ServiceException;
	public void salvar(GrupoMedicao grupoMedicao) throws ServiceException;
	public void alterar(GrupoMedicao grupoMedicao) throws ServiceException;
	public void excluir(GrupoMedicao grupoMedicao) throws ServiceException;
}