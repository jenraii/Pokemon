package s23.PokemonDatabase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;

@Entity
public class Trainer {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long trainerid;
    
	private String name;
	
	@Pattern(regexp = "Instinct|Valor|Mystique", message = "Team name must be either Instinct, Valor or Mystique", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String team;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer")
	@JsonIgnore
	private List<Pokemon> pokemon;
	
	public Trainer() {
		super();
	}
	
	public Trainer(String name, String team) {
		super();
		this.name = name;
		this.team = team;
	}
	
	public Trainer(String name, String team, List<Pokemon> pokemon) {
		super();
		this.name = name;
		this.team = team;
		this.pokemon = pokemon;
	}

	public Long getTrainerId() {
		return trainerid;
	}
	
	public void setTrainerId(Long trainerid) {
		this.trainerid = trainerid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public List<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public String toString() {
		return "Trainer [trainerid=" + trainerid + ", name=" + name + ", team=" + team + "]";
	}

}
