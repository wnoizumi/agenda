package br.ifpr.agenda.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DBConfiguration {
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		System.out.println("Database connection for DEVELOPMENT");
		System.out.println("Driver: "+driverClassName);
		System.out.println("Url: "+url);

		return "Database connection for DEVELOPMENT"; 
	}

	@Profile("test")
	@Bean
	public String testDatabaseConnection() {
		System.out.println("Database connection for TEST");
		System.out.println("Driver: "+driverClassName);
		System.out.println("Url: "+url);

		return "Database connection for TEST"; 
	}

	@Profile("prod")
	@Bean
	public String prodDatabaseConnection() {
		System.out.println("Database connection for PRODUCTION");
		System.out.println("Driver: "+driverClassName);
		System.out.println("Url: "+url);

		return "Database connection for PRODUCTION"; 
	}
}
