package br.ifpr.agenda.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpr.agenda.dominio.Usuario;
import br.ifpr.agenda.repositories.UsuarioRepository;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;

	@GetMapping("/usuarios/cadastrar")
	public String novoUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuarios/cadastrar";
	}
	
	@PostMapping("/usuarios/salvar")
	public String salvarUsuario(@Valid Usuario usuario, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) 
			return "usuarios/editar";
		
		repository.save(usuario);

		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Principal principal) {
		if (principal != null) {
			return "redirect:/contatos";
		}

		return "/login";
	}
}
