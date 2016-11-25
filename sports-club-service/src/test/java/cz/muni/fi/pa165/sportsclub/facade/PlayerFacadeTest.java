package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import cz.muni.fi.pa165.sportsclub.service.PlayerService;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrik Novak.
 */

public class PlayerFacadeTest {

    @Mock
    private PlayerService playerService;

    @Mock
    private DtoMapper dtoMapper;

    @InjectMocks
    private PlayerFacade playerFacade = new PlayerFacadeImpl();

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    @BeforeClass
    public void setUpClass() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void setUpMethod() {
        Mockito.when(dtoMapper.mapTo(Mockito.any(), Player.class))
                .thenReturn(entityFactoryService.createPlayer());
    }


    @Test
    public void getPlayerTest() {
        Mockito.when(dtoMapper.mapTo(Mockito.any(Player.class), PlayerDto.class))
                .thenReturn(entityFactoryService.createPlayerDto());
        Mockito.when(playerService.findById(Mockito.anyLong()))
                .thenReturn(entityFactoryService.createPlayer());

        PlayerDto result = playerFacade.getPlayer(1L);

        Mockito.verify(playerService, Mockito.times(1)).findById(Mockito.anyLong());
        Assert.assertNotNull(result);
    }

    @Test
    public void getAllPlayersTest() {
        List<Player> players = new ArrayList<>();
        players.add(entityFactoryService.createPlayer("Player1"));
        players.add(entityFactoryService.createPlayer("Player2"));
        Mockito.when(playerService.getAll()).thenReturn(players);

        playerFacade.getAllPlayers();

        Mockito.verify(playerService, Mockito.times(1)).getAll();
    }

    @Test
    public void createPlayerTest() {
        playerFacade.createPlayer(entityFactoryService.createPlayerDto());

        Mockito.verify(playerService, Mockito.times(1)).createPlayer(Mockito.any(Player.class));
    }

    @Test
    public void deletePlayerTest() {
        playerFacade.deletePlayer(1);

        Mockito.verify(playerService, Mockito.times(1)).removePlayer(Mockito.anyLong());
    }

    @Test
    public void updatePlayerTest() {
        playerFacade.updatePlayer(entityFactoryService.createPlayerDto());

        Mockito.verify(playerService, Mockito.times(1)).updatePlayer(Mockito.any(Player.class));
    }

}
