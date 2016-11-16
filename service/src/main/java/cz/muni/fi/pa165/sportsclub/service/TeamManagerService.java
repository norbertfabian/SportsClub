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
    void createTeamManager(TeamManager tm);
    
    /**
     * Removes team manager
     * @param tm Team manager to be removed
     */
    void removeTeamManager(TeamManager tm);
    
    /**
     * Updates team manager
     * @param tm Team manager to be updated
     * @return updated team manager
     */
    TeamManager updateTeamManager(TeamManager tm);
    
    /**
     * Finds team manager by id
     * @param id Id of team manager
     * @return team manager with given id or null
     */
    TeamManager findById(long id);
    
    /**
     * Finds team manager by team name
     * @param teamName Name of team
     * @return team manager
     */
    TeamManager findByTeam(String teamName);
    
    /**
     * Retrieves all team managers
     * @return list of team managers
     */
    List<TeamManager> findAll();
    
    
    //@todo: findByCriteria???
    
    /**
     * Lists all team of given team manager
     * @param tm Team manager to retrieve all teams for
     * @return list of teams
     */
    List<Team> getTeams(TeamManager tm);
    
    /**
     * Adds a team
     * @param tm Team manager to add team to
     * @param t Team to be added to team manager
     */
    void addTeam(TeamManager tm, Team t);
    
}
