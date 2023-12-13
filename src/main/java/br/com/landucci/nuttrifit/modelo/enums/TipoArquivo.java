package br.com.landucci.nuttrifit.modelo.enums;

public enum TipoArquivo {
	PDF(1, "PDF"), IMAGEM(2, "Imagem"), VIDEO(3, "Vídeo");

	private Integer id;
	private String descricao;
	
	TipoArquivo(final Integer id, final String descricao) {
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