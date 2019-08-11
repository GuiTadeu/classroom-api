package br.com.caelum.remoteassignment;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Classe criada para realizar o Deploy em servidores
 * de aplicação utilizando o formato WAR.
 * @author Guilherme Tadeu
 * @version 1.0.0
 * @see Main
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Main.class);
	}
}
