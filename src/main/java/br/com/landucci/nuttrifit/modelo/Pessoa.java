package br.com.landucci.nuttrifit.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.landucci.nuttrifit.util.NuttrifitHelper;
import jakarta.persistence.*;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String avatar;
	private String nome;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="data_nascimento")
	private Date dataNascimento;
	private String cpf;
	private String rg;
	private String sexo;	
	private String endereco;
	
	@Column(name="endereco_numero")
	private String enderecoNumero;
	
	@Column(name="endereco_complemento")
	private String enderecoComplemento;
	
	@Column(name="endereco_bairro")
	private String enderecoBairro;
	
	@Column(name="endereco_cidade")
	private String enderecoCidade;
	
	@Column(name="endereco_estado")
	private String enderecoEstado;
	
	@Column(name="endereco_cep")
	private String enderecoCep;
	
	@Column(name="estado_civil")
	private String estadoCivil;
	
	@Column(name="qtde_filhos")
	private Integer qtdeFilhos;
	private String telefone;
	private String celular;
	private String email;
	private String facebook;
	private String twitter;
	private String tipo;
	private Float altura;
	
	@Column(name="valor_pagamento")
	private Float valorPagamento;
	
	@Column(name="dia_pagamento")
	private Integer diaPagamento;
	
	@Column(name="data_exclusao")
	private Date dataExclusao;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="nutricionista_id")
	private Pessoa nutricionista;
	
	public Long getId() {
		return id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Pessoa getNutricionista() {
		return nutricionista;
	}
	public String getAvatar() {
		return avatar;
	}
	public String getNome() {
		return nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public String getDataNascimentoDateFormat() {
		return NuttrifitHelper.getDateFormat().format(dataNascimento);
	}	
	public String getCpf() {
		return cpf;
	}
	public String getRg() {
		return rg;
	}
	public String getSexo() {
		return sexo;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getEnderecoNumero() {
		return enderecoNumero;
	}
	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}
	public String getEnderecoBairro() {
		return enderecoBairro;
	}
	public String getEnderecoCidade() {
		return enderecoCidade;
	}
	public String getEnderecoEstado() {
		return enderecoEstado;
	}
	public String getEnderecoCep() {
		return enderecoCep;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public Integer getQtdeFilhos() {
		return qtdeFilhos;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getCelular() {
		return celular;
	}
	public String getEmail() {
		return email;
	}
	public String getFacebook() {
		return facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public String getTipo() {
		return tipo;
	}
	public Float getAltura() {
		return altura;
	}
	public Float getValorPagamento() {
		return valorPagamento;
	}
	public String getValorPagamentoFormat() {
		return NuttrifitHelper.getCurrencyFormat().format(valorPagamento);
	}	
	public Integer getDiaPagamento() {
		return diaPagamento;
	}
	public String getDataExclusaoFormat() {
		return new SimpleDateFormat("dd/MM/yyyy").format(dataExclusao);
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setNutricionista(Pessoa nutricionista) {
		this.nutricionista = nutricionista;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}
	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}
	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}
	public void setEnderecoCidade(String enderecoCidade) {
		this.enderecoCidade = enderecoCidade;
	}
	public void setEnderecoEstado(String enderecoEstado) {
		this.enderecoEstado = enderecoEstado;
	}
	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = enderecoCep;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public void setQtdeFilhos(Integer qtdeFilhos) {
		this.qtdeFilhos = qtdeFilhos;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setAltura(Float altura) {
		this.altura = altura;
	}
	public void setValorPagamento(Float valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public void setDiaPagamento(Integer diaPagamento) {
		this.diaPagamento = diaPagamento;
	}
	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}
	
	public String getNomeTela() {
		return this.nome.substring(0, this.nome.indexOf(' ')) + " " + this.nome.substring(this.nome.lastIndexOf(' ') + 1);
	}
	public int getIdade() {
		long difference = Math.abs(dataNascimento.getTime() - new Date().getTime());
		long days = difference / (1000 * 60 * 60 * 24);
		return (int) Math.floor(days / 365);
	}
	public String getFoto() {
		String nomeAvatarFake = (sexo == "M") ? "male-avatar.png" : "female-avatar.png";
		return avatar != null ? avatar : nomeAvatarFake;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
}