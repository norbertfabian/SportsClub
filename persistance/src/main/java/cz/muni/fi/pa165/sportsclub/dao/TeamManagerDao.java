package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.TeamManager;

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
    void create(TeamManager tm);

    /**
     * Updates existing TeamManager.
     * 
     * @param tm team manager to be updated
     * @return updated TeamManager
     */
    TeamManager update(TeamManager tm);

    /**
     * Removes TeamManager.
     * 
     * @param tm team manager to be removed.
     */
    void remove(TeamManager tm);

    /**
     * Finds TeamManager by provided ID.
     * 
     * @param id ID of TeamManager.
     * @return TeamManager with provided ID.
     */
    TeamManager findById(Long id);
    
}
