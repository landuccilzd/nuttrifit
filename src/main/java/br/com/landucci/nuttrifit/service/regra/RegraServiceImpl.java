package br.com.landucci.nuttrifit.service.regra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.landucci.nuttrifit.dao.regra.RegraDAO;
import br.com.landucci.nuttrifit.modelo.Regra;
import br.com.landucci.nuttrifit.service.ServiceException;

@Service
public class RegraServiceImpl implements RegraService {
	
	@Autowired
	private RegraDAO regraDao;
	
	@Override
	public Regra buscar(String id) throws ServiceException {
		return this.regraDao.buscar(id);
	}
	
	@Override
	public List<Regra> listar() throws ServiceException {
		return this.regraDao.listar();
	}
	
	@Override
	public void salvar(Regra regra) throws ServiceException {
		this.regraDao.salvar(regra);
	}
	
	@Override
	public void alterar(Regra regra) throws ServiceException {
		this.regraDao.alterar(regra);
	}
 
	@Override
	public void excluir(Regra regra) throws ServiceException {
		this.regraDao.excluir(regra);
	}
}