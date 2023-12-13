package br.com.landucci.nuttrifit.service.pessoa;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.Pessoa;
import br.com.landucci.nuttrifit.service.ServiceException;

public interface PessoaService {
	public Pessoa buscar(Long id) throws ServiceException;
	public List<Pessoa> listar() throws ServiceException;
	public void salvar(Pessoa pessoa) throws ServiceException;
	public void alterar(Pessoa pessoa) throws ServiceException;
	public void excluir(Pessoa pessoa) throws ServiceException;
	public List<Pessoa> listarPorNutricionista(Pessoa nutricionista) throws ServiceException;
}