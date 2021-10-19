package br.ifpr.agenda.dominio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.util.StringUtils;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String enderecoLinha1;
	private String enderecoLinha2;
	private String estado;
	private String municipio;
	
	@ManyToOne
	private Contato contato;
	
	public Endereco() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnderecoLinha1() {
		return enderecoLinha1;
	}

	public void setEnderecoLinha1(String enderecoLinha1) {
		this.enderecoLinha1 = enderecoLinha1;
	}

	public String getEnderecoLinha2() {
		return enderecoLinha2;
	}

	public void setEnderecoLinha2(String enderecoLinha2) {
		this.enderecoLinha2 = enderecoLinha2;
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
		return "Endereco [enderecoLinha1=" + enderecoLinha1 + ", enderecoLinha2=" + enderecoLinha2 + ", estado="
				+ estado + ", municipio=" + municipio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(enderecoLinha1, enderecoLinha2, estado, id, municipio);
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
		return Objects.equals(enderecoLinha1, other.enderecoLinha1)
				&& Objects.equals(enderecoLinha2, other.enderecoLinha2) && Objects.equals(estado, other.estado)
				&& Objects.equals(id, other.id) && Objects.equals(municipio, other.municipio);
	}

	public boolean isVazio() {
		return !StringUtils.hasText(enderecoLinha1)
				&&
				!StringUtils.hasText(enderecoLinha2)
				&&
				!StringUtils.hasText(estado)
				&&
				!StringUtils.hasText(municipio);
	}
}
