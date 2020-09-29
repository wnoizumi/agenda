package br.ifpr.agenda.dominio;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {

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
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

	public boolean isVazio() {
		return vazioOuNulo(enderecoLinha1)
				&&
				vazioOuNulo(enderecoLinha2)
				&&
				vazioOuNulo(estado)
				&&
				vazioOuNulo(municipio);
	}
	
	private static boolean vazioOuNulo(String campo) {
		return campo == null || campo.isBlank();
	}
	
}
