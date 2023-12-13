package br.com.landucci.nuttrifit.dao.regra;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.Regra;

public interface RegraDAO {
	public void salvar(Regra regra);
	public void alterar(Regra regra);
	public void excluir(Regra regra);
	public Regra buscar(String id);
	public List<Regra> listar();
}
