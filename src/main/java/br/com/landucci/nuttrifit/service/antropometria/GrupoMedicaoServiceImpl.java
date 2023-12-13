package br.com.landucci.nuttrifit.service.antropometria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.landucci.nuttrifit.dao.antropometria.GrupoMedicaoDAO;
import br.com.landucci.nuttrifit.modelo.GrupoMedicao;
import br.com.landucci.nuttrifit.service.ServiceException;

@Service
public class GrupoMedicaoServiceImpl implements GrupoMedicaoService {

	private GrupoMedicaoDAO grupoMedicaoDao;

	@Autowired
	public GrupoMedicaoServiceImpl(GrupoMedicaoDAO grupoMedicaoDao) {
		this.grupoMedicaoDao = grupoMedicaoDao;
	}

	public GrupoMedicao buscar(Long id) {
		return this.grupoMedicaoDao.buscar(id);
	}
	
	public List<GrupoMedicao> listar() {
		return this.grupoMedicaoDao.listar();
	}
	
	public void salvar(GrupoMedicao grupoMedicao) {
		this.grupoMedicaoDao.salvar(grupoMedicao);
	}
	
	public void alterar(GrupoMedicao grupoMedicao) {
		this.grupoMedicaoDao.alterar(grupoMedicao);
	}
	
	public void excluir(GrupoMedicao grupoMedicao) throws ServiceException {
		this.grupoMedicaoDao.excluir(grupoMedicao);
	}
}