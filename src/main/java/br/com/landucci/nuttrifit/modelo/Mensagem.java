package br.com.landucci.nuttrifit.modelo;

import java.util.Date;

import br.com.landucci.nuttrifit.modelo.enums.TipoMensagem;
import br.com.landucci.nuttrifit.util.NuttrifitHelper;
import jakarta.persistence.*;

@Entity
@Table(name="mensagem")
public class Mensagem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String assunto;
	private String corpo;
	private TipoMensagem tipo;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="data_leitura")
	private Date dataLeitura;

	@ManyToOne
	@JoinColumn(name="remetente_id")
	private Pessoa remetente;

	@ManyToOne
	@JoinColumn(name="destinatario_id")	
	private Pessoa destinatario;

	@ManyToOne
	@JoinColumn(name="atendimento_id")
	private Atendimento atendimento;

	@ManyToOne
	@JoinColumn(name="arquivo_id")	
	private Arquivo arquivo;

	@ManyToOne
	@JoinColumn(name="mensagem_id")	
	private Mensagem mensagemPai;
	
	public Long getId() {
		return id;
	}
	public Pessoa getRemetente() {
		return remetente;
	}
	public Pessoa getDestinatario() {
		return destinatario;
	}
	public Atendimento getAtendimento() {
		return atendimento;
	}
	public Arquivo getArquivo() {
		return arquivo;
	}
	public Mensagem getMensagemPai() {
		return mensagemPai;
	}
	public String getAssunto() {
		return assunto;
	}
	public String getCorpo() {
		return corpo;
	}
	public TipoMensagem getTipo() {
		return tipo;
	}
	public Date getDataLeitura() {
		return dataLeitura;
	}
	public String getDataLeituraFormat() {
		return NuttrifitHelper.getDateFormat().format(dataLeitura);
	}	
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setRemetente(Pessoa remetente) {
		this.remetente = remetente;
	}
	public void setDestinatario(Pessoa destinatario) {
		this.destinatario = destinatario;
	}
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}
	public void setMensagemPai(Mensagem mensagemPai) {
		this.mensagemPai = mensagemPai;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	public void setTipo(TipoMensagem tipo) {
		this.tipo = tipo;
	}
	public void setDataLeitura(Date dataLeitura) {
		this.dataLeitura = dataLeitura;
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
		Mensagem other = (Mensagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return assunto;
	}
	
}