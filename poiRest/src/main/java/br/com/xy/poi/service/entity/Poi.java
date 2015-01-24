package br.com.xy.poi.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Igor Emmanuel
 *
 *	Classe Model que mapeia a Tabela POI na base dados.
 */
@Entity
@Table(name = "POI")
public class Poi {

	@Id
    @SequenceGenerator(name = "poi_id_seq", sequenceName = "poi_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "poi_id_seq")
	private Long id;
	private String nome;
	private Integer coodx;
	private Integer coody;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCoodx() {
		return coodx;
	}

	public void setCoodx(Integer coodx) {
		this.coodx = coodx;
	}

	public Integer getCoody() {
		return coody;
	}

	public void setCoody(Integer coody) {
		this.coody = coody;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coodx == null) ? 0 : coodx.hashCode());
		result = prime * result + ((coody == null) ? 0 : coody.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Poi other = (Poi) obj;
		if (coodx == null) {
			if (other.coodx != null)
				return false;
		} else if (!coodx.equals(other.coodx))
			return false;
		if (coody == null) {
			if (other.coody != null)
				return false;
		} else if (!coody.equals(other.coody))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
