package test.trainee_codeplays.video4.team.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import test.trainee_codeplays.video4.team.model.Team;
import test.trainee_codeplays.video4.team.service.TeamService;

@RestController
public class TeamController {

	private TeamService teamService;
	
	public TeamController( TeamService teamService ) {
		this.teamService = teamService;
	}
	
	@PostMapping("teams")
	public ResponseEntity<Void> create( @RequestBody Team team ) {
		
		Team createdTeam = teamService.create(team);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdTeam.getId())
				.toUri();
				
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("teams/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Team findById(@PathVariable Long id) throws Exception {
		return teamService.findById(id);
	}
	
}
