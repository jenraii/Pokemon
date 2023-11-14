package s23.PokemonDatabase.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import s23.PokemonDatabase.domain.Pokemon;
import s23.PokemonDatabase.domain.PokemonRepository;

@Service
public interface PokemonService {
	    Iterable<Pokemon> listByKeyword(String keyword);
	}
      

