package br.com.landucci.nuttrifit.service.antropometria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.landucci.nuttrifit.dao.antropometria.PerfilMedicaoDAO;
import br.com.landucci.nuttrifit.modelo.PerfilMedicao;
import br.com.landucci.nuttrifit.service.ServiceException;

@Service
public class PerfilMedicaoServiceImpl implements PerfilMedicaoService {

	private PerfilMedicaoDAO perfilMedicaoDao;

	@Autowired
	public PerfilMedicaoServiceImpl(PerfilMedicaoDAO perfilMedicaoDao) {
		this.perfilMedicaoDao = perfilMedicaoDao;
	}

	public PerfilMedicao buscar(Long id) {
		return this.perfilMedicaoDao.buscar(id);
	}
	
	public List<PerfilMedicao> listar() {
		return this.perfilMedicaoDao.listar();
	}
	
	public void salvar(PerfilMedicao perfilMedicao) {
		this.perfilMedicaoDao.salvar(perfilMedicao);
	}
	
	public void alterar(PerfilMedicao perfilMedicao) {
		this.perfilMedicaoDao.alterar(perfilMedicao);
	}
	
	public void excluir(PerfilMedicao perfilMedicao) throws ServiceException {
		this.perfilMedicaoDao.excluir(perfilMedicao);
	}
}