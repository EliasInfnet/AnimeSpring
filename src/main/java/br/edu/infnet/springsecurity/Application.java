package br.edu.infnet.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import br.edu.infnet.springsecurity.model.Anime;
import br.edu.infnet.springsecurity.repository.AnimeRepository;

@EnableFeignClients
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	AnimeRepository animeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Anime anime = new Anime("Titulo", "dãsdaasd", 90, 90, "testeImg",
		// "rodrigo@oi.com");
		// animeRepository.save(anime);

	}
}
