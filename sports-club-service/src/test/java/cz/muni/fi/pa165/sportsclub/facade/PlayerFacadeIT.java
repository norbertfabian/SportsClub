package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dao.PlayerDao;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.List;

/**
 * 
 */

@ContextConfiguration(classes = SpringContextConfiguration.class)
public class PlayerFacadeIT extends AbstractTransactionalTestNGSpringContextTests {

    @Inject
    private PlayerFacade playerFacade;

    @Inject
    private PlayerDao playerDao;

    @Inject
    private DtoMapper dtoMapper;

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    @Test
    public void getPlayerIT() {
        Player persistedPlayer = entityFactoryService.createPersistedPlayer(playerDao);

        PlayerDto result = playerFacade.getPlayer(persistedPlayer.getId());

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getId(), persistedPlayer.getId());
        Assert.assertEquals(result.getFirstName(), persistedPlayer.getFirstName());
    }

    @Test
    public void createPlayerIT() {
        PlayerDto playerDto = entityFactoryService.createPlayerDto();

        playerFacade.createPlayer(playerDto);

        List<Player> allPlayers = playerDao.getAll();
        Assert.assertTrue(allPlayers.size() == 1);
        Player player = allPlayers.get(0);
        Assert.assertNotNull(player.getId());
        Assert.assertEquals(playerDto.getFirstName(), player.getFirstName());

    }

    @Test
    public void deletePlayerIT() {
        Player playerToDelete = entityFactoryService.createPersistedPlayer(playerDao);

        playerFacade.deletePlayer(playerToDelete.getId());

        Assert.assertNull(playerDao.findById(playerToDelete.getId()));
    }

    @Test
    public void updatePlayerIT() {
        Player persistedPlayer = entityFactoryService.createPersistedPlayer(playerDao);
        PlayerDto updatedPlayerDto = dtoMapper.mapTo(persistedPlayer, PlayerDto.class);
        updatedPlayerDto.setFirstName("UpdatedName");

        playerFacade.updatePlayer(updatedPlayerDto);

        Player updateResult = playerDao.findById(persistedPlayer.getId());
        Assert.assertEquals(updateResult.getFirstName(), "UpdatedName");
    }

    @Test
    public void getAllPlayersIT() {
        entityFactoryService.createPersistedPlayer("Player1", playerDao);
        entityFactoryService.createPersistedPlayer("Player2", playerDao);

        List<PlayerDto> result = playerFacade.getAllPlayers();

        Assert.assertEquals(result.size(), 2);
        Assert.assertTrue(result.get(0) instanceof  PlayerDto);
        Assert.assertTrue(result.get(1) instanceof  PlayerDto);
        Assert.assertEquals(result.get(0).getFirstName(), "Player1");
        Assert.assertEquals(result.get(1).getFirstName(), "Player2");
    }
}
