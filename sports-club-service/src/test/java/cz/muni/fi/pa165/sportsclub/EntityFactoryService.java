package cz.muni.fi.pa165.sportsclub;

import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.entity.Team;

/**
 * Created by norbert on 5.11.16.
 */
public class EntityFactoryService {

    public TeamCreateDto createTeamCreateDto() {
        TeamCreateDto teamCreateDto = new TeamCreateDto();
        teamCreateDto.setName("TestCreateTeam");
        return teamCreateDto;
    }

    public TeamDto createTeamDto(){
        TeamDto team = new TeamDto();
        team.setId(1L);
        team.setName("TestTeamDto");
        return team;
    }

    public Team createTeam() {
        return createTeam("TestTeam");
    }

    public Team createTeam(String name){
        Team team = new Team();
        team.setName(name);
        return team;
    }

    public Team createPersistedTeam(TeamDao dao) {
        return createPersistedTeam("TestTeam", dao);
    }

    public Team createPersistedTeam(String name, TeamDao dao) {
        Team team = createTeam(name);
        dao.create(team);
        return team;
    }
}
