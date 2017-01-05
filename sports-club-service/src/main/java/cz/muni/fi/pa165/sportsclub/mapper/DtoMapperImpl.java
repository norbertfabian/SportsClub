package cz.muni.fi.pa165.sportsclub.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.entity.Membership;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Fabian Norbert
 */
@Component
public class DtoMapperImpl implements DtoMapper {

    @Inject
    private Mapper dtoMapper;

    @Override
    public <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass) {
        List<T> mappedCollection = new ArrayList<>();
        for (Object object : objects) {
            mappedCollection.add(dtoMapper.map(object, mapToClass));
        }
        return mappedCollection;
    }

    @Override
    public <T> T mapTo(Object u, Class<T> mapToClass) {
        return dtoMapper.map(u, mapToClass);
    }

    @Override
    public void mapTo(Object source, Object destination) {
        dtoMapper.map(source, destination);
    }

    @Override
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
    public MembershipDto membershipToDto(Membership membership) {
        MembershipDto dto = new MembershipDto();
        dtoMapper.map(membership, dto);
        return dto;
    }

    @Override
    public Membership dtoToMembership(MembershipDto dto) {
        Membership membership = new Membership();
        dtoMapper.map(dto, membership);
        return membership;
    }

    @Override
    public PlayerDto playerToDto(Player player) {
        PlayerDto dto = new PlayerDto();
        dtoMapper.map(player, dto);
        for(Membership membership: player.getMemberships()) {
            dto.getMemberships().stream()
                    .filter(memDto -> membership.getTeam().getId() == memDto.getId())
                    .forEach(memDto -> memDto.getTeam().setAgeGroupLabel(membership.getTeam().getAgeGroup().getLabel()));
        }
        return dto;
    }

    @Override
    public Player dtoToPlayer(PlayerDto dto) {
        Player player = new Player();
        dtoMapper.map(dto, player);
        return player;
    }

    @Override
    public TeamManager dtoToTeamManager(TeamManagerDto dto) {
        TeamManager tm = new TeamManager();
        dtoMapper.map(dto, tm);
        return tm;
    }

    @Override
    public TeamManagerDto teamManagerToDto(TeamManager tm) {
        TeamManagerDto dto = new TeamManagerDto();
        dtoMapper.map(tm, dto);
        for(Team team: tm.getTeams()) {
            dto.getTeams().stream()
                    .filter(teamDto -> team.getId() == teamDto.getId())
                    .forEach(teamDto -> teamDto.setAgeGroupLabel(team.getAgeGroup().getLabel()));
        }
        return dto;
    }
}