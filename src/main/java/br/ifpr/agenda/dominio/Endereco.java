package br.ifpr.agenda.dominio;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.util.StringUtils;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	private String estado;
	private String municipio;
	
	@ManyToOne
	@JoinColumn(name = "contato_id")
	private Contato contato;
	
	public Endereco() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Endereco [descricao=" + descricao + ", estado="
				+ estado + ", municipio=" + municipio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, estado, id, municipio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(estado, other.estado)
				&& Objects.equals(id, other.id) && Objects.equals(municipio, other.municipio);
	}

	public boolean isVazio() {
		return !StringUtils.hasText(descricao)
				&&
				!StringUtils.hasText(estado)
				&&
				!StringUtils.hasText(municipio);
	}
}
