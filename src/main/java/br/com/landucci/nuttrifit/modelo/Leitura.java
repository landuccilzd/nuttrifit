package br.com.landucci.nuttrifit.modelo;

import br.com.landucci.nuttrifit.util.NuttrifitHelper;
import jakarta.persistence.*;

@Entity
@Table(name="leitura")
public class Leitura {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Float valor;
	
	@ManyToOne
	@JoinColumn(name="medicao_id")
	private Medicao medicao;
	
	@ManyToOne
	@JoinColumn(name="item_medicao_id")
	private ItemMedicao itemMedicao;

	public Long getId() {
		return id;
	}
	public Medicao getMedicao() {
		return medicao;
	}
	public ItemMedicao getItemMedicao() {
		return itemMedicao;
	}
	public Float getValor() {
		return valor;
	}
	public String getValorFormat() {
		return NuttrifitHelper.getNumberFormat().format(valor);
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setMedicao(Medicao medicao) {
		this.medicao = medicao;
	}
	public void setItemMedicao(ItemMedicao itemMedicao) {
		this.itemMedicao = itemMedicao;
	}
	public void setValor(Float valor) {
		this.valor = valor;
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
		Leitura other = (Leitura) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return itemMedicao.getDescricao() +  ": " + getValorFormat();
	}
	
}