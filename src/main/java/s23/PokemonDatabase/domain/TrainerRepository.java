package s23.PokemonDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TrainerRepository extends CrudRepository<Trainer, Long>{
	
	List<Trainer> findByName(String name);
	
}