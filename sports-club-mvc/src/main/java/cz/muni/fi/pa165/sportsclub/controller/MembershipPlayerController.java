package cz.muni.fi.pa165.sportsclub.controller;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.facade.MembershipFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by jsmolar on 12/16/16.
 */
@Controller
@RequestMapping("/player/{playerId}/membership")
public class MembershipPlayerController {

    @Inject
    MembershipFacade membershipFacade;

//    @Inject
//    PlayerFacade playerFacade;
//
//    @Inject
//    TeamFacade teamFacade;
//
//    @RequestMapping(value="/refresh", method = RequestMethod.GET)
//    public String getPlayers(@PathVariable("playerId") long playerId, Model model) {
//        PlayerDto player = playerFacade.getPlayer(playerId);
//
//        Set<MembershipDto> memberships = player.getMemberships();
//        List<TeamDto> teams = teamFacade.getAllTeams();
//
//        for (MembershipDto membership : memberships){
//
//            if (teams.contains(membership.getTeam())){
//
//                teams.remove(membership.getTeam());
//            }
//        }
//
//        model.addAttribute("player", player);
//        model.addAttribute("teams", teams);
//        model.addAttribute("memberships", memberships);
//
//        return "/membership/manage";
//    }

    @RequestMapping(value="/remove/{id}", method = RequestMethod.GET)
    public String removePlayer(@PathVariable("id") long id, @PathVariable("playerId") long playerId,
        UriComponentsBuilder uriBuilder){

        membershipFacade.deleteMembership(membershipFacade.findMembership(id));

        return "redirect:" + uriBuilder.path("/player/" + playerId + "/membership").toUriString();
    }

    @RequestMapping(value="/assign/{id}", method = RequestMethod.GET)
    public String assignPlayer(@PathVariable("id") long id, @PathVariable("playerId") long playerId,
        UriComponentsBuilder uriBuilder){

        MembershipDto membershipDto = new MembershipDto();
        membershipFacade.createAndAssignMembership(membershipDto, id, playerId);

        return "redirect:" + uriBuilder.path("/player/" + playerId + "/membership").toUriString();
    }

}
