package br.ifpr.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpr.agenda.dominio.TipoTelefone;

public interface TipoTelefoneRepository extends JpaRepository<TipoTelefone, Long> {

}
