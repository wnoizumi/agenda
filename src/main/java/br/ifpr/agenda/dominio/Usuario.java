package br.ifpr.agenda.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable =  false)
	private String nome;

	@Column(nullable =  false)
	private String email;
	
	@Column(nullable =  false)
	private String senha;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "usuario")
	private List<Contato> contatos;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		this.senha = encoder.encode(senha);
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public boolean checarCamposVazios() {
		if (this.nome.trim().length() == 0 ||
				this.email.trim().length() == 0 ||
				this.senha.trim().length() == 0) 	
				return true;	

		return false;
	}
}
