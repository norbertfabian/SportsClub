package cz.muni.fi.pa165.sportsclub;

import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.entity.Team;

/**
 * Created by jsmolar on 10/27/16.
 */
public class PersistenceEntityFactory {

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
}
