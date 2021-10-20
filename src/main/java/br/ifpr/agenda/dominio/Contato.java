package br.ifpr.agenda.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Contato implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToMany
	(
		cascade = CascadeType.ALL, 
		orphanRemoval = true,
		mappedBy = "contato"
	)
	@Size(min = 1, message = "Telefone obrigatório")
	private List<Telefone> telefones = new ArrayList<>();
	
	public Contato(final String nome) {
		this.nome = nome;
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

	public void addTelefone(Telefone telefone) {
		this.telefones.add(telefone);
		telefone.setContato(this);
	}
	
	public void removeTelefone(Telefone telefone) {
		this.telefones.remove(telefone);
		telefone.setContato(null);
	}
	
	public void removeTelefone(int index) {
		Telefone telefone = this.telefones.get(index);
		if (telefone != null) {
			this.telefones.remove(index);
			telefone.setContato(null);
		}
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + "]";
	}

	public void corrigirEnderecosTelefones() {
		limparEnderecosTelefonesVazios();
		
		for (Endereco endereco : this.enderecos) {
			endereco.setContato(this);
		}
		
		for (Telefone telefone : telefones) {
			telefone.setContato(this);
		}
	}

	private void limparEnderecosTelefonesVazios() {
		List<Endereco> enderecosVazios = enderecos.stream().filter(e -> e.isVazio()).collect(Collectors.toList());
		List<Telefone> telefonesVazios = telefones.stream().filter(t -> t.isVazio()).collect(Collectors.toList());
		
		for (Telefone telefone : telefonesVazios) {
			removeTelefone(telefone);
		}
		
		for (Endereco endereco : enderecosVazios) {
			removeEndereco(endereco);
		}
	}
}
