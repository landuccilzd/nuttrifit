package br.com.landucci.nuttrifit.service.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.landucci.nuttrifit.dao.usuario.UsuarioDAO;
import br.com.landucci.nuttrifit.modelo.Usuario;
import br.com.landucci.nuttrifit.service.ServiceException;
import br.com.landucci.nuttrifit.util.NuttrifitHelper;

@Service
public class UsuarioServiceImpl implements UsuarioService {
		
	@Autowired		
	private UsuarioDAO usuarioDao;
	
	public Usuario buscar(Long id) throws ServiceException {
		return this.usuarioDao.buscar(id);
	}
	
	public Usuario buscarPorLogin(String login) throws ServiceException {
		return this.usuarioDao.buscarPorLogin(login);
	}
	
	public List<Usuario> listar() throws ServiceException {
		return this.usuarioDao.listar();
	}
	
	public void salvar(Usuario usuario) throws ServiceException {
		String strValidacao = validarCreate(usuario);
		if (!NuttrifitHelper.isNulo(strValidacao)) {
			throw new ServiceException(strValidacao);
		}
		this.usuarioDao.salvar(usuario);
	}
	
	public void alterar(Usuario usuario) throws ServiceException {
		String strValidacao = validarUpdate(usuario);
		if (!NuttrifitHelper.isNulo(strValidacao)) {
			throw new ServiceException(strValidacao);
		}		
		this.usuarioDao.alterar(usuario);
	}
	
	public void alterarSenha(Usuario usuario, String senha, String novaSenha, String validacao) throws ServiceException {
		String strValidacao = validarUpdateSenha(usuario, senha, novaSenha, validacao);
		if (!NuttrifitHelper.isNulo(strValidacao)) {
			throw new ServiceException(strValidacao);
		}		
		usuario.setSenha(novaSenha);
		this.usuarioDao.alterar(usuario);
	}	
	
	public void excluir(Usuario usuario) throws ServiceException {
		this.usuarioDao.excluir(usuario);
	}
	
	private String validarCreate(Usuario usuario) {
		return "";
	}
	
	private String validarUpdate(Usuario usuario) {
		return "";
	}
	
	private String validarUpdateSenha(Usuario usuario, String senha, String novaSenha, String confirmacao) {
		if (!senha.equals(usuario.getSenha())) {
			return "A senha informada não está correta";
		}
		if (!novaSenha.equals(confirmacao)) {
			return "A confirmação da senha informada não confere com a nova senha";
		}
		return "";
	}

	@Override
	public Usuario buscarPorEmail(String email) throws ServiceException {
		return this.usuarioDao.buscarPorEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			return buscarPorLogin(username);
		} catch (ServiceException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
	}	
}