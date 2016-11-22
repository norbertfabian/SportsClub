package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marian Sulgan
 */

@Service
public interface TeamManagerService {
    
    /**
     * Creates team manager
     * @param tm Team manager to be created
     */
    public void createTeamManager(TeamManager tm);
    
    /**
     * Removes team manager
     * @param id ID of team manager to be deleted
     */
    public void removeTeamManager(long id);
    
    /**
     * Updates team manager
     * @param tm Team manager to be updated
     * @return updated team manager
     */
    public TeamManager updateTeamManager(TeamManager tm);
    
    /**
     * Finds team manager by id
     * @param id Id of team manager
     * @return team manager with given id or null
     */
    public TeamManager findById(long id);
    
    /**
     * Finds team managers with given name
     * @param name name of team manger
     * @return list of team managers
     */
    public List<TeamManager> findByName(String name);
    
    /**
     * Retrieves all team managers
     * @return list of team managers
     */
    public List<TeamManager> findAll();
    
}
