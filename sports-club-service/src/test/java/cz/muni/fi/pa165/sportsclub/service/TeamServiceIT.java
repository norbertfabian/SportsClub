package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.exception.SportsClubServiceException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Fabian Norbert
 */

@ContextConfiguration(classes = SpringContextConfiguration.class)
public class TeamServiceIT extends AbstractTransactionalTestNGSpringContextTests {

    @Inject
    private TeamService teamService;

    @Inject
    private TeamDao teamDao;

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    @Test
    public void findByIdIT() {
        Team team = entityFactoryService.createPersistedTeam(teamDao);
        Assert.assertNotNull(teamService.findById(team.getId()));
    }

    @Test
    void getAllIT() {
        Team team1 = entityFactoryService.createPersistedTeam("Team1", teamDao);
        Team team2 = entityFactoryService.createPersistedTeam("Team2", teamDao);

        List<Team> result = teamDao.getAll();

        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(team1));
        Assert.assertTrue(result.contains(team2));
    }

    @Test
    public void createTeamIT() {
        Team team = entityFactoryService.createTeam();
        teamService.createTeam(team);
        Assert.assertTrue(team.getId() > 0);
        Assert.assertNotNull(teamDao.findById(team.getId()));
    }

    @Test
    public void updateTeamIT() {
        Team team = entityFactoryService.createPersistedTeam(teamDao);
        team.setName("updatedName");
        Team result = teamService.updateTeam(team);
        Assert.assertNotNull(result);
        Assert.assertEquals("updatedName", teamDao.findById(team.getId()).getName());
    }

    @Test
    public void removeTeamIT() {
        Team teamToRemove = entityFactoryService.createPersistedTeam(teamDao);
        long id = teamToRemove.getId();
        teamService.removeTeam(teamToRemove.getId());
        Assert.assertNull(teamDao.findById(id));
    }

    @Test(expectedExceptions = SportsClubServiceException.class)
    public void addTeamWithExistingNameTest() {
        entityFactoryService.createPersistedTeam("TeamName", teamDao);

        teamService.createTeam(entityFactoryService.createTeam("TeamName"));
    }

    @Test(expectedExceptions = SportsClubServiceException.class)
    public void updateTeamWithExistingNameTest() {
        entityFactoryService.createPersistedTeam("ExistingTeamName", teamDao);
        Team teamToUpdate = entityFactoryService.createPersistedTeam("TeamName", teamDao);
        Team detachedTeam = new Team();
        detachedTeam.setId(teamToUpdate.getId());
        detachedTeam.setName("ExistingTeamName");

        teamService.updateTeam(detachedTeam);
    }
}
