package br.ifpr.agenda.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String enderecoLinha1;
	private String enderecoLinha2;
	private String estado;
	private String municipio;
	
	@ManyToOne
	private Contato contato;

	@Override
	public String toString() {
		return "Endereco [enderecoLinha1=" + enderecoLinha1 + ", enderecoLinha2=" + enderecoLinha2 + ", estado="
				+ estado + ", municipio=" + municipio + "]";
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
