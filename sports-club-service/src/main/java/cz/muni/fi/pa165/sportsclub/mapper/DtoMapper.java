package cz.muni.fi.pa165.sportsclub.mapper;

import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;

/**
 * @author Fabian Norbert
 */
public interface DtoMapper {

    /**
     * Maps a team entity to a dto of given type.
     *
     * @param team Team entity
     * @param mapToClass Dto type
     * @param <T> Implementation of TeamCreateDto
     * @return Mapped dto of the given type
     */
    <T extends TeamCreateDto> T teamToDto(Team team, Class<T> mapToClass);

    /**
     * Maps a teamDto to an entity.
     *
     * @param dto Dto to map
     * @return Mapped team entity
     */
    Team dtoToTeam(TeamCreateDto dto);

    /**
     * Maps a team manager DTO to a an entity
     * @param dto DTO to map
     * @return Mapped team manager entity
     */
    public TeamManager dtoToTeamManager(TeamManagerCreateDto dto);

    /**
     * Maps a team manager entity to a dto of type TeamManagerDto
     * @param tm Team manager entity 
     * @param mapToClass Dto type - Team Manager Dto
     * @return Mapped dto
     */
    public TeamManagerDto teamManagerToDto(TeamManager tm, Class<TeamManagerDto> mapToClass);
}
