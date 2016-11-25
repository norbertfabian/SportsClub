package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dao.TeamManagerDao;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.exception.SportsClubServiceException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Marian Sulgan
 */

@ContextConfiguration(classes = SpringContextConfiguration.class)
public class TeamManagerServiceIT extends AbstractTransactionalTestNGSpringContextTests {
    
    @Inject
    private TeamManagerService tmService;

    @Inject
    private TeamManagerDao tmDao;

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    @Test
    public void createTeamManagerIT() {
        TeamManager tm = entityFactoryService.createPersistedTeamManager("TestManager", tmDao);
        Assert.assertNotNull(tmDao.findById(tm.getId()));
    }

    @Test
    public void updateTeamManagerIT() {
        TeamManager tm = entityFactoryService.createPersistedTeamManager("John Doe", tmDao);
        tm.setName("Update Doe");
        TeamManager res = tmService.updateTeamManager(tm);
        Assert.assertNotNull(res);
        Assert.assertEquals("Update Doe", tmDao.findById(tm.getId()).getName());
    }

    @Test
    public void removeTeamManagerIT() {
        TeamManager tmToRemove = entityFactoryService.createPersistedTeamManager("John Doe", tmDao);
        long id = tmToRemove.getId();
        tmService.removeTeamManager(tmToRemove.getId());
        Assert.assertNull(tmDao.findById(id));
    }
    
    @Test
    public void findByIdIT() {
        TeamManager tm = entityFactoryService.createPersistedTeamManager("TestManager", tmDao);
        Assert.assertNotNull(tmService.findById(tm.getId()));
    }

    @Test
    void getAllIT() {
        TeamManager tm1 = entityFactoryService.createPersistedTeamManager("TestManager1", tmDao);
        TeamManager tm2 = entityFactoryService.createPersistedTeamManager("TestManager2", tmDao);
        TeamManager tm3 = entityFactoryService.createPersistedTeamManager("TestManager3", tmDao);

        List<TeamManager> res = tmDao.getAll();

        Assert.assertNotNull(res);
        Assert.assertEquals(3, res.size());
        Assert.assertTrue(res.contains(tm1));
        Assert.assertTrue(res.contains(tm2));
        Assert.assertTrue(res.contains(tm3));
    }
    
    @Test(expectedExceptions = SportsClubServiceException.class)
    public void createTeamManagerWithSameIdTest() {
        TeamManager tm1 = entityFactoryService.createPersistedTeamManager("Test", tmDao);
        TeamManager tm2 = entityFactoryService.createPersistedTeamManager("Test2", tmDao);
        tm2.setId(tm1.getId());
        tmService.createTeamManager(tm2);
    }
    
    @Test(expectedExceptions = SportsClubServiceException.class)
    public void updateTeamManagerWithSameIdTest() {
        TeamManager tm1 = entityFactoryService.createPersistedTeamManager("Test", tmDao);
        TeamManager tm2 = entityFactoryService.createPersistedTeamManager("Test2", tmDao);
        tm2.setId(tm1.getId());
        tmService.updateTeamManager(tm2);
    }
    
}
