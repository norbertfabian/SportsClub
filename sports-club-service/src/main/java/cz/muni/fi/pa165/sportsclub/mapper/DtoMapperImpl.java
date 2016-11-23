package cz.muni.fi.pa165.sportsclub.mapper;

import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
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
    public TeamManager dtoToTeamManager(TeamManagerCreateDto dto) {
        TeamManager tm = new TeamManager();
        dtoMapper.map(dto, tm);
        return tm;
    }

    @Override
    public TeamManagerDto teamManagerToDto(TeamManager tm, Class<TeamManagerDto> mapToClass) {
        TeamManagerDto dto = dtoMapper.map(tm, mapToClass);
        return dto;
    }
}
