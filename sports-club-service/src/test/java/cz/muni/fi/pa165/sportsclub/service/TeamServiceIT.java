package cz.muni.fi.pa165.sportsclub.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dao.MembershipDao;
import cz.muni.fi.pa165.sportsclub.dao.PlayerDao;
import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.dao.TeamManagerDao;
import cz.muni.fi.pa165.sportsclub.entity.Membership;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import cz.muni.fi.pa165.sportsclub.exception.SportsClubServiceException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Fabian Norbert
 */

@ContextConfiguration(classes = SpringContextConfiguration.class)
public class TeamServiceIT extends AbstractTransactionalTestNGSpringContextTests {

    @Inject
    private TeamService teamService;

    @Inject
    private TeamDao teamDao;

    @Inject
    private MembershipDao membershipDao;

    @Inject
    private TeamManagerDao teamManagerDao;

    @Inject
    private PlayerDao playerDao;

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

    @Test
    public void getTeamWithPlayers() {
        Player player = new Player().setFirstName("FirstName").setLastName("LastName").setHeight(150).setWeight(160)
                .setDateOfBirth(new Date());
        TeamManager teamManager = new TeamManager().setName("TeamManager").setAddress("Address").setContact("Contact");
        Team team = new Team().setName("Team").setAgeGroup(AgeGroup.JUNIOR).setTeamManager(teamManager);
        Membership membership = new Membership().setTeam(team).setPlayer(player).setJerseyNumber(1);
        team.addMembership(membership);
        player.addMembership(membership);

        teamManagerDao.create(teamManager);
        teamDao.create(team);
        playerDao.create(player);
        membershipDao.create(membership);

        Team result = teamService.findById(team.getId());
        Assert.assertEquals(1, result.getMemberships().size());
        result.getMemberships().stream().forEach(m ->
                Assert.assertEquals("FirstName", m.getPlayer().getFirstName()));
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

    @Test
    public void removeWithReference() {
        Team team = entityFactoryService.createPersistedTeam("TeamToRemove", teamDao);
        Player player = entityFactoryService.createPersistedPlayer(playerDao);
        Membership membership = new Membership().setPlayer(player).setTeam(team).setJerseyNumber(1);

        team.addMembership(membership);
        player.addMembership(membership);
        membershipDao.create(membership);
        long id = team.getId();
        long membershipId = membership.getId();

        teamService.removeTeam(id);

        Assert.assertEquals(teamDao.findById(id), null, "Team hasn't been removed.");
        Assert.assertEquals(membershipDao.findById(membershipId), null, "Membership hasn't been removed.");
        Assert.assertEquals(playerDao.findById(player.getId()), player, "Player has been removed,");
    }
}
