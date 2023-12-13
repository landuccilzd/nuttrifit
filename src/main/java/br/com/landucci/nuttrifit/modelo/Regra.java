package br.com.landucci.nuttrifit.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="regra")
public class Regra implements GrantedAuthority {
	private static final long serialVersionUID = -5084028611567608440L;

	@Id
	private String regra;
	
	public Regra() {
		this.regra = "";
	}
	
	public Regra(String regra) {
		this.regra = regra;
	}

	@Override
	public String getAuthority() {
		return regra;
	}

}
