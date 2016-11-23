package cz.muni.fi.pa165.sportsclub;

import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.dao.TeamManagerDao;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;

/**
 * @author Fabian Norbert
 */
public class EntityFactoryService {

    public TeamCreateDto createTeamCreateDto() {
        TeamCreateDto teamCreateDto = new TeamCreateDto();
        teamCreateDto.setName("TestCreateTeam");
        teamCreateDto.setAgeGroupLabel(AgeGroup.JUNIOR.getLabel());
        teamCreateDto.setAgeGroupLabelsList(AgeGroup.getAllLabels());
        return teamCreateDto;
    }

    public TeamDto createTeamDto(){
        TeamDto team = new TeamDto();
        team.setId(1L);
        team.setName("TestTeamDto");
        team.setAgeGroupLabel(AgeGroup.JUNIOR.getLabel());
        team.setAgeGroupLabelsList(AgeGroup.getAllLabels());
        return team;
    }

    public Team createTeam() {
        return createTeam("TestTeam");
    }

    public Team createTeam(String name){
        Team team = new Team();
        team.setName(name);
        team.setAgeGroup(AgeGroup.JUNIOR);
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
    
    public TeamManager createTeamManager(String tmName) {
        TeamManager tm = new TeamManager();
//        tm.setId(1L);
        tm.setName(tmName);
        tm.setAddress("Test Address");
        tm.setContact("Test Contact");
        return tm;
    }
    
    public TeamManager createTeamManager() {
        return createTeamManager("John Doe");
    }
    
    public TeamManager createPersistedTeamManager(String tmName, TeamManagerDao dao) {
        TeamManager tm = createTeamManager(tmName);
        dao.create(tm);
        return tm;
    }
    
    public TeamManagerDto createTeamManagerDto() {
        TeamManagerDto tmDto = new TeamManagerDto();
        tmDto.setId(1L);
        tmDto.setAddress("TestAddress");
        tmDto.setContact("TestContact");
        tmDto.setName("Test TeamManager");
        return tmDto;
    }
    
    public TeamManagerCreateDto createTeamManagerCreateDto() {
        TeamManagerCreateDto tmDto = new TeamManagerCreateDto();
        tmDto.setAddress("TestAddress");
        tmDto.setContact("TestContact");
        tmDto.setName("Test TeamManagerCreate");
        return tmDto;
    }
}
