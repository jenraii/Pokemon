package s23.PokemonDatabase.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import s23.PokemonDatabase.domain.TrainerRepository;
import s23.PokemonDatabase.domain.Pokemon;
import s23.PokemonDatabase.domain.PokemonRepository;
import s23.PokemonDatabase.domain.Trainer;

@Controller
public class PokemonController {
	
	@Autowired
	private PokemonRepository repository; 

	@Autowired
	private TrainerRepository trepository; 
	
	// Show all pokemon
    @RequestMapping(value="/pokemonlist")
    public String pokemonList(Model model) {	
        model.addAttribute("pokemonit", repository.findAll());
        return "pokemonlist";
    }
  
	// RESTful service to get all pokemon
    @RequestMapping(value="/pokemonit", method = RequestMethod.GET)
    public @ResponseBody List<Pokemon> pokemonListRest() {	
        return (List<Pokemon>) repository.findAll();
    }    

	// RESTful service to get pokemon by id
    @RequestMapping(value="/pokemon/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Pokemon> findPokemonRest(@PathVariable("id") Long pokemonId) {	
    	return repository.findById(pokemonId);
    }       
    
    // Add new pokemon
    @RequestMapping(value = "/add")
    public String addPokemon(Model model){
    	model.addAttribute("pokemon", new Pokemon());
    	model.addAttribute("trainers", trepository.findAll());
        return "addpokemon";
    }     
    
    // Save new pokemon
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Pokemon pokemon){
        repository.save(pokemon);
        return "redirect:pokemonlist";
    }    

    // Delete pokemon
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePokemon(@PathVariable("id") Long pokemonId, Model model) {
    	repository.deleteById(pokemonId);
        return "redirect:../pokemonlist";
    }     
}