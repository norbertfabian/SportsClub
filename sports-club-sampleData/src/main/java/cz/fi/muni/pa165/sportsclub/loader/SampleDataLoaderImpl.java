package cz.fi.muni.pa165.sportsclub.loader;

import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import cz.muni.fi.pa165.sportsclub.service.MembershipService;
import cz.muni.fi.pa165.sportsclub.service.PlayerService;
import cz.muni.fi.pa165.sportsclub.service.TeamManagerService;
import cz.muni.fi.pa165.sportsclub.service.TeamService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.io.IOException;

/**
 * @author Fabian Norbert
 */

@Component
@Transactional
public class SampleDataLoaderImpl implements SampleDataLoader {

    @Inject
    private TeamService teamService;

    @Inject
    private PlayerService playerService;

    @Inject
    private TeamManagerService teamManagerService;

    @Inject
    private MembershipService membershipService;

    @Override
    public void loadData() throws IOException {
        Team team = createTeam();
        TeamManager teamManager = createTeamManager();
        team.setTeamManager(teamManager);
        teamManager.addTeam(team);

        teamManagerService.createTeamManager(teamManager);
        teamService.createTeam(team);
    }

    private Team createTeam() {
        return new Team().setName("Team1").setAgeGroup(AgeGroup.JUNIOR);
    }

    private TeamManager createTeamManager() {
        return new TeamManager().setName("Chuck Norris").setAddress("World")
                .setContact("chuck.norris@norris.com");
    }
}
