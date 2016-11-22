package cz.muni.fi.pa165.sportsclub.mapper;

import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * @author Fabian Norbert
 */
@Component
public class DtoMapperImpl implements DtoMapper {

    @Inject
    private Mapper dtoMapper;

    public <T extends TeamCreateDto> T teamToDto(Team team, Class<T> destinationClass) {
        T dto = dtoMapper.map(team, destinationClass);
        dto.setAgeGroupLabelsList(AgeGroup.getAllLabels());
        dto.setAgeGroupLabel(team.getAgeGroup().getLabel());
        return dto;
    }

    public Team dtoToTeam(TeamCreateDto dto) {
        Team team = new Team();
        dtoMapper.map(dto, team);
        team.setAgeGroup(AgeGroup.getByLabel(dto.getAgeGroupLabel()));
        return team;
    }
}
