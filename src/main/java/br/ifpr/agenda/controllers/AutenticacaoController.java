package br.ifpr.agenda.controllers;

import br.ifpr.agenda.dominio.Usuario;
import br.ifpr.agenda.dto.Login;
import br.ifpr.agenda.repositories.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class AutenticacaoController {

	private UsuarioRepository usuarioRepository;

	public AutenticacaoController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@RequestMapping("/login")
	public String getLogin() {
		return "autenticacao/login";
	}

	@PostMapping("/login")
	public String postLogin(@Valid Login login, BindingResult bindingResult, Model model) {
		if(usuarioRepository.findByEmailAddressAAndPassword(login.getEmail(), login.getSenha()) != 1) {
			return "autenticacao/login";
		}

		return "redirect:/contatos";
	}

	@RequestMapping("/cadastro-usuario")
	public String getCadastroUsuario() {
		return "autenticacao/cadastro";
	}

	@PostMapping("/usuario/salvar")
	public String postUsuario(@Valid Usuario usuario, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "autenticacao/cadastro";
		}
		usuarioRepository.save(usuario);

		return "redirect:/contatos";
	}
}
