package br.com.landucci.nuttrifit.modelo;

public class AgendaJsonDatasource {
	
	private String id;
	private String title;
	private String url;
	private String classe;
	private String start;
	private String end;

	public AgendaJsonDatasource(Agenda agenda) {
		this.id = agenda.getId() + "";
		this.title = agenda.getPaciente().getNomeTela();
		this.url = "#";
		this.classe = "event-important";
		this.start = agenda.getDataHoraConsulta().getTime() + "";
		this.end = agenda.getDataHoraConsulta().getTime() + "";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}

	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
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
		AgendaJsonDatasource other = (AgendaJsonDatasource) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}