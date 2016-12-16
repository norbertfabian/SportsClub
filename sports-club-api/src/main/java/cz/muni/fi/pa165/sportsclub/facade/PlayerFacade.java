package cz.muni.fi.pa165.sportsclub.facade;

import java.util.List;

import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;

/**
 *
 * @author Patrik Novak
 */
public interface PlayerFacade {
    
    /**
     * Creates a new player.
     *
     * @param dto PlayerDto with the team data
     */
    void createPlayer(PlayerDto dto);

    /**
     * Deletes a player with the given id.
     *
     * @param id of the player to delete
     */
    void deletePlayer(long id);

    /**
     * Updates the player data.
     *
     * @param dto PlayerDto with the updated data
     */
    void updatePlayer(PlayerDto dto);

    /**
     * Returns a list of all players.
     *
     * @return List of all players
     */
    List<PlayerDto> getAllPlayers();

    /**
     * Returns a player with the specified id.
     *
     * @param id of the player
     * @return PlayerDto with the given id
     */
    PlayerDto getPlayer(long id);

    /**
     * Returns a list of all players.
     *
     * @return List of all free players
     */
    List<PlayerDto> getAllFreePlayers();
}
