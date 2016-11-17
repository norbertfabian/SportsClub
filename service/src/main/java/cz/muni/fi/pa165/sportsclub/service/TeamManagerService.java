package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.entity.Team;
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
     * @param tm Team manager to be removed
     */
    public void removeTeamManager(TeamManager tm);
    
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
    
    
    /* @todo: 
    consider using substring in findBySomething, not exact match, for
    practical purposes, mainly it is used in this way, so it should be handy...
    */
    
    
    /**
     * Finds team manager by team name
     * @param teamName Name of team
     * @return team manager
     */
    public TeamManager findByTeam(String teamName);
    
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
    
    /**
     * Lists all team of given team manager
     * @param tm Team manager to retrieve all teams for
     * @return list of teams
     */
    public List<Team> getAllTeams(TeamManager tm);
    
    /**
     * Adds a team
     * @param tm Team manager to add team to
     * @param t Team to be added to team manager
     */
    public void addNewTeam(TeamManager tm, Team t);
    
}
