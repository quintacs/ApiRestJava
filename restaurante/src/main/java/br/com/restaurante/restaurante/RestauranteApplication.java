package br.com.restaurante.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}

	@GetMapping("/ola")
	public String ola(@RequestParam(value = "nome",defaultValue = "mundo")String nome) {
		return String.format("ola %s!",nome);
	}
}
