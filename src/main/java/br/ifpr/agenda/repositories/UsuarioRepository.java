package br.ifpr.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpr.agenda.dominio.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
