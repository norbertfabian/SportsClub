package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.service.TeamService;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by norbert on 19.11.16.
 */
@Service
@Transactional
public class TeamFacadeImpl implements TeamFacade {

    @Inject
    private Mapper dtoMapper;

    @Inject
    private TeamService teamService;

    @Override
    public void createTeam(TeamCreateDto dto) {
        Team team = new Team();
        dtoMapper.map(dto, team);
        teamService.createTeam(team);
    }

    @Override
    public void deleteTeam(long id) {
        teamService.removeTeam(id);
    }

    @Override
    public void updateTeam(TeamDto dto) {
        Team team = new Team();
        dtoMapper.map(dto, team);
        teamService.updateTeam(team);
    }

    @Override
    public List<TeamDto> getAllTeams() {
        List<Team> teams = teamService.getAll();
        List<TeamDto> teamDtos = new ArrayList<>();
        for(Team team: teams) {
            teamDtos.add(dtoMapper.map(team, TeamDto.class));
        }
        return teamDtos;
    }

    @Override
    public TeamDto getTeam(long id) {
        Team team = teamService.findById(id);
        return dtoMapper.map(team, TeamDto.class);
    }
}
