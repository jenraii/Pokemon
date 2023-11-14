package s23.PokemonDatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PokemonRepository extends CrudRepository <Pokemon, Long> {
	
	 @Query(value = "select * from pokemon p where p.name like %:keyword% or p.type like %:keyword% or p.region like %:keyword% "
	 		+ "or p.trainerid like %:keyword%", nativeQuery = true)
	 
	 List<Pokemon> findByKeyword(@Param("keyword") String keyword);
	 
	 List<Pokemon> findByName(String name);
	 
	 List<Pokemon> findByTrainerName(String string);
	 List<Pokemon> findByType (String string);
	 
}
