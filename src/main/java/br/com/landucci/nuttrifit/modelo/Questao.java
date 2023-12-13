package br.com.landucci.nuttrifit.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="questao")
public class Questao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="grupo_questao_id")
	private GrupoQuestao grupoQuestao;
	
	public Long getId() {
		return id;
	}
	public GrupoQuestao getGrupoQuestao() {
		return grupoQuestao;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setGrupoQuestao(GrupoQuestao grupoQuestao) {
		this.grupoQuestao = grupoQuestao;
	}
	
}