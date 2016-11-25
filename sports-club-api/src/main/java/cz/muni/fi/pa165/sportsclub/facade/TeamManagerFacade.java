package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import java.util.List;

/**
 *
 * @author Marian Sulgan
 */
public interface TeamManagerFacade {
    
    /**
     * Creates a team manager
     * @param dto Team manager DTO with data
     */
    public void createTeamManager(TeamManagerDto dto);
    
    /**
     * Deletes team manager with given id
     * @param id ID of team manager to be deleted
     */
    public void deleteTeamManager(long id);
    
    /**
     * Update team manager
     * @param dto Team manager DTO with updated data
     */
    public void updateTeamManager(TeamManagerDto dto);
    
    /**
     * Returns team manager with given id
     * @param id ID of team manager
     * @return Team manager with give id
     */
    public TeamManagerDto getTeamManager(long id);
    
    /**
     * Return all team managers
     * @return List of all team managers
     */
    public List<TeamManagerDto> getAllTeamManagers();
}
