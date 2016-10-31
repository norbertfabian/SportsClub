package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import java.util.List;

/**
 *
 * @author Marian Sulgan
 */
public interface TeamManagerDao {
    
    void create(TeamManager tm);

    TeamManager update(TeamManager tm);

    void remove(TeamManager tm);

    TeamManager findById(Long id);
    
    List<TeamManager> findAll();
    
}
