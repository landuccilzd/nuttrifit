package br.com.landucci.nuttrifit.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="alternativa")
public class Alternativa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="questao_id")
	private Questao questao;
	
	public Long getId() {
		return id;
	}
	public Questao getQuestao() {
		return questao;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setQuestao(Questao questao) {
		this.questao = questao;
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
		Alternativa other = (Alternativa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}