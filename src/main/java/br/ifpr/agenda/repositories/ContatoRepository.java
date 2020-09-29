package br.ifpr.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpr.agenda.dominio.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
