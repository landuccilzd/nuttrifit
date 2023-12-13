package br.com.landucci.nuttrifit.modelo;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="grupo_alimento")
public class GrupoAlimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy="grupoAlimento")
	private List<Alimento> alimentoList;
	
	public Long getId() {
		return id;
	}
	public List<Alimento> getAlimentoList() {
		return alimentoList;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setAlimentoList(List<Alimento> alimentoList) {
		this.alimentoList = alimentoList;
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
		GrupoAlimento other = (GrupoAlimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}