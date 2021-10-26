package br.ifpr.agenda.controllers;

import br.ifpr.agenda.dominio.Role;
import br.ifpr.agenda.dominio.Usuario;
import br.ifpr.agenda.dto.Login;
import br.ifpr.agenda.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class AutenticacaoController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder encoder;

	public AutenticacaoController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@RequestMapping("/login")
	public String getLogin() {
		return "autenticacao/login";
	}

	@PostMapping("/login")
	public String postLogin(@Valid Login login, BindingResult bindingResult, Model model) {
		if(!usuarioRepository.findByUsername(login.getUsername()).isVazio()){
			return "autenticacao/login";
		}

		return "redirect:/";
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
		usuario.setRole(Role.USER.getNome());
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		usuarioRepository.save(usuario);

		return "redirect:/login";
	}
}
