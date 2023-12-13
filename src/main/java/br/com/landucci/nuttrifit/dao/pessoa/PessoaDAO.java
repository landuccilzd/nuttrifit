package br.com.landucci.nuttrifit.dao.pessoa;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.Pessoa;

public interface PessoaDAO {
	public void salvar(Pessoa pessoa);
	public void alterar(Pessoa pessoa);
	public void excluir(Pessoa pessoa);
	public Pessoa buscar(Long id);
	public List<Pessoa> listar();
	public List<Pessoa> listarPorNutricionista(Pessoa nutricionista);
}