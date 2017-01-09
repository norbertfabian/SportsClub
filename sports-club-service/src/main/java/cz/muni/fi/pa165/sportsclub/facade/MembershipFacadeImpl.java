package cz.muni.fi.pa165.sportsclub.facade;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.entity.Membership;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import cz.muni.fi.pa165.sportsclub.service.MembershipService;
import cz.muni.fi.pa165.sportsclub.service.PlayerService;
import cz.muni.fi.pa165.sportsclub.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jakub Smolar     
 */
@Service
@Transactional
public class MembershipFacadeImpl implements MembershipFacade {

    @Inject
    private DtoMapper dtoMapper;

    @Inject
    private MembershipService membershipService;

    @Inject
    private TeamService teamService;

    @Inject
    private PlayerService playerService;

    @Override
    public void createMembership(MembershipDto dto){
        Membership membership =  dtoMapper.dtoToMembership(dto);
        membershipService.createMembership(membership);
    }

    @Override
    public void deleteMembership(MembershipDto dto) {
        Membership membership =  dtoMapper.mapTo(dto, Membership.class);
        membershipService.removeMembership(membership);
    }

    @Override
    public void updateMembership(MembershipDto dto) {
        Membership membership =  dtoMapper.mapTo(dto, Membership.class);
        membershipService.updateMembership(membership);
    }

    @Override
    public void updateMembership(MembershipDto dto, long oldMembershipId) {
        Membership membership =  dtoMapper.mapTo(dto, Membership.class);
        Membership oldMembership = membershipService.findById(oldMembershipId);

        membership.setId(oldMembershipId);
        membership.setTeam(oldMembership.getTeam());
        membership.setPlayer(oldMembership.getPlayer());

        membershipService.updateMembership(membership);
    }

    @Override
    public List<MembershipDto> findAllMemberships() {
        List<MembershipDto> result = new ArrayList<>();
        for (Membership membership : membershipService.findAll()) {
            result.add(dtoMapper.mapTo(membership, MembershipDto.class));
        }

        return result;
    }

    @Override
    public MembershipDto findMembership(long id) {
        Membership membership = membershipService.findById(id);
        return dtoMapper.mapTo(membership, MembershipDto.class);
    }

    @Override
    public void createAndAssignMembership(MembershipDto dto, long teamId, long playerId) {
        Membership membership = dtoMapper.dtoToMembership(dto);
        membership.setTeam(teamService.findById(teamId)).setPlayer(playerService.findById(playerId));

        Team team = teamService.findById(teamId);
        Player player = playerService.findById(playerId);
        team.addMembership(membership);
        player.addMembership(membership);

        teamService.updateTeam(team);
        playerService.updatePlayer(player);
        membershipService.createMembership(membership);
    }

    @Override
    public List<MembershipDto> getAllMembershipsForPlayer(long id) {
        List<MembershipDto> result = new ArrayList<>();
        for (Membership membership : playerService.findById(id).getMemberships()) {
            result.add(dtoMapper.mapTo(membership, MembershipDto.class));
        }

        return result;
    }

    @Override
    public List<MembershipDto> getAllMembershipsForTeam(long id) {
        List<MembershipDto> result = new ArrayList<>();
        for (Membership membership : teamService.findById(id).getMemberships()) {
            result.add(dtoMapper.mapTo(membership, MembershipDto.class));
        }

        return result;
    }

    @Override
    public List<TeamDto> getAllAvailableTeamsForPlayer(long id) {
        List<Team> teams = teamService.getAll();
        List<Team> availableTeams = teamService.getAll();

        for(Team team : teams){
            List<MembershipDto> teamMemberships = getAllMembershipsForTeam(team.getId());
            for(MembershipDto membership : teamMemberships){
                if(membership.getPlayer().getId() == id){
                    availableTeams.remove(team);
                }
            }
        }

        List<TeamDto> result = new ArrayList<>();
        for (Team team : availableTeams) {
            result.add(dtoMapper.mapTo(team, TeamDto.class));
        }

        return result;
    }

}
