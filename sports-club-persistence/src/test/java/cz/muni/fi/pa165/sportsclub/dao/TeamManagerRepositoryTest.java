package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.EntityFactoryPersistence;
import cz.muni.fi.pa165.sportsclub.PersistenceSampleApplicationContext;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Patrik Novak
 */

@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class TeamManagerRepositoryTest extends AbstractTestNGSpringContextTests {
    
    @Inject
    private TeamManagerDao teamManagerDao;
    
    @Inject TeamDao teamDao;

    private TeamManager teamManager;
    
    private EntityFactoryPersistence entityFactoryPersistence = new EntityFactoryPersistence();

    @BeforeMethod
    private void setUp(){
        teamManager = entityFactoryPersistence.createTeamManager();
        teamManagerDao.create(teamManager);
    }
    
    @Test
    public void testCreate(){
        assertEquals(teamManagerDao.findById(teamManager.getId()), teamManager);
    }

    @Test
    public void testUpdate(){
        teamManager.setName("updatedName");
        teamManagerDao.update(teamManager);
        assertEquals(teamManagerDao.findById(teamManager.getId()), teamManager);
    }

    @Test
    public void testRemove(){
        assertEquals(teamManagerDao.findById(teamManager.getId()), teamManager);
        teamManagerDao.remove(teamManager.getId());
        assertNull(teamManagerDao.findById(teamManager.getId()));
    }
    
    @Test
    public void testFindAll() {
        teamManagerDao.create(entityFactoryPersistence.createTeamManager("anotherTeamManager"));
        assertEquals(teamManagerDao.getAll().size(), 2);
    }
    
    @Test
    public void testAddTeam() {
         Team team = entityFactoryPersistence.createPersistedTeam(teamDao);
         teamManager.addTeam(team);
         teamManagerDao.update(teamManager);
         assertEquals(teamManager.getTeams().size(), 1);
         assertEquals(teamManager.getTeams().contains(team), true);
    }
    
    @Test
    public void testRemoveTeamById() {
        Team t1 = entityFactoryPersistence.createPersistedTeam("team1", teamDao);
        Team t2 = entityFactoryPersistence.createPersistedTeam("team2", teamDao);
        Team t3 = entityFactoryPersistence.createPersistedTeam("team3", teamDao);
        
        teamManager.addTeam(t1);
        teamManager.addTeam(t2);
        teamManager.addTeam(t3);
        
        teamManagerDao.update(teamManager);
        
        teamManager.removeTeamById(t2.getId());
        
        assertEquals(teamManager.getTeams().size(), 2);
        assertEquals(teamManager.getTeams().contains(t1), true);
        assertEquals(teamManager.getTeams().contains(t3), true);
    }
    
    @Test(expectedExceptions = ConstraintViolationException.class)
    public void testNullName() {
        TeamManager tm = new TeamManager();
        tm.setName(null);
        teamManagerDao.create(tm);
    }
    
    @Test(expectedExceptions = ConstraintViolationException.class)
    public void testNullAddress() {
        TeamManager tm = new TeamManager();
        tm.setAddress(null);
        teamManagerDao.create(tm);
    }
    
    @Test(expectedExceptions = ConstraintViolationException.class)
    public void testNullContact() {
        TeamManager tm = new TeamManager();
        tm.setContact(null);
        teamManagerDao.create(tm);
    }
    
    @Test
    public void findByNameTest() {
        String name = "John Doe";
        teamManager.setName(name);
        teamManagerDao.update(teamManager);
        assertEquals(teamManagerDao.findByName(name).size(), 1);
        assertEquals(teamManagerDao.findByName(name).get(0).getName(), name);
    }
}
