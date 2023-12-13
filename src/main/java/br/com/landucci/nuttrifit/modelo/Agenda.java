package br.com.landucci.nuttrifit.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="agenda")
public class Agenda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="data__hora_consulta")
	private Date dataHoraConsulta;
	
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Pessoa paciente;
	
	@ManyToOne
	@JoinColumn(name="nutricionista_id")
	private Pessoa nutricionista;
	
	public Long getId() {
		return id;
	}
	public Pessoa getPaciente() {
		return paciente;
	}
	public Pessoa getNutricionista() {
		return nutricionista;
	}
	public Date getDataHoraConsulta() {
		return dataHoraConsulta;
	}
	public String getDataHoraConsultaFormat() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataHoraConsulta);
	}	
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setPaciente(Pessoa paciente) {
		this.paciente = paciente;
	}
	public void setNutricionista(Pessoa nutricionista) {
		this.nutricionista = nutricionista;
	}
	public void setDataHoraConsulta(Date dataHoraConsulta) {
		this.dataHoraConsulta = dataHoraConsulta;
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
		Agenda other = (Agenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return getDataHoraConsultaFormat() + " - " + paciente.getNome();
	}
}