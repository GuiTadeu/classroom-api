package br.com.caelum.remoteassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

/**
 * Controller criado para redirecionar a 
 * requisição ao root para o Swagger-UI.
 * @author Guilherme Tadeu
 * @version 1.0.0
 */

@Controller
@ApiIgnore
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/swagger-ui.html";
	}
}
