package br.ifpr.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ifpr.agenda.bootstrap.InicializarDados;
import br.ifpr.agenda.dominio.Usuario;
import br.ifpr.agenda.repositories.UsuarioRepository;

@SpringBootApplication
public class AgendaApplication {
	

	public static void main(String[] args) {
		
		SpringApplication.run(AgendaApplication.class, args);
	}

}
