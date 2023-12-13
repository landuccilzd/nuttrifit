package br.com.landucci.nuttrifit.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="cardapio")
public class Cardapio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="atendimento_id")
	private Atendimento atendimento;
	
	@ManyToOne
	@JoinColumn(name="nutricionista_id")	
	private Pessoa nutricionista;
	
	@ManyToOne
	@JoinColumn(name="paciente_id")	
	private Pessoa paciente;
	
	@ManyToOne
	@JoinColumn(name="horario_id")
	private Horario horario;
	
	public Long getId() {
		return id;
	}
	public Atendimento getAtendimento() {
		return atendimento;
	}
	public Pessoa getNutricionista() {
		return nutricionista;
	}
	public Pessoa getPaciente() {
		return paciente;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	public void setNutricionista(Pessoa nutricionista) {
		this.nutricionista = nutricionista;
	}
	public void setPaciente(Pessoa paciente) {
		this.paciente = paciente;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Cardapio other = (Cardapio) obj;
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