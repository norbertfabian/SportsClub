package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.dto.ageGroup.AgeGroupDto;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;

import java.util.List;

/**
 * @author Fabian Norbert
 */
public interface TeamFacade {

    /**
     * Creates a new team.
     *
     * @param dto TeamDto with the team data
     * @return TeamDto of the created Team
     */
    TeamDto createTeam(TeamDto dto);

    /**
     * Deletes a team with the given id.
     *
     * @param id Id of the team to delete
     */
    void deleteTeam(long id);

    /**
     * Updates the team data.
     *
     * @param dto TeamDto with the updated data
     * @return Updated TeamDto
     */
    TeamDto updateTeam(TeamDto dto);

    /**
     * Returns a list of all teams.
     *
     * @return List of all teams
     */
    List<TeamDto> getAllTeams();

    /**
     * Returns a team with the specified id.
     *
     * @param id Id of the team
     * @return Team with the given id
     */
    TeamDto getTeam(long id);

    /**
     * Returns list of all AgeGroupDtos
     *
     * @return List of AgeGroupDto
     */
    List<AgeGroupDto> getAgeGroups();

    /**
     * Returns teams in which can player participate along to his age group
     *
     * @param player to be queried
     * @return Teams
     */
    List<TeamDto> getAllowedTeams(PlayerDto player);
}
