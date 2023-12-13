package br.com.landucci.nuttrifit.modelo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario implements UserDetails {
	private static final long serialVersionUID = -8895401267149003164L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	private boolean ativo;
	private boolean bloqueado;
	
	@ManyToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usuario_regra", joinColumns=@JoinColumn(name="usuario_id"), inverseJoinColumns=@JoinColumn(name="regra"))
	private List<Regra> regras = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public boolean isBloqueado() {
		return bloqueado;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public List<Regra> getRegras() {
		return regras;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public void setRegras(List<Regra> regras) {
		this.regras = regras;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return pessoa.getNomeTela() + " (" + login + ")";
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return regras;
	}
	
	@Override
	public String getPassword() {
		return senha;
	}
	@Override
	public String getUsername() {
		return login;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return ativo;
	}
	
	
}