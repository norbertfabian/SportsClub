package cz.muni.fi.pa165.sportsclub;

import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.entity.Team;

/**
 * Created by norbert on 5.11.16.
 */
public class EntityFactoryService {

    public Team createTeam() {
        return createTeam("TestTeam");
    }

    public Team createTeam(String name){
        Team team = new Team();
        team.setName(name);
        return team;
    }

    public Team createPersistedTeam(TeamDao dao) {
        Team team = createTeam();
        dao.create(team);
        return team;
    }
}
