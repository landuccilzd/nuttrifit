package br.com.landucci.nuttrifit.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="item_medicao")
public class ItemMedicao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Integer ordem;

	@ManyToOne
	@JoinColumn(name="grupo_medicao_id")
	private GrupoMedicao grupoMedicao;
	
	public Long getId() {
		return id;
	}
	public GrupoMedicao getGrupoMedicao() {
		return grupoMedicao;
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
	public void setGrupoMedicao(GrupoMedicao grupoMedicao) {
		this.grupoMedicao = grupoMedicao;
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
		ItemMedicao other = (ItemMedicao) obj;
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