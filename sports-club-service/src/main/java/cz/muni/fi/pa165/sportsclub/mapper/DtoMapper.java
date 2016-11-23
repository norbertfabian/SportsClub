package cz.muni.fi.pa165.sportsclub.mapper;

import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;

/**
 * @author Fabian Norbert
 */
public interface DtoMapper {
    
    /**
     * Maps fields with same name from one class to another.
     *
     * @param source Source class
     * @param destination Destination class
     */
    void mapTo(Object source, Object destination);

    /**
     * Maps a team entity to a dto of given type.
     *
     * @param team Team entity
     * @return Mapped TeamDto
     */
    TeamDto teamToDto(Team team);

    /**
     * Maps a teamDto to an entity.
     * @param dto Dto to map
     * @return Mapped team entity
     */
    Team dtoToTeam(TeamDto dto);

    /**
     * Maps a player entity to a PlayerDto.
     *
     * @param <T> implementation of PlayerCreateDto
     * @param player Player entity
     * @param maptoClass Dto type
     * @return Mapped Dto of the given type
     */
    <T extends PlayerCreateDto> T playerToDto(Player player, Class<T> maptoClass);

    /**
     * Maps a playerDto to an entity.
     *
     * @param dto Dto to map
     * @return Mapped player entity
     */
    Player dtoToPlayer(PlayerDto dto);
    
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
