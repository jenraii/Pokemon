package s23.PokemonDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.PokemonDatabase.domain.Trainer;
import s23.PokemonDatabase.domain.TrainerRepository;
import s23.PokemonDatabase.domain.Pokemon;
import s23.PokemonDatabase.domain.PokemonRepository;

@SpringBootApplication
public class PokemonDatabaseApplication {
	private static final Logger log = LoggerFactory.getLogger(PokemonDatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PokemonDatabaseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner pokemonDemo(PokemonRepository prepository, TrainerRepository trepository) {
		return (args) -> {
			log.info("save a couple of pokemon");
			trepository.save(new Trainer("Castiel", "Instinct"));
			trepository.save(new Trainer("Sam", "Mystic"));
			trepository.save(new Trainer("Dean", "Valor"));
			
			prepository.save(new Pokemon("Eevee", "Normal", "Kanto", trepository.findByName("Castiel").get(0)));
			prepository.save(new Pokemon("Mudkip", "Water", "Hoenn", trepository.findByName("Dean").get(0)));
			prepository.save(new Pokemon("Cyndaquil", "Fire", "Johto", trepository.findByName("Sam").get(0)));
			
			log.info("fetch all students");
			for (Pokemon pokemon : prepository.findAll()) {
				log.info(pokemon.toString());
			}

		};
	}
}
