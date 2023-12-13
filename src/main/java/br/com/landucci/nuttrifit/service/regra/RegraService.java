package br.com.landucci.nuttrifit.service.regra;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.Regra;
import br.com.landucci.nuttrifit.service.ServiceException;

public interface RegraService {
	public Regra buscar(String id) throws ServiceException;
	public List<Regra> listar() throws ServiceException;
	public void salvar(Regra regra) throws ServiceException;
	public void alterar(Regra regra) throws ServiceException;
	public void excluir(Regra regra) throws ServiceException;	
}