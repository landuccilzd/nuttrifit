package br.com.landucci.nuttrifit.service.usuario;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.landucci.nuttrifit.modelo.Usuario;
import br.com.landucci.nuttrifit.service.ServiceException;

public interface UsuarioService extends UserDetailsService {
	public Usuario buscar(Long id) throws ServiceException;
	public List<Usuario> listar() throws ServiceException;
	public void salvar(Usuario usuario) throws ServiceException;
	public void alterar(Usuario usuario) throws ServiceException;
	public void alterarSenha(Usuario usuario, String senha, String novaSenha, String validacao) throws ServiceException;
	public void excluir(Usuario usuario) throws ServiceException;	
	public Usuario buscarPorLogin(String login) throws ServiceException;
	public Usuario buscarPorEmail(String email) throws ServiceException;
}