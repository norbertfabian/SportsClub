package cz.muni.fi.pa165.sportsclub.dao;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.EntityFactory;
import cz.muni.fi.pa165.sportsclub.PersistenceSampleApplicationContext;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by jsmolar on 24.10.16.
 */

@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class TeamRepositoryTest extends AbstractTestNGSpringContextTests {

    @Inject
    private TeamDao teamDao;

    private Team team1;
    private Team team2;

    private EntityFactory entityFactory = new EntityFactory();

    @BeforeMethod
    private void setUp(){
        team1 = entityFactory.createTeam("team1");
        team2 = entityFactory.createTeam("team2");
        teamDao.create(team1);
        teamDao.create(team2);
    }

    @Test
    public void testCreate(){
        assertEquals(teamDao.findById(team1.getId()), team1);
    }

    @Test
    public void testUpdate(){
        team1.setName("updatedTeam1");
        teamDao.update(team1);
        assertEquals(teamDao.findById(team1.getId()), team1);
    }

    @Test
    public void testRemove(){
        assertEquals(teamDao.findById(team1.getId()), team1);
        assertEquals(teamDao.findById(team2.getId()), team2);
        teamDao.remove(team1);
        assertNull(teamDao.findById(team1.getId()));
        assertEquals(teamDao.findById(team2.getId()), team2);
    }
}