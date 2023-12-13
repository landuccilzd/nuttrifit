package br.com.landucci.nuttrifit.dao.token;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.landucci.nuttrifit.modelo.Token;

@Repository
public class TokenDAOImpl implements TokenDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void salvar(Token token) {
		this.manager.persist(token);
	}
	
	@Override
	public void alterar(Token token) {
		this.manager.merge(token);
	}
	
	@Override
	public void excluir(Token token) {
		this.manager.remove(token);
	}

	@Override
	public Token buscar(Long id) {
		return (Token) this.manager.find(Token.class, id);
	}

	@Override
	public List<Token> listar() {
		return this.manager.createQuery("from Token token", Token.class).getResultList();
	}
	
	@Override
	public Token buscarPorToken(String token) {
		Query consulta = this.manager.createQuery("from Token token where token.token = :token", Token.class);
		consulta.setParameter("token", token);
		return (Token) consulta.getSingleResult();
	}
}