package br.com.landucci.nuttrifit.service.token;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.Token;
import br.com.landucci.nuttrifit.service.ServiceException;

public interface TokenService {
	public Token buscar(Long id) throws ServiceException;
	public List<Token> listar() throws ServiceException;
	public void salvar(Token token) throws ServiceException;
	public void alterar(Token token) throws ServiceException;
	public void excluir(Token token) throws ServiceException;	
	public Token buscarPorToken(String token) throws ServiceException;
}