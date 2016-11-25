package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import cz.muni.fi.pa165.sportsclub.service.PlayerService;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Patrik Novak
 */
@Service
@Transactional
public class PlayerFacadeImpl implements PlayerFacade{

    @Inject
    private DtoMapper dtoMapper;

    @Inject
    private PlayerService playerService;
    
    @Override
    public void createPlayer(PlayerDto dto) {
        playerService.createPlayer(dtoMapper.mapTo(dto, Player.class));
    }

    @Override
    public void deletePlayer(long id) {
        playerService.removePlayer(id);
    }

    @Override
    public void updatePlayer(PlayerDto dto) {
        playerService.updatePlayer(dtoMapper.mapTo(dto, Player.class));
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        List<Player> players = playerService.getAll();
        return dtoMapper.mapTo(players, PlayerDto.class);
    }

    @Override
    public PlayerDto getPlayer(long id) {
        return dtoMapper.mapTo(playerService.findById(id), PlayerDto.class);
    }
    
}
