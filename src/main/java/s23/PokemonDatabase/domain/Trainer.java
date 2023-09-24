package s23.PokemonDatabase.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long trainerid;
	private String name, team;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer")
	private List<Pokemon> pokemonit;
	
	public Trainer() {}
	
	public Trainer(String name) {
		super();
		this.name = name;
	}

	public Trainer(String name, String team) {
		super();
		this.name = name;
		this.team = team;
	}
	
	public Long getTrainerid() {
		return trainerid;
	}
	
	public void setTrainerid(Long trainerid) {
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
		return pokemonit;
	}

	public void setPokemon(List<Pokemon> pokemonit) {
		this.pokemonit = pokemonit;
	}

	@Override
	public String toString() {
		return "Trainer [trainerid=" + trainerid + ", name=" + name + ", team=" + team + "]";
	}

}
