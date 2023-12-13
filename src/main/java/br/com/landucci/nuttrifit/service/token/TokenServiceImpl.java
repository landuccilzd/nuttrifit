package br.com.landucci.nuttrifit.service.token;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.landucci.nuttrifit.dao.token.TokenDAO;
import br.com.landucci.nuttrifit.modelo.Token;
import br.com.landucci.nuttrifit.service.ServiceException;

@Service
public class TokenServiceImpl implements TokenService {
	
	@Autowired
	private TokenDAO tokenDao;
	
	@Override
	public Token buscar(Long id) throws ServiceException {
		return this.tokenDao.buscar(id);
	}
	
	@Override
	public List<Token> listar() throws ServiceException {
		return this.tokenDao.listar();
	}
	
	@Override
	public void salvar(Token token) throws ServiceException {
		this.tokenDao.salvar(token);
	}
	
	@Override
	public void alterar(Token token) throws ServiceException {
		this.tokenDao.alterar(token);
	}
 
	@Override
	public void excluir(Token token) throws ServiceException {
		this.tokenDao.excluir(token);
	}

	@Override
	public Token buscarPorToken(String token) throws ServiceException {
		return this.tokenDao.buscarPorToken(token);
	}
}