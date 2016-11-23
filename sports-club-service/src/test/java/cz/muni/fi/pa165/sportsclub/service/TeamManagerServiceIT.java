package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dao.TeamManagerDao;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
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
    public void findByIdIT() {
        TeamManager tm = entityFactoryService.createPersistedTeamManager("Test Name", tmDao);
        Assert.assertNotNull(tmService.findById(tm.getId()));
    }

    @Test
    void getAllIT() {
        TeamManager tm1 = entityFactoryService.createPersistedTeamManager("Test Name 1", tmDao);
        TeamManager tm2 = entityFactoryService.createPersistedTeamManager("Test Name 2", tmDao);
        TeamManager tm3 = entityFactoryService.createPersistedTeamManager("Test Name 3", tmDao);

        List<TeamManager> res = tmDao.getAll();

        Assert.assertNotNull(res);
        Assert.assertEquals(3, res.size());
        Assert.assertTrue(res.contains(tm1));
        Assert.assertTrue(res.contains(tm2));
        Assert.assertTrue(res.contains(tm3));
    }

    @Test
    public void createTeamManagerIT() {
        TeamManager tm = entityFactoryService.createTeamManager();
        tmService.createTeamManager(tm);
        Assert.assertTrue(tm.getId() > 0);
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
    
}
