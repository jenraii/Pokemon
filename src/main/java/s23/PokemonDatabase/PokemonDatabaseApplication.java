package s23.PokemonDatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.PokemonDatabase.domain.Trainer;
import s23.PokemonDatabase.domain.TrainerRepository;
import s23.PokemonDatabase.domain.AppUser;
import s23.PokemonDatabase.domain.AppUserRepository;
import s23.PokemonDatabase.domain.Pokemon;
import s23.PokemonDatabase.domain.PokemonRepository;

@SpringBootApplication
public class PokemonDatabaseApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PokemonDatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PokemonDatabaseApplication.class, args);
	}
	
/*	
	@Bean
	public CommandLineRunner pokemonDemo(PokemonRepository prepository, TrainerRepository trepository, AppUserRepository urepository) {
		return (args) -> {
			log.info("create a couple of users: user/user and admin/admin");
			AppUser user1 = new AppUser("Jenna", "Räihä", "user",
					"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("Janne", "Autio", "admin",
					"$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
			urepository.saveAll(Arrays.asList(user1, user2));
			
			log.info("save a couple of trainers");
			trepository.save(new Trainer("Jenrai", "Instinct"));
			trepository.save(new Trainer("Janau", "Mystique"));
			trepository.save(new Trainer("Nenoham", "Valor"));
			
			log.info("save a couple of pokemon");
			prepository.save(new Pokemon("Eevee", "Normal", "Kanto", trepository.findByName("Jenrai").get(0)));
			prepository.save(new Pokemon("Mudkip", "Water", "Hoenn", trepository.findByName("Janau").get(0)));
			prepository.save(new Pokemon("Cyndaquil", "Fire", "Johto", trepository.findByName("Nenoham").get(0)));
			
			log.info("fetch all pokemon");
			for (Pokemon pokemon : prepository.findAll()) {
				log.info(pokemon.toString());
			}

		};
	}
*/
}
