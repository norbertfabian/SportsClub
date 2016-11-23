package cz.muni.fi.pa165.sportsclub.mapper;

import cz.muni.fi.pa165.sportsclub.dto.player.PlayerCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
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

    @Override
    public <T extends TeamCreateDto> T teamToDto(Team team, Class<T> destinationClass) {
        T dto = dtoMapper.map(team, destinationClass);
        dto.setAgeGroupLabelsList(AgeGroup.getAllLabels());
        dto.setAgeGroupLabel(team.getAgeGroup().getLabel());
        return dto;
    }

    @Override
    public Team dtoToTeam(TeamCreateDto dto) {
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
}
