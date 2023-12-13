package br.com.landucci.nuttrifit.dao.usuario;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.Usuario;

public interface UsuarioDAO {
	public void salvar(Usuario usuario);
	public void alterar(Usuario usuario);
	public void excluir(Usuario usuario);
	public Usuario buscar(Long id);
	public List<Usuario> listar();
	public Usuario buscarPorLogin(String login);
	public Usuario buscarPorEmail(String email);
}
