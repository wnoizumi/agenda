//package br.ifpr.agenda.bootstrap;
//
//import java.time.LocalDate;
//import java.time.Month;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import br.ifpr.agenda.dominio.Contato;
//import br.ifpr.agenda.dominio.Endereco;
//import br.ifpr.agenda.dominio.Telefone;
//import br.ifpr.agenda.dominio.TipoTelefone;
//import br.ifpr.agenda.repositories.ContatoRepository;
//
//@Component
//public class InicializarDados implements CommandLineRunner {
//
//	@Autowired
//	private ContatoRepository contatoRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		Contato contato1 = new Contato("João");
//		contato1.setSobrenome("Silva");
//		contato1.setEmail("joao.silva@gmail.com");
//		contato1.setDataNascimento(LocalDate.of(1980, Month.OCTOBER, 1));
//
//		Endereco endereco1 = new Endereco();
//		endereco1.setEnderecoLinha1("Rua Brasil, 123. Cidade Alta");
//		endereco1.setMunicipio("Curitiba");
//		endereco1.setEstado("Paraná");
//		contato1.addEndereco(endereco1);
//
//		Telefone telefone1 = new Telefone();
//		telefone1.setNumero("(44) 2222-2222");
//		telefone1.setTipo(TipoTelefone.CASA);
//		contato1.addTelefone(telefone1);
//
//		contatoRepository.save(contato1);
//	}
//
//}
