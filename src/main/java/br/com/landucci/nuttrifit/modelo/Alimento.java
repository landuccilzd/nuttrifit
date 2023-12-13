package br.com.landucci.nuttrifit.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="alimento")
public class Alimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	private String descricao;
	private Float kcal;
	private Float proteina;
	private Float lipidio;
	private Float carboidrato;
	private Float fibra;
	
	@ManyToOne
	@JoinColumn(name="grupo_alimento_id")
	private GrupoAlimento grupoAlimento;
	
	@ManyToOne
	@JoinColumn(name="lista_compra_id")
	private ListaCompra listaCompra;	
	
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public Float getKcal() {
		return kcal;
	}
	public Float getProteina() {
		return proteina;
	}
	public Float getLipidio() {
		return lipidio;
	}
	public Float getCarboidrato() {
		return carboidrato;
	}
	public Float getFibra() {
		return fibra;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setKcal(Float kcal) {
		this.kcal = kcal;
	}
	public void setProteina(Float proteina) {
		this.proteina = proteina;
	}
	public void setLipidio(Float lipidio) {
		this.lipidio = lipidio;
	}
	public void setCarboidrato(Float carboidrato) {
		this.carboidrato = carboidrato;
	}
	public void setFibra(Float fibra) {
		this.fibra = fibra;
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
		Alimento other = (Alimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Alimento [descricao=" + descricao + "]";
	}
}