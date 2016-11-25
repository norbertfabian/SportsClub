package cz.muni.fi.pa165.sportsclub;

import java.util.Calendar;

import cz.muni.fi.pa165.sportsclub.dao.PlayerDao;
import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.dao.TeamManagerDao;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.entity.Membership;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;

/**
 * @author Fabian Norbert
 */
public class EntityFactoryService {

    public TeamDto createTeamDto() {
        TeamDto team = new TeamDto();
        team.setName("TestTeamDto");
        team.setAgeGroupLabel(AgeGroup.JUNIOR.getLabel());
        return team;
    }

    public Team createTeam() {
        return createTeam("TestTeam");
    }

    public Team createTeam(String name) {
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
        tm.setName(tmName);
        tm.setAddress("TestAddress");
        tm.setContact("TestContact");
        return tm;
    }

    public TeamManager createTeamManager() {
        return createTeamManager("TestManager");
    }

    public TeamManager createPersistedTeamManager(String tmName, TeamManagerDao dao) {
        TeamManager tm = createTeamManager(tmName);
        dao.create(tm);
        return tm;
    }

    public TeamManagerDto createTeamManagerDto() {
        TeamManagerDto tmDto = new TeamManagerDto();
        tmDto.setAddress("TestAddress");
        tmDto.setContact("TestContact");
        tmDto.setName("TestManager");
        return tmDto;
    }

    public PlayerDto createPlayerDto() {
        PlayerDto player = new PlayerDto();
        player.setFirstName("TestPlayerDto");
        player.setLastName("LastName");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 1, 1);
        player.setDateOfBirth(cal.getTime());
        return player;
    }

    public Player createPlayer() {
        return createPlayer("TestPlayer");
    }

    public Player createPlayer(String name) {
        Player player = new Player();
        player.setFirstName(name);
        player.setLastName("LastName");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 1, 1);
        player.setDateOfBirth(cal.getTime());
        return player;
    }

    public Player createPersistedPlayer(PlayerDao dao) {
        return createPersistedPlayer("TestPlayer", dao);
    }

    public Player createPersistedPlayer(String name, PlayerDao dao) {
        Player player = createPlayer(name);
        dao.create(player);
        return player;
    }

    public Membership createMembership(String name) {
        Membership membership = new Membership();
        Team team = createTeam("team" + name);
        Player player = createPlayer("player" + name);
        membership.setJerseyNumber(10);

        return membership;
    }
}
