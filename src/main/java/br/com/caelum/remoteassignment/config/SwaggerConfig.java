package br.com.caelum.remoteassignment.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe criada para geração da documentação do Swagger.
 * @author Guilherme Tadeu
 * @version 1.0.0
 * @
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	/**
	 * Método criado para especificar o pacote de controllers
	 * que será utilizado para geração da documentação.
	 * @see SwaggerConfig#apiInfo()
	 */
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("br.com.caelum.remoteassignment.controller"))              
          .paths(PathSelectors.any())  
          .build()
          .apiInfo(apiInfo());
    }
	
		/**
		 * Método criado para gerar o cabeçalho de informações
		 * da documentação.
		 * @see Contact
		 * @return ApiInfo
		 */
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "AluraDev", 
	      "Teste para vaga de Desenvolvedor Java", 
	      "1.0.0", 
	      null, 
	      new Contact("Guilherme Tadeu", "https://github.com/GuiTadeu", "guitadeu.py@gmail.com"), null, null, Collections.emptyList());
	}
}
