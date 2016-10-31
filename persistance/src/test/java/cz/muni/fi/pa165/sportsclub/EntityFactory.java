package cz.muni.fi.pa165.sportsclub;

import java.util.Calendar;
import java.util.Date;

import cz.muni.fi.pa165.sportsclub.dao.PlayerDao;
import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.dao.MembershipDao;
import cz.muni.fi.pa165.sportsclub.dao.TeamManagerDao;

import cz.muni.fi.pa165.sportsclub.entity.Membership;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;


/**
 * @author Jakub Smolar
 */
public class EntityFactory {

    public Team createTeam(String name) {
        Team team = new Team();
        team.setName(name);
        return team;
    }

    public Team createTeam() {
        return createTeam("team");
    }

    public Team createTeam(TeamDao dao) {
        Team team = createTeam();
        dao.create(team);
        return team;
    }

    public Player createPlayer(String firstName, Integer height, Integer weight) {
        Player player = new Player();
        player.setFirstName(firstName);
        player.setLastName("lastName");
        player.setDateOfBirth(getDate());
        if (height != null)
            player.setHeight(height);
        if (weight != null)
            player.setWeight(weight);
        return player;
    }

    public Player createPlayer(Integer height, Integer weight) {
        return createPlayer("firstName", height, weight);
    }

    public Player createPlayer() {
        return createPlayer(190, 100);
    }
    
    public Player createPlayer(String fname, String lname) {
        Player player = createPlayer();
        player.setFirstName(fname);
        player.setLastName(lname);
        return player;
    }

    public Player createPersistedPlayer(String firstName, PlayerDao dao) {
        Player player = createPlayer(firstName, 190, 100);
        dao.create(player);
        return player;
    }

    public Player createPersistedPlayer(PlayerDao dao) {
        return createPersistedPlayer("firstName", dao);
    }

    public Date getDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(1991, 1, 1);
        return cal.getTime();
    }
    
    public TeamManager createTeamManager(String name) {
        TeamManager tm = new TeamManager();
        tm.setName(name);
        tm.setAddress("address");
        tm.setContact("contact");
        return tm;
    }
    
    public TeamManager createTeamManager() {
        return createTeamManager("teamManager");
    }
    
    public TeamManager createTeamManager(TeamManagerDao managerDao) {
        TeamManager tm = new TeamManager();
        managerDao.create(tm);
        return tm;
    }
    
        public Membership createMembership(Player p, Team t) {
        Membership m = new Membership();
        m.setPlayer(p);
        m.setTeam(t);
        m.setJerseyNumber((int) ((Math.random() * 100) % 99));
        return m;
    }
    
    public Membership createMembership(Player p, Team t, MembershipDao dao) {
        Membership m = createMembership(p, t);
        dao.create(m);
        return m;
    }
}