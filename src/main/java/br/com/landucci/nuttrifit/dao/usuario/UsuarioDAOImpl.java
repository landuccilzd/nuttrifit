package br.com.landucci.nuttrifit.dao.usuario;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.landucci.nuttrifit.modelo.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void salvar(Usuario usuario) {
		this.manager.persist(usuario);
	}
	
	@Override
	public void alterar(Usuario usuario) {
		this.manager.merge(usuario);
	}
	
	@Override
	public void excluir(Usuario usuario) {
		this.manager.remove(usuario);
	}

	@Override
	public Usuario buscar(Long id) {
		return (Usuario) this.manager.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> listar() {
		return this.manager.createQuery("from Usuario usuario", Usuario.class).getResultList();
	}
	
	@Override
	public Usuario buscarPorLogin(String login) {
		Query consulta = this.manager.createQuery("from Usuario usuario where usuario.login = :login");
		consulta.setParameter("login", login);
		return (Usuario) consulta.getSingleResult();
	}
	
	@Override
	public Usuario buscarPorEmail(String email) {
		Query consulta = this.manager.createQuery("select usuario from Usuario usuario where usuario.pessoa.email = :email");
		consulta.setParameter("email", email);
		return (Usuario) consulta.getSingleResult();
	}
}