package com.challenge.liter_alura;

import com.challenge.liter_alura.service.LivroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.challenge.liter_alura.principal.Principal;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	private final LivroService livroService;

    public LiterAluraApplication(LivroService livroService) {
        this.livroService = livroService;
    }

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(livroService);
		principal.menu();
	}
}
