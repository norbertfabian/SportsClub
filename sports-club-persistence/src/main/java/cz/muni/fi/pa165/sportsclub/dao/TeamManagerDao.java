package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import java.util.List;

/**
 * DAO interface prescribing operations for TeamManager entity.
 * 
 * @author Marian Sulgan
 */
public interface TeamManagerDao {
    
    /**
     * Creates new TeamManager.
     * 
     * @param tm team manager to be created.
     */
    public void create(TeamManager tm);

    /**
     * Updates existing TeamManager.
     * 
     * @param tm team manager to be updated
     * @return updated TeamManager
     */
    public TeamManager update(TeamManager tm);

    /**
     * Removes TeamManager.
     * 
     * @param tm team manager to be removed.
     */
    public void remove(TeamManager tm);

    /**
     * Finds TeamManager by provided ID.
     * 
     * @param id ID of TeamManager.
     * @return TeamManager with provided ID.
     */
    public TeamManager findById(Long id);
    
    /**
     * Finds all team managers
     * 
     * @return list of team managers
     */
    public List<TeamManager> findAll();

    /**
     * Finds team managers by name
     * 
     * @param name name of team manager
     * @return list of tam managers matching the given name
     */
    public List<TeamManager> findByName(String name);
    
}
