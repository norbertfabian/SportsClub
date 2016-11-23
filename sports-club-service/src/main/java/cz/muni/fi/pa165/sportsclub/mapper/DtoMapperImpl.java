package cz.muni.fi.pa165.sportsclub.mapper;

import cz.muni.fi.pa165.sportsclub.dto.player.PlayerCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by norbert on 20.11.16.
 */
@Component
public class DtoMapperImpl implements DtoMapper {

    @Inject
    private Mapper dtoMapper;

    public TeamDto teamToDto(Team team) {
        TeamDto dto = new TeamDto();
        dtoMapper.map(team, dto);
        dto.setAgeGroupLabel(team.getAgeGroup().getLabel());
        return dto;
    }

    @Override
    public Team dtoToTeam(TeamDto dto) {
        Team team = new Team();
        dtoMapper.map(dto, team);
        team.setAgeGroup(AgeGroup.getByLabel(dto.getAgeGroupLabel()));
        return team;
    }

    @Override
    public <T extends PlayerCreateDto> T playerToDto(Player player, Class<T> destinationClass) {
        return dtoMapper.map(player, destinationClass);
    }

    @Override
    public Player dtoToPlayer(PlayerDto dto) {
        Player player = new Player();
        dtoMapper.map(dto, player);
        return player;
    }

    @Override
    public void mapTo(Object source, Object destination) {
        dtoMapper.map(source, destination);
    }
}
