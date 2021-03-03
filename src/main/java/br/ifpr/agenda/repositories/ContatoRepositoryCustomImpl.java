package br.ifpr.agenda.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.annotations.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.ifpr.agenda.dominio.Contato;

public class ContatoRepositoryCustomImpl implements ContatoRepositoryCustom {
	
	@Autowired
	private EntityManager em;

	@Override
	@Transactional
	public Optional<Contato> findCompletoById(Long id) {
		List<Contato> contatos = em.createQuery("select distinct c from Contato c left join fetch c.enderecos e where c.id = :id", Contato.class)
									.setParameter("id", id)
									.setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
									.getResultList();
		
		if (contatos == null || contatos.isEmpty()) return Optional.empty();
		
		contatos = em.createQuery("select distinct c from Contato c left join fetch c.telefones t where c IN :contatos", Contato.class)
				.setParameter("contatos", contatos)
				.setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
				.getResultList();
		
		return Optional.of(contatos.get(0));
	}

}
