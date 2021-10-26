package br.ifpr.agenda.repositories;

import br.ifpr.agenda.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//    @Query(value = "SELECT case when (count(*) > 0)  then true else false end FROM USUARIO WHERE EMAIL = ?1 AND PASSWORD = ?2", nativeQuery = true)
//    Integer findByEmailAddressAAndPassword(String email, String password);


    Usuario findByUseremail(String email);
}
