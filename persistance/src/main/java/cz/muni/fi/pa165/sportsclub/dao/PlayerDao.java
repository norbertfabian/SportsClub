package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.Player;

/**
 * Created by patrik on 26.10.16.
 */
public interface PlayerDao {
    
    void create(Player player);
    
    Player update(Player player);
    
    void remove(Player player);
    
    Player findById(Long id);
}
