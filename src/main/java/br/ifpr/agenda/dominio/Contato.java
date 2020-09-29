package br.ifpr.agenda.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Nome obrigatório")
	private String nome;
	private String sobrenome;
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	@OneToMany
	(
		cascade = CascadeType.ALL, 
		orphanRemoval = true,
		mappedBy = "contato"
	)
	private List<Endereco> enderecos = new ArrayList<>();

	@Deprecated
	protected Contato() {}
	
	public Contato(final String nome) {
		this.nome = nome;
	}

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void addEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
		endereco.setContato(this);
	}
	
	public void removeEndereco(Endereco endereco) {
		this.enderecos.remove(endereco);
		endereco.setContato(null);
	}
	
	public void removeEndereco(int index) {
		Endereco endereco = this.enderecos.get(index);
		if (endereco != null) {
			this.enderecos.remove(index);
			endereco.setContato(null);
		}
	}
	
	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + "]";
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
		Contato other = (Contato) obj;
		return Objects.equals(id, other.id);
	}

	public void limparEnderecosVazios() {
		List<Endereco> vazios = this.enderecos
									.stream()
									.filter(e -> e.isVazio())
									.collect(Collectors.toList());
		for (Endereco endereco : vazios) {
			removeEndereco(endereco);
		}
	}

	public void corrigirEnderecos() {
		limparEnderecosVazios();
		for (Endereco endereco : this.enderecos) {
			endereco.setContato(this);
		}
	}
}
