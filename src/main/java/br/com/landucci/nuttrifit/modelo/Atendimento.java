package br.com.landucci.nuttrifit.modelo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import br.com.landucci.nuttrifit.util.NuttrifitHelper;
import jakarta.persistence.*;

@Entity
@Table(name="atendimento")
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String observacao;
	
	@Column(name="observacao_restrita")
	private String observacaoRestrita;
	private String cardapio;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private LocalDateTime data;

	@ManyToOne
	@JoinColumn(name="nutricionista_id")
	private Pessoa nutricionista;
	
	@ManyToOne
	@JoinColumn(name="paciente_id")	
	private Pessoa paciente;
	
	@ManyToOne
	@JoinColumn(name="medicao_id")
	private Medicao medicao;
	
	@OneToMany(mappedBy="atendimento")
	private List<Mensagem> comentarioList;
	
	@OneToMany(mappedBy="atendimento")
	private List<Mensagem> perguntaList;
	
	@OneToMany(mappedBy="atendimento")
	private List<Arquivo> arquivoList;	
	
	public Long getId() {
		return id;
	}
	public Pessoa getNutricionista() {
		return nutricionista;
	}
	public Pessoa getPaciente() {
		return paciente;
	}
	public Medicao getMedicao() {
		return medicao;
	}
	public String getObservacao() {
		return observacao;
	}
	public String getObservacaoRestrita() {
		return observacaoRestrita;
	}
	public String getCardapio() {
		return cardapio;
	}
	public LocalDateTime getData() {
		return data;
	}
	public String getDataDateFormat() {
		return NuttrifitHelper.getDateFormat().format(data);
	}
	public List<Mensagem> getComentarioList() {
		return comentarioList;
	}
	public List<Mensagem> getPerguntaList() {
		return perguntaList;
	}
	public List<Arquivo> getArquivoList() {
		return arquivoList;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setNutricionista(Pessoa nutricionista) {
		this.nutricionista = nutricionista;
	}
	public void setPaciente(Pessoa paciente) {
		this.paciente = paciente;
	}
	public void setMedicao(Medicao medicao) {
		this.medicao = medicao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public void setObservacaoRestrita(String observacaoRestrita) {
		this.observacaoRestrita = observacaoRestrita;
	}
	public void setCardapio(String cardapio) {
		this.cardapio = cardapio;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public void setComentarioList(List<Mensagem> comentarioList) {
		this.comentarioList = comentarioList;
	}
	public void setPerguntaList(List<Mensagem> perguntaList) {
		this.perguntaList = perguntaList;
	}
	public void setArquivoList(List<Arquivo> arquivoList) {
		this.arquivoList = arquivoList;
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
		Atendimento other = (Atendimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return paciente.getNome() + ": " + observacao;
	}
	
}