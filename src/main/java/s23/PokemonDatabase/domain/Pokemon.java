package s23.PokemonDatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pokemon {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name, type, region;

	@ManyToOne
	@JoinColumn(name = "trainerid")
	private Trainer trainer;
	
	public Pokemon() {
		super();
	}

	public Pokemon(String name, String type, String region, Trainer trainer) {
		super();
		this.name = name;
		this.type = type;
		this.region = region;
		this.trainer = trainer;
	}

	public Pokemon(String name, String type, String region) {
		super();
		this.name = name;
		this.type = type;
		this.region = region;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", type=" + type + ", region=" + region + ", trainer=" + trainer
				+ "]";
	}
	
}