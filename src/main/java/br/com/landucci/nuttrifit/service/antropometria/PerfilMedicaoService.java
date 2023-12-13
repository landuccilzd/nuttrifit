package br.com.landucci.nuttrifit.service.antropometria;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.PerfilMedicao;
import br.com.landucci.nuttrifit.service.ServiceException;

public interface PerfilMedicaoService {
	public PerfilMedicao buscar(Long id) throws ServiceException;
	public List<PerfilMedicao> listar() throws ServiceException;
	public void salvar(PerfilMedicao perfilMedicao) throws ServiceException;
	public void alterar(PerfilMedicao perfilMedicao) throws ServiceException;
	public void excluir(PerfilMedicao perfilMedicao) throws ServiceException;
}