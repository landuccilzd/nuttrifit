package br.com.landucci.nuttrifit.dao.token;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.Token;

public interface TokenDAO {
	public void salvar(Token token);
	public void alterar(Token token);
	public void excluir(Token token);
	public Token buscar(Long id);
	public List<Token> listar();
	public Token buscarPorToken(String token);
}
