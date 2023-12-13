package br.com.landucci.nuttrifit.modelo;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="horario")
public class Horario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descricao;

	@OneToMany(mappedBy="horario")
	private List<Cardapio> cardapioList;

	public Long getId() {
		return id;
	}

	public List<Cardapio> getCardapioList() {
		return cardapioList;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCardapioList(List<Cardapio> cardapioList) {
		this.cardapioList = cardapioList;
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
		Horario other = (Horario) obj;
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