package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dao.PlayerDao;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Patrik Novak.
 */
@ContextConfiguration(classes = SpringContextConfiguration.class)
public class PlayerServiceIT extends AbstractTransactionalTestNGSpringContextTests {

    @Inject
    private PlayerService playerService;

    @Inject
    private PlayerDao playerDao;

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    @Test
    public void findByIdIT() {
        Player player = entityFactoryService.createPersistedPlayer(playerDao);
        Assert.assertNotNull(playerService.findById(player.getId()));
    }

    @Test
    void getAllIT() {
        Player player1 = entityFactoryService.createPersistedPlayer("Player1", playerDao);
        Player player2 = entityFactoryService.createPersistedPlayer("Player2", playerDao);

        List<Player> result = playerDao.getAll();

        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(player1));
        Assert.assertTrue(result.contains(player2));
    }

    @Test
    public void createPlayerIT() {
        Player player = entityFactoryService.createPlayer();
        playerService.createPlayer(player);
        Assert.assertTrue(player.getId() > 0);
        Assert.assertNotNull(playerDao.findById(player.getId()));
    }

    @Test
    public void updatePlayerIT() {
        Player player = entityFactoryService.createPersistedPlayer(playerDao);
        player.setFirstName("updatedName");
        Player result = playerService.updatePlayer(player);
        Assert.assertNotNull(result);
        Assert.assertEquals("updatedName", playerDao.findById(player.getId()).getFirstName());
    }

    @Test
    public void removePlayerIT() {
        Player playerToRemove = entityFactoryService.createPersistedPlayer(playerDao);
        long id = playerToRemove.getId();
        playerService.removePlayer(playerToRemove.getId());
        Assert.assertNull(playerDao.findById(id));
    }
}

