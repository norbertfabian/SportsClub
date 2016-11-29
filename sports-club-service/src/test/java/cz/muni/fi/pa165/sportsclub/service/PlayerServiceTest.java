package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.dao.PlayerDao;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.service.impl.PlayerServiceImpl;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrik Novak.
 */
public class PlayerServiceTest {

    @Mock
    private PlayerDao playerDao;

    @InjectMocks
    private PlayerService playerService = new PlayerServiceImpl();

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    @BeforeClass
    public void setUpClass() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByIdPlayerTest() {
        Mockito.when(playerDao.findById(Mockito.anyLong()))
                .thenReturn(entityFactoryService.createPlayer());

        Player result = playerService.findById(1L);

        Mockito.verify(playerDao, Mockito.times(1)).findById(Mockito.anyLong());
        Assert.assertNotNull(result);
    }

    @Test
    public void getAllTest() {
        List<Player> toReturn = new ArrayList<>();
        toReturn.add(entityFactoryService.createPlayer());
        Mockito.when(playerDao.getAll()).thenReturn(toReturn);

        List<Player> result = playerService.getAll();

        Mockito.verify(playerDao, Mockito.times(1)).getAll();
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void createPlayerTest() {
        playerService.createPlayer(entityFactoryService.createPlayer());

        Mockito.verify(playerDao, Mockito.times(1)).create(Mockito.any());
    }

    @Test
    public void updatePlayerTest() {
        Player player = entityFactoryService.createPlayer();
        Mockito.when(playerDao.update(Mockito.any())).thenReturn(player);

        Player result = playerService.updatePlayer(player);

        Mockito.verify(playerDao, Mockito.times(1)).update(Mockito.any());
        Assert.assertEquals(player, result);
    }

    @Test
    public void removePlayerTest() {
        Player player = entityFactoryService.createPlayer();

        playerService.removePlayer(player.getId());

        Mockito.verify(playerDao, Mockito.times(1)).remove(Mockito.anyLong());
    }
}
