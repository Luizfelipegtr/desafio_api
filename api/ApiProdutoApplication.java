package br.com.edusync.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ApiProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProdutoApplication.class, args);
	}

}
