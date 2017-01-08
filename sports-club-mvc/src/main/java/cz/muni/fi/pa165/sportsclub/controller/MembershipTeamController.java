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
 * Created by jsmolar on 12/13/16.
 */
@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/team/{teamId}/membership")
public class MembershipTeamController {

    @Inject
    MembershipFacade membershipFacade;

    @Inject
    PlayerFacade playerFacade;

    @Inject
    TeamFacade teamFacade;

    @RequestMapping(value="/refresh", method = RequestMethod.GET)
    public String getPlayers(@PathVariable("teamId") long teamId, Model model) {
        TeamDto team = teamFacade.getTeam(teamId);

        Set<MembershipDto> memberships = team.getMemberships();
        List<PlayerDto> players = playerFacade.getAllPlayers();

        for (MembershipDto membership : memberships){

            if (players.contains(membership.getPlayer())){

                players.remove(membership.getPlayer());
            }
        }

        model.addAttribute("team", team);
        model.addAttribute("memberships", memberships);
        model.addAttribute("players", players);

        return "/membership/manage";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deletePlayer(@PathVariable("id") long id, @PathVariable("teamId") long teamId,
        UriComponentsBuilder uriBuilder){

        membershipFacade.deleteMembership(membershipFacade.findMembership(id));

        return "redirect:" + uriBuilder.path("/team/" + teamId + "/membership/refresh").toUriString();
    }

    @RequestMapping(value="/add/{id}", method = RequestMethod.GET)
    public String addPlayer(@PathVariable("id") long id, @PathVariable("teamId") long teamId,
        UriComponentsBuilder uriBuilder){

        MembershipDto membershipDto = new MembershipDto();
        membershipFacade.createAndAssignMembership(membershipDto, teamId, id);

        return "redirect:" + uriBuilder.path("/team/" + teamId + "/membership/refresh").toUriString();
    }

}
