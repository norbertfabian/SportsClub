package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.EntityFactory;
import cz.muni.fi.pa165.sportsclub.PersistenceSampleApplicationContext;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

/**
 * Created by norbert on 29.10.16.
 */

@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class PlayerRepositoryTest extends AbstractTestNGSpringContextTests {

    @Inject
    private PlayerDao playerDao;

    private EntityFactory entityFactory = new EntityFactory();

    @DataProvider
    public static Object[][] createPlayerDataProvider() {
        return new Object[][] {
                {190, 100},
                {null, 100},
                {190, null}
        };
    }

    @Test(dataProvider = "createPlayerDataProvider")
    public void createPlayerTest(Integer height, Integer weight) {
        Player player = entityFactory.createPlayer(height, weight);
        playerDao.create(player);

        Assert.assertNotNull(player.getId());

        Player persistedPlayer = playerDao.findById(player.getId());

        Assert.assertEquals("firstName", persistedPlayer.getFirstName());
        Assert.assertEquals("lastName", persistedPlayer.getLastName());
        Assert.assertEquals(player.getDateOfBirth(), persistedPlayer.getDateOfBirth());
        Assert.assertEquals(height != null ? height.intValue() : 0, persistedPlayer.getHeight());
        Assert.assertEquals(weight != null ? weight.intValue() : 0, persistedPlayer.getWeight());
    }

    @Test
    public void updatePlayerTest() {
        Player player = entityFactory.createPlayer(playerDao);
        player.setLastName("updatedLastName").setFirstName("updatedFirstName").setDateOfBirth(entityFactory.getDate())
                .setWeight(10).setHeight(10);

        playerDao.update(player);

        Player persistedPlayer = playerDao.findById(player.getId());
        Assert.assertEquals(player.getFirstName(), persistedPlayer.getFirstName());
        Assert.assertEquals(player.getLastName(), persistedPlayer.getLastName());
        Assert.assertEquals(player.getDateOfBirth(), persistedPlayer.getDateOfBirth());
        Assert.assertEquals(player.getHeight(), persistedPlayer.getHeight());
        Assert.assertEquals(player.getWeight(), persistedPlayer.getWeight());
    }

    @Test
    public void deletePlayerTest() {
        Player player = entityFactory.createPlayer(playerDao);
        playerDao.remove(player);
        Assert.assertTrue(playerDao.findAll().isEmpty());
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void testNullFirstName() {
        Player player = entityFactory.createPlayer();
        player.setFirstName(null);
        playerDao.create(player);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void testNullLastName() {
        Player player = entityFactory.createPlayer();
        player.setLastName(null);
        playerDao.create(player);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void testNullDateOfBirth() {
        Player player = entityFactory.createPlayer();
        player.setDateOfBirth(null);
        playerDao.create(player);
    }

}
