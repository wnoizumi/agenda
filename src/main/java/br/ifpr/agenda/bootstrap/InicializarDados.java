package br.ifpr.agenda.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.ifpr.agenda.dominio.Usuario;
import br.ifpr.agenda.repositories.UsuarioRepository;

@Component
public class InicializarDados implements CommandLineRunner{
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		Usuario usuarioTeste = this.usuarioRepository.findByEmail("usertest@email.com");

		if (usuarioTeste == null) {
			Usuario usuario = new Usuario();
			usuario.setNome("Usuario Teste");
			usuario.setEmail("usertest@email.com");
			usuario.setSenha("123");

			this.usuarioRepository.save(usuario);
		}
	}
}
