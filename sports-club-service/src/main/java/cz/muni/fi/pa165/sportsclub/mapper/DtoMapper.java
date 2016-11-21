package cz.muni.fi.pa165.sportsclub.mapper;

import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
import cz.muni.fi.pa165.sportsclub.entity.Team;

/**
 * Created by norbert on 20.11.16.
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
}
