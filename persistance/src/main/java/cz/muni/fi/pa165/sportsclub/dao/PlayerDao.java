package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.Player;

/**
 * DAO interface prescribing operations for Player entity.
 * 
 * @author Patrik Novák
 */
public interface PlayerDao {
    
    /**
     * Creates new Player.
     * 
     * @param player to be created.
     */
    void create(Player player);
    
    /**
     * Updates existing Player.
     * 
     * @param player
     * @return updated Player
     */
    Player update(Player player);
    
    /**
     * Removes Player.
     * 
     * @param player to be removed.
     */
    void remove(Player player);
    
    /**
     * Finds Player by provided ID.
     * 
     * @param id ID of Player.
     * @return Player with provided ID.
     */
    Player findById(Long id);
}
