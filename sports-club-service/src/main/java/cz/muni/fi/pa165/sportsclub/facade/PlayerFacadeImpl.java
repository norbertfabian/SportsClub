package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import cz.muni.fi.pa165.sportsclub.service.PlayerService;
import java.util.ArrayList;
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
        Player player = dtoMapper.dtoToPlayer(dto);
        playerService.createPLayer(player);
    }

    @Override
    public void deletePlayer(long id) {
        playerService.removePlayer(id);
    }

    @Override
    public void updatePlayer(PlayerDto dto) {
        Player player = dtoMapper.dtoToPlayer(dto);
        playerService.updatePlayer(player);
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        List<Player> players = playerService.getAll();
        List<PlayerDto> playerDtos = new ArrayList<>();
        for (Player player : players){
            playerDtos.add(dtoMapper.playerToDto(player, PlayerDto.class));
        }
        return playerDtos;
    }

    @Override
    public PlayerDto getPlayer(long id) {
        Player player = playerService.findById(id);
        return dtoMapper.playerToDto(player, PlayerDto.class);
    }
    
}
