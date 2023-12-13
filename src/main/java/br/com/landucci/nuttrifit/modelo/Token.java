package br.com.landucci.nuttrifit.modelo;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="token")
public class Token {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private String token;
	
	@Column(name="data_validacao")
	private Date dataValidacao;

	@Column(name="data_expiracao")
	private Date dataExpiracao;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}
	public String getTipo() {
		return tipo;
	}
	public String getToken() {
		return token;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Date getDataValidacao() {
		return dataValidacao;
	}
	public Date getDataExpiracao() {
		return dataExpiracao;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setDataValidacao(Date dataValidacao) {
		this.dataValidacao = dataValidacao;
	}
	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
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
		Token other = (Token) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return token;
	}
	
}