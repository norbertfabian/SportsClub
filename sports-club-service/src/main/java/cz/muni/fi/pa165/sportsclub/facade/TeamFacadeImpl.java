package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.dto.ageGroup.AgeGroupDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import cz.muni.fi.pa165.sportsclub.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fabian Norbert
 */
@Service
@Transactional
public class TeamFacadeImpl implements TeamFacade {

    @Inject
    private DtoMapper dtoMapper;

    @Inject
    private TeamService teamService;

    @Override
    public void createTeam(TeamDto dto) {
        Team team = dtoMapper.dtoToTeam(dto);
        teamService.createTeam(team);
    }

    @Override
    public void deleteTeam(long id) {
        teamService.removeTeam(id);
    }

    @Override
    public void updateTeam(TeamDto dto) {
        Team team = dtoMapper.dtoToTeam(dto);
        teamService.updateTeam(team);
    }

    @Override
    public List<TeamDto> getAllTeams() {
        List<Team> teams = teamService.getAll();
        List<TeamDto> teamDtos = new ArrayList<>();
        for(Team team: teams) {
            teamDtos.add(dtoMapper.teamToDto(team));
        }
        return teamDtos;
    }

    @Override
    public TeamDto getTeam(long id) {
        Team team = teamService.findById(id);
        return dtoMapper.teamToDto(team);
    }

    @Override
    public List<AgeGroupDto> getAgeGroups() {
        List<AgeGroupDto> ageGroupDtos = new ArrayList<>();
        for(AgeGroup ageGroup: AgeGroup.values()) {
            AgeGroupDto dto = new AgeGroupDto();
            dtoMapper.mapTo(ageGroup, dto);
            ageGroupDtos.add(dto);
        }
        return ageGroupDtos;
    }
}
