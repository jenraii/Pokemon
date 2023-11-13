package s23.PokemonDatabase.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import s23.PokemonDatabase.domain.TrainerRepository;
import s23.PokemonDatabase.domain.Pokemon;
import s23.PokemonDatabase.domain.PokemonRepository;


@Controller
public class PokemonController {
	private static final Logger log = LoggerFactory.getLogger(PokemonController.class);
	
	private final PokemonRepository prepository; 

	private final TrainerRepository trepository; 
	
	public PokemonController(PokemonRepository prepository, TrainerRepository trepository) {
		this.prepository = prepository;
		this.trepository = trepository;
	}
	
	// Login page -> pokemonlist
		@RequestMapping(value = { "login" })
		public String login(Model model) {
			return "redirect:pokemonlist";
		}
	
	// Show all pokemon
    @GetMapping("/pokemonlist")
    public String pokemonList(Model model, String keyword) {
    	log.info("Read pokemon from database...");
        model.addAttribute("pokemon", prepository.findAll());
        return "pokemonlist";
    }  

	// Add new pokemon (admin)
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/addpokemon")
	public String addPokemon(Model model) {
		log.info("Let's create a new pokemon...");
		model.addAttribute("pokemon", new Pokemon());
		model.addAttribute("trainers", trepository.findAll());
		return "addpokemon";
	}
	
	//Edit pokemon (admin)
    @PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("editpokemon/{id}")
	public String editPokemon(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editpokemon", prepository.findById(id));
		model.addAttribute("trainers", trepository.findAll());
		return "editpokemon";
	}  
    
    // Save new pokemon (admin)
	@PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/savePokemon")
    public String savePokemon(@Valid @ModelAttribute("pokemon") Pokemon pokemon, BindingResult bindingResult, Model model){
    	log.info("CONTROLLER: Save pokemon and check the validation: " + pokemon);
    	if (bindingResult.hasErrors()) {
			log.info("validation error happened, trainers: " + trepository.findAll());
			model.addAttribute("trainers", trepository.findAll());
			return "addpokemon";
		}
    	prepository.save(pokemon);
        return "redirect:pokemonlist";
    }    

    // Delete pokemon (admin)
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/delete/{id}")
    public String deletePokemon(@PathVariable("id") Long id, Model model) {
    	log.info("delete pokemon");
    	prepository.deleteById(id);
        return "redirect:../pokemonlist";
    }   
    
}