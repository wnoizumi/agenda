package br.ifpr.agenda.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpr.agenda.dominio.Contato;
import br.ifpr.agenda.dominio.Endereco;
import br.ifpr.agenda.dominio.Telefone;
import br.ifpr.agenda.repositories.ContatoRepository;

@Controller
public class ContatoController {

	private ContatoRepository contatoRepository;
	
	public ContatoController(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}
	
	@RequestMapping("/")
	public String getContatos(Model model) {
		
		model.addAttribute("contatos", contatoRepository.findAll());
		
		return "contatos/index";
	}
	
	@GetMapping("/contatos/novo")
	public String novoContato(Model model) {
		model.addAttribute("contato", new Contato(""));
		model.addAttribute("fieldToFocus", "nome");
		return "contatos/editar";
	}
	
	@GetMapping("/contatos/alterar/{id}")
	public String alterContato(@PathVariable("id") long id, Model model) {
		Contato contato = contatoRepository.findCompletoById(id)
											.orElseThrow(() -> new IllegalArgumentException("Contato inválido"));
		
		model.addAttribute("contato", contato);
		model.addAttribute("fieldToFocus", "nome");
		return "contatos/editar";
	}
	
	@PostMapping("/contatos/excluir/{id}")
	public String excluirContato(@PathVariable("id") long id, Model model) {
		Contato contato = contatoRepository.findById(id)
											.orElseThrow(() -> new IllegalArgumentException("Contato inválido"));
		
		contatoRepository.delete(contato);
		
		return "redirect:/";
	}
	
	@PostMapping("/contatos/salvar")
	public String salvarContato(@Valid Contato contato, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "contatos/editar";
		}
		
		contato.corrigirEnderecosTelefones();
		
		contatoRepository.save(contato);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/contatos/salvar", params = {"addEndereco"})
	public String addEndereco(Contato contato, BindingResult bindingResult, Model model) {
		contato.addEndereco(new Endereco());
		String fieldId = "enderecos" + (contato.getEnderecos().size() - 1) + ".enderecoLinha1";
		model.addAttribute("fieldToFocus", fieldId);
		return "contatos/editar";
	}
	
	@RequestMapping(value="/contatos/salvar", params = {"removeEndereco"})
	public String removeEndereco(Contato contato, BindingResult bindingResult, HttpServletRequest req) {
		final Integer enderecoIndex = Integer.valueOf(req.getParameter("removeEndereco"));
		
		contato.removeEndereco(enderecoIndex.intValue());
		return "contatos/editar";
	}
	
	@RequestMapping(value="/contatos/salvar", params = {"addTelefone"})
	public String addTelefone(Contato contato, BindingResult bindingResult, Model model) {
		contato.addTelefone(new Telefone());
		
		String fieldId = "telefones" + (contato.getTelefones().size() - 1) + ".numero";
		model.addAttribute("fieldToFocus", fieldId);
		
		return "contatos/editar";
	}
	
	@RequestMapping(value="/contatos/salvar", params = {"removeTelefone"})
	public String removeTelefone(Contato contato, BindingResult bindingResult, HttpServletRequest req) {
		final Integer telefoneIndex = Integer.valueOf(req.getParameter("removeTelefone"));
		
		contato.removeTelefone(telefoneIndex.intValue());
		return "contatos/editar";
	}
}
