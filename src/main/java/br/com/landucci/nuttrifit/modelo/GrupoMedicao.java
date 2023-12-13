package br.com.landucci.nuttrifit.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="grupo_medicao")
public class GrupoMedicao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Integer ordem;
	
	@ManyToOne
	@JoinColumn(name="perfil_medicao_id")
	private PerfilMedicao perfilMedicao;
	
	@OneToMany(mappedBy="grupoMedicao")
	private List<ItemMedicao> itemMedicaoList;
	
	public Long getId() {
		return id;
	}
	public PerfilMedicao getPerfilMedicao() {
		return perfilMedicao;
	}
	public String getDescricao() {
		return descricao;
	}
	public Integer getOrdem() {
		return ordem;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setPerfilMedicao(PerfilMedicao perfilMedicao) {
		this.perfilMedicao = perfilMedicao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
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
		GrupoMedicao other = (GrupoMedicao) obj;
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