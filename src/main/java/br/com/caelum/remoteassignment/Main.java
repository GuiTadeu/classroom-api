package br.com.caelum.remoteassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe responsável por subir a aplicação
 * com servidor embutido.
 * @author Pivotal
 * @see ServletInitializer
 */
@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
