package br.com.projetosalura.AppTabelaFipe.demo;

import br.com.projetosalura.AppTabelaFipe.demo.main.MainMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppTabelaFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppTabelaFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MainMenu.showMenu();
	}
}
