package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Patrik Novak
 */

@Service
public interface PlayerService {

    /**
     * Finds player by specified id.
     *
     * @param id Id of the player
     * @return Return player with the given id
     */
    Player findById(long id);

    /**
     * Returns all players.
     *
     * @return List of all players
     */
    List<Player> getAll();

    /**
     * Method creates new player.
     *
     * @param player Player to create
     */
    void createPLayer(Player player);

    /**
     * Updates player.
     *
     * @param player Player with the updated data
     * @return Updated team
     */
    Player updatePlayer(Player player);

    /**
     * Removes player.
     * 
     * @param id Id of the player to remove
     */
    void removePlayer(long id);
}
