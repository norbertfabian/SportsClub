package cz.muni.fi.pa165.sportsclub.facade;

import java.util.List;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import cz.muni.fi.pa165.sportsclub.service.PlayerService;
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
        playerService.createPlayer(player);
    }

    @Override
    public void deletePlayer(long id) {
        playerService.findById(id).getMemberships().stream().forEach(m -> m.getTeam().removeMemebership(m));
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
        return dtoMapper.mapTo(players, PlayerDto.class);
    }

    @Override
    public PlayerDto getPlayer(long id) {
        Player player = playerService.findById(id);
        return dtoMapper.playerToDto(player);
    }

}