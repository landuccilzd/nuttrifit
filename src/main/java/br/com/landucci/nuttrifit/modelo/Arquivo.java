package br.com.landucci.nuttrifit.modelo;

import br.com.landucci.nuttrifit.modelo.enums.TipoArquivo;
import jakarta.persistence.*;

@Entity
@Table(name="arquivo")
public class Arquivo { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String arquivo;
	private TipoArquivo tipo;

	@ManyToOne
	@JoinColumn(name="atendimento_id")
	private Atendimento atendimento;
	
	@ManyToOne
	@JoinColumn(name="mensagem_id")
	private Mensagem mensagem;
	
	@ManyToOne
	@JoinColumn(name="diario_id")
	private Diario diario;
	
	public Long getId() {
		return id;
	}
	public Atendimento getAtendimento() {
		return atendimento;
	}
	public Mensagem getMensagem() {
		return mensagem;
	}
	public Diario getDiario() {
		return diario;
	}
	public String getArquivo() {
		return arquivo;
	}
	public TipoArquivo getTipo() {
		return tipo;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
	public void setDiario(Diario diario) {
		this.diario = diario;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public void setTipo(TipoArquivo tipo) {
		this.tipo = tipo;
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
		Arquivo other = (Arquivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}