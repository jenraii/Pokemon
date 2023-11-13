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

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PokemonDatabaseRepositoryTests {

    @Autowired
    PokemonRepository repository;
    
    @Test
    public void testFindPokemonByName() {
        List<Pokemon> pokemon = repository.findByName("Eevee");
        assertEquals(pokemon.get(0).getName(), "Eevee");
    }
}