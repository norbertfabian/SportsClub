package cz.muni.fi.pa165.sportsclub.controller;

import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.facade.MembershipFacade;
import cz.muni.fi.pa165.sportsclub.facade.PlayerFacade;
import cz.muni.fi.pa165.sportsclub.facade.TeamFacade;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

/**
 * Created by jsmolar on 12/16/16.
 */
@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/player/{playerId}/membership")
public class MembershipPlayerController {

    @Inject
    MembershipFacade membershipFacade;

    @Inject
    PlayerFacade playerFacade;

    @Inject
    TeamFacade teamFacade;

    @RequestMapping(value="/refresh", method = RequestMethod.GET)
    public String getPlayers(@PathVariable("playerId") long playerId, Model model) {
        PlayerDto player = playerFacade.getPlayer(playerId);
        Set<MembershipDto> memberships = player.getMemberships();
        List<TeamDto> teams = teamFacade.getAllTeams();


        for(TeamDto team : teams){
            for(MembershipDto membership : memberships){
                if((team.getMemberships()).contains(membership)){
                    teams.remove(team);
                }
            }
        }

        model.addAttribute("player", player);
        model.addAttribute("teams", teams);
        model.addAttribute("memberships", memberships);

        return "/membership/assign";
    }

    @RequestMapping(value="/remove/{id}", method = RequestMethod.GET)
    public String removePlayer(@PathVariable("id") long id, @PathVariable("playerId") long playerId,
        UriComponentsBuilder uriBuilder){

        membershipFacade.deleteMembership(membershipFacade.findMembership(id));

        return "redirect:" + uriBuilder.path("/player/" + playerId + "/membership/refresh").toUriString();
    }

    @RequestMapping(value="/assign/{id}", method = RequestMethod.GET)
    public String assignPlayer(@PathVariable("id") long id, @PathVariable("playerId") long playerId,
        UriComponentsBuilder uriBuilder){

        MembershipDto membershipDto = new MembershipDto();
        membershipDto.setJerseyNumber(12);
        membershipFacade.createAndAssignMembership(membershipDto, (long) membershipDto.getJerseyNumber(), playerId);

        return "redirect:" + uriBuilder.path("/player/" + playerId + "/membership/refresh").toUriString();
    }

}
