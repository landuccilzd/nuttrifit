package br.com.landucci.nuttrifit.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="medicao")
public class Medicao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="atendimento_id")
	private Atendimento atendimento;
	
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Pessoa paciente;
	
	@ManyToOne
	@JoinColumn(name="perfil_medicao_id")
	private PerfilMedicao perfilMedicao;
	
	@OneToMany(mappedBy="medicao")
	private List<Leitura> leituraList;
	
	public Long getId() {
		return id;
	}
	public Atendimento getAtendimento() {
		return atendimento;
	}
	public Pessoa getPaciente() {
		return paciente;
	}
	public PerfilMedicao getPerfilMedicao() {
		return perfilMedicao;
	}
	public List<Leitura> getLeituraList() {
		return leituraList;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	public void setPaciente(Pessoa paciente) {
		this.paciente = paciente;
	}
	public void setPerfilMedicao(PerfilMedicao perfilMedicao) {
		this.perfilMedicao = perfilMedicao;
	}
	public void setLeituraList(List<Leitura> leituraList) {
		this.leituraList = leituraList;
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
		Medicao other = (Medicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}