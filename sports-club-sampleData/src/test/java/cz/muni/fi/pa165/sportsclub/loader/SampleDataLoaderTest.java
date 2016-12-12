package cz.muni.fi.pa165.sportsclub.loader;

import cz.fi.muni.pa165.sportsclub.config.SampleDataConfiguration;
import cz.fi.muni.pa165.sportsclub.loader.SampleDataLoader;
import cz.muni.fi.pa165.sportsclub.entity.Membership;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.service.MembershipService;
import cz.muni.fi.pa165.sportsclub.service.PlayerService;
import cz.muni.fi.pa165.sportsclub.service.TeamManagerService;
import cz.muni.fi.pa165.sportsclub.service.TeamService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @author Fabian Norbert
 */

@ContextConfiguration(classes = SampleDataConfiguration.class)
public class SampleDataLoaderTest extends AbstractTransactionalTestNGSpringContextTests {

    @Inject
    private SampleDataLoader sampleDataLoader;

    @Inject
    private TeamService teamService;

    @Inject
    private PlayerService playerService;

    @Inject
    private TeamManagerService teamManagerService;

    @Inject
    private MembershipService membershipService;

    @Test
    public void testLoad() throws IOException, ParseException {
        List<Team> teams = teamService.getAll();
        List<Player> players = playerService.getAll();
        List<TeamManager> teamManagers = teamManagerService.getAll();
        List<Membership> memberships = membershipService.findAll();

        Assert.assertEquals(teams.size(), 2, "Wrong amount of teams.");
        Assert.assertEquals(players.size(), 4, "Wrong amount of players.");
        Assert.assertEquals(teamManagers.size(), 2, "Wrong amount of team managers.");
        Assert.assertEquals(memberships.size(), 4, "Wrong amount og memberships");

        Assert.assertEquals(teams.get(0).getMemberships().size(), 2);
    }
}
