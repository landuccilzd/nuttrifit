package br.com.landucci.nuttrifit.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="questionario_grupo")
public class QuestionarioGrupo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="questionario_id")
	private Questionario questionario;
	
	@ManyToOne
	@JoinColumn(name="grupo_questao_id")
	private GrupoQuestao grupoQuestao;
	
	public Long getId() {
		return id;
	}
	public Questionario getQuestionario() {
		return questionario;
	}
	public GrupoQuestao getGrupoQuestao() {
		return grupoQuestao;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
	public void setGrupoQuestao(GrupoQuestao grupoQuestao) {
		this.grupoQuestao = grupoQuestao;
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
		QuestionarioGrupo other = (QuestionarioGrupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}