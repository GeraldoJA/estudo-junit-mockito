package test.trainee_codeplays.video4.team.service;

import org.springframework.stereotype.Service;

import test.trainee_codeplays.video4.team.model.Team;
import test.trainee_codeplays.video4.team.repository.TeamRepository;

@Service
public class TeamService {
	
	private TeamRepository teamRepository;
	
	public TeamService(TeamRepository teamRepository) { 
		this.teamRepository = teamRepository; 
	}
	
	public Team create( Team team ) {	
		return teamRepository.save(team);
	}
	
	public Team findById( Long id) throws Exception {
		return this.teamRepository
				.findById(id)
				.orElseThrow( () -> new Exception("Team not found") );
	}

}
