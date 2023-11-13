package s23.PokemonDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface PokemonRepository extends CrudRepository <Pokemon, Long> {
	
	 List<Pokemon> findByName(String name);
	 List<Pokemon> findByTrainerName(String string);
	 List<Pokemon> findByType (String string);
	 
}
