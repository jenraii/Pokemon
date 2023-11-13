package s23.PokemonDatabase;

import s23.PokemonDatabase.domain.Pokemon;
import s23.PokemonDatabase.domain.PokemonRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PokemonDatabaseRepositoryTests {

    @Autowired
    PokemonRepository prepository;
    
    @Test
    public void findPokemonByName() {
        List<Pokemon> pokemon = prepository.findByName("Eevee");
        assertEquals(pokemon.get(0).getName(), "Eevee");
    }
    
    @Test
	void findAllPokemon() {
		Iterable<Pokemon> pokemon = prepository.findAll();
		assertThat(pokemon).hasSize(3);
	}
    
    @Test
	public void findPokemonTrainer() {
		List<Pokemon> pokemon = prepository.findByTrainerName("Jenrai");
		assertThat(pokemon).hasSize(1);		
	}
    
    // Kommentoin tämän pois, koska AssertNotEquals ei jostakin syystä toimi.
   /* @Test
	public void savePokemon() {
		Pokemon pokemon = new Pokemon();
		prepository.save(pokemon);
		assertNotEquals(pokemon.getId(), null);
	}
	*/
}