package br.ifpr.agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifpr.agenda.dominio.TipoTelefone;
import br.ifpr.agenda.repositories.TipoTelefoneRepository;

@RestController
@RequestMapping("/tipo-telefone")
public class TipoTelefoneController {
	@Autowired
	private TipoTelefoneRepository repository;

	@GetMapping
	public List<TipoTelefone> list() {
		return repository.findAll();
	}

	@PostMapping
	public void save(@RequestBody TipoTelefone tipoTelefone) {
		repository.save(tipoTelefone);
	}
	
	@PutMapping
	public void update(@RequestBody TipoTelefone tipoTelefone) {
		if (tipoTelefone.getId() > 0)
			repository.save(tipoTelefone);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
