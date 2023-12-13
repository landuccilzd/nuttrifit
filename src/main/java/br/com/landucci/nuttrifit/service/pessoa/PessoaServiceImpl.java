package br.com.landucci.nuttrifit.service.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.landucci.nuttrifit.dao.pessoa.PessoaDAO;
import br.com.landucci.nuttrifit.modelo.Pessoa;
import br.com.landucci.nuttrifit.service.ServiceException;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaDAO pessoaDao;
	
	public Pessoa buscar(Long id) {
		return this.pessoaDao.buscar(id);
	}
	
	public List<Pessoa> listar() {
		return this.pessoaDao.listar();
	}
	
	public void salvar(Pessoa pessoa) {
		this.pessoaDao.salvar(pessoa);
	}
	
	public void alterar(Pessoa pessoa) {
		this.pessoaDao.alterar(pessoa);
	}
	
	public void excluir(Pessoa pessoa) throws ServiceException {
		this.pessoaDao.excluir(pessoa);
	}

	@Override
	public List<Pessoa> listarPorNutricionista(Pessoa nutricionista) throws ServiceException {
		return this.pessoaDao.listarPorNutricionista(nutricionista);
	}
}