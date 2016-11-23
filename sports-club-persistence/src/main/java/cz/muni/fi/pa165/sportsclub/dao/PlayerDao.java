package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.Player;

import java.util.List;

/**
 * DAO interface prescribing operations for Player entity.
 * 
 * @author Patrik Novak
 */
public interface PlayerDao {
    
    /**
     * Persists Player.
     * 
     * @param player to be created.
     */
    void create(Player player);
    
    /**
     * Updates changes of a Player in the database.
     * 
     * @param player
     * @return updated Player
     */
    Player update(Player player);
    
    /**
     * Removes Player.
     * 
     * @param id of player to be removed.
     */
    void remove(Long id);
    
    /**
     * Finds Player by provided ID.
     * 
     * @param id ID of Player.
     * @return Player with provided ID.
     */
    Player findById(Long id);

    /**
     * Returns all Players from the database.
     *
     * @return List of Players.
     */
    List<Player> getAll();
}
