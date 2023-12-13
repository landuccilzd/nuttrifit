package br.com.landucci.nuttrifit.modelo.enums;

public enum TipoMensagem {
	COMENTARIO(1, "Comentario"), PERGUNTA(2, "Pergunta"), MENSAGEM(3, "Mensagem");

	private Integer id;
	private String descricao;
	
	TipoMensagem(final Integer id, final String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return getDescricao();
	}
}