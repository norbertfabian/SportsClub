package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.EntityFactoryPersistence;
import cz.muni.fi.pa165.sportsclub.PersistenceSampleApplicationContext;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * @author Jakub Smolar
 */

@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class TeamRepositoryTest extends AbstractTestNGSpringContextTests {

    @Inject
    private TeamDao teamDao;

    private Team team1;
    private Team team2;

    private EntityFactoryPersistence entityFactoryPersistence = new EntityFactoryPersistence();

    @BeforeMethod
    private void setUp(){
        team1 = entityFactoryPersistence.createTeam("team1");
        team2 = entityFactoryPersistence.createTeam("team2");
        teamDao.create(team1);
        teamDao.create(team2);
    }

    @Test
    public void shouldCreateTeam(){
        assertEquals(teamDao.findById(team1.getId()), team1);
    }

    @Test
    public void shouldUpdateTeam(){
        team1.setName("updatedTeam1");
        teamDao.update(team1);
        assertEquals(teamDao.findById(team1.getId()), team1);
    }

    @Test
    public void shouldRemoveTeam(){
        assertEquals(teamDao.findById(team1.getId()), team1);
        assertEquals(teamDao.findById(team2.getId()), team2);
        teamDao.remove(team1.getId());
        assertNull(teamDao.findById(team1.getId()));
        assertEquals(teamDao.findById(team2.getId()), team2);
    }

    @Test
    public void shouldReturnAllTeams(){
        List<Team> result = teamDao.getAll();
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(team1));
        Assert.assertTrue(result.contains(team2));
    }

    @Test
    public void shouldReturnTeamByName() {
        Team team = entityFactoryPersistence.createTeam("TeamName");
        teamDao.create(team);

        Team result = teamDao.getByName("TeamName");

        Assert.assertNotNull(result);
        Assert.assertEquals(result, team);
    }

    @Test
    public void shouldReturnTeamsByAgeGroup() {
        Team team = entityFactoryPersistence.createTeam("TeamName");
        team.setAgeGroup(AgeGroup.JUNIOR);
        teamDao.create(team);

        List<Team> result = teamDao.getByAgeGroup(team.getAgeGroup());

        Assert.assertNotNull(result);
        Assert.assertTrue(result.contains(team));
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void shouldNotCreateTeamWithNullName() {
        Team team = entityFactoryPersistence.createTeam();
        team.setName(null);
        teamDao.create(team);
    }
}