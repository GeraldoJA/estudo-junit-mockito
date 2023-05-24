package test.trainee_codeplays.video4.player.model;

import javax.persistence.Entity;

import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.EnumType.STRING;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private String name;
	@Enumerated(STRING)
	private Position position;
	
	
	public Player(String name, Position position) {
		this.name = name;
		this.position = position;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public enum Position {
		ATTACKER,
		DEFENDER
	}

}
