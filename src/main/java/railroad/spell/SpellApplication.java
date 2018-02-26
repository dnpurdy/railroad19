package railroad.spell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpellApplication {

	@Autowired
	private DictionaryService dictionaryService;

	public static void main(String[] args) {
		SpringApplication.run(SpellApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			for (String testWord : args) {
				if (dictionaryService.isInWordList(testWord)) {
					System.out.println(testWord + " spelled right.");
				} else {
					System.out.println(testWord + " spelled wrong!");
				}
			}
		};
	}
}
