package br.ifpr.agenda.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.ifpr.agenda.dominio.Usuario;
import br.ifpr.agenda.repositories.UsuarioRepository;

@Component
public class InicializarDados implements CommandLineRunner{
    @Autowired
	private UsuarioRepository repository;

    // @Autowired
    // private PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        
        // Usuario usuario = new Usuario();
		// usuario.setNome("maria");
		// usuario.setEmail("maria@email.com");
		// usuario.setSenha("123456");

        // repository.save(usuario);
        
    }
}
