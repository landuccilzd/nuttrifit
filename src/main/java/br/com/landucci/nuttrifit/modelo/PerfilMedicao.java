package br.com.landucci.nuttrifit.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="perfil_medicao")
public class PerfilMedicao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;

	@OneToMany(mappedBy="perfilMedicao")
	private List<GrupoMedicao> grupoMeicaoList;
	
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public List<GrupoMedicao> getGrupoMeicaoList() {
		return grupoMeicaoList;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setGrupoMeicaoList(List<GrupoMedicao> grupoMeicaoList) {
		this.grupoMeicaoList = grupoMeicaoList;
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
		PerfilMedicao other = (PerfilMedicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
	
}