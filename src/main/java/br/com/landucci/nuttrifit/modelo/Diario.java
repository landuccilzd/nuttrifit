package br.com.landucci.nuttrifit.modelo;


import br.com.landucci.nuttrifit.modelo.enums.TipoArquivo;
import jakarta.persistence.*;

@Entity
@Table(name="diario")
public class Diario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private TipoArquivo tipo;
	private String anotacao;
	
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Pessoa paciente;
	
	public Long getId() {
		return id;
	}
	public Pessoa getPaciente() {
		return paciente;
	}
	public TipoArquivo getTipo() {
		return tipo;
	}
	public String getAnotacao() {
		return anotacao;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setPaciente(Pessoa paciente) {
		this.paciente = paciente;
	}
	public void setTipo(TipoArquivo tipo) {
		this.tipo = tipo;
	}
	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
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
		Diario other = (Diario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}