package s23.PokemonDatabase.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import s23.PokemonDatabase.domain.Pokemon;
import s23.PokemonDatabase.domain.PokemonRepository;

@RestController
public class RestPokemonController {

private static final Logger log = LoggerFactory.getLogger(RestPokemonController.class);
	

	@Autowired
	PokemonRepository prepository;

	// return list of pokemon
	@GetMapping("/api/pokemon")
	public Iterable<Pokemon> getPokemon() { 
		log.info("//fetch and return pokemon");
		return prepository.findAll();
	}

	// add new pokemon
	@PostMapping("/api/pokemon")
	Pokemon addPokemon(@RequestBody Pokemon addPokemon) {
		log.info("save new pokemon " + addPokemon);
		return prepository.save(addPokemon);
	}

	// edit existing pokemon's information
	@PutMapping("/api/pokemon/{id}")
	Pokemon editPokemon(@RequestBody Pokemon editedPokemon, @PathVariable Long id) {
		log.info("edit pokemon " + editedPokemon);
		editedPokemon.setId(id);
		return prepository.save(editedPokemon);
	}
	
	// delete pokemon
	@DeleteMapping("/api/pokemon/{id}")
	public Iterable<Pokemon> deletePokemon(@PathVariable Long id) {
		log.info("delete pokemon, id = " + id);
		prepository.deleteById(id);
		return prepository.findAll();
	}

	// find one pokemon and return it
	@GetMapping("/api/pokemon/{id}")
	Optional<Pokemon> getPokemon(@PathVariable Long id) {
		log.info("find pokemon, id = " + id);
		return prepository.findById(id);
	}
}
