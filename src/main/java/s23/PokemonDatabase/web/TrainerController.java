package s23.PokemonDatabase.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import s23.PokemonDatabase.domain.Trainer;
import s23.PokemonDatabase.domain.TrainerRepository;

@Controller
public class TrainerController {
	private static final Logger log = LoggerFactory.getLogger(TrainerController.class);
	
	private final TrainerRepository trepository;

	public TrainerController(TrainerRepository trepository) {
		this.trepository = trepository;
	}

	@GetMapping("/trainerlist")
	public String getTrainers(Model model) {
		log.info("show trainers");
		model.addAttribute("trainers", trepository.findAll());
		return "/trainerlist";
	}

	@GetMapping("/addtrainer")
	public String addTrainer(Model model) {
		model.addAttribute("newtrainer", new Trainer());
		return "/addtrainer";
	}

	@PostMapping("/saveTrainer")
	public String saveTrainer(@Valid @ModelAttribute("newtrainer") Trainer trainer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("error happened");
			return "/addtrainer";
		}
		trepository.save(trainer);
		return "redirect:/trainerlist";
	}

	@GetMapping("/deletetrainer/{id}")
	public String deleteTrainer(@PathVariable("id") Long trainerid, Model model) {
		System.out.println("delete trainer " + trainerid);
		if (trepository.findById(trainerid).get().getPokemon().isEmpty()) {
			trepository.deleteById(trainerid);
		} else {
			System.out.print("Can't remove a trainer that has pokemon.");
		}

		return "redirect:/trainerlist";
	}

	// Rest Trainer Controller
	@GetMapping("/trainers")
	public @ResponseBody List<Trainer> showRestTrainers() {
		log.info("showRestTrainers");
		return (List<Trainer>) trepository.findAll();

	}

	@GetMapping("/trainer/{id}")
	public @ResponseBody Optional<Trainer> findTrainerRest(@PathVariable("trainerid") Long trainerid) {
		return trepository.findById(trainerid);
	}
}
