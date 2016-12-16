package cz.muni.fi.pa165.sportsclub.controller;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.dao.MembershipDao;
import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.facade.MembershipFacade;
import cz.muni.fi.pa165.sportsclub.facade.PlayerFacade;
import cz.muni.fi.pa165.sportsclub.facade.TeamFacade;
import cz.muni.fi.pa165.sportsclub.service.MembershipService;
import cz.muni.fi.pa165.sportsclub.service.PlayerService;
import cz.muni.fi.pa165.sportsclub.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by jsmolar on 12/13/16.
 */
@Controller
@RequestMapping("/team/{teamId}/membership")
public class MembershipController {

    @Inject
    TeamFacade teamFacade;

    @Inject
    MembershipFacade membershipFacade;

    @Inject
    PlayerFacade playerFacade;

    @Inject
    MembershipDao membershipDao;

    @Inject
    MembershipService membershipService;

    @Inject
    TeamService teamService;

    @Inject
    PlayerService playerService;

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deletePlayer(@PathVariable("id") long id, @PathVariable("teamId") long teamId,
        UriComponentsBuilder uriBuilder){
//        System.out.print(membershipFacade.findAllMemberships());
        membershipFacade.deleteMembership(membershipFacade.findMembership(id));

        return "redirect:" + uriBuilder.path("/team/" + teamId + "/membership").toUriString();
    }

    @RequestMapping(value="/add/{id}", method = RequestMethod.GET)
    public String addPlayer(@PathVariable("id") long id, @PathVariable("teamId") long teamId,
        UriComponentsBuilder uriBuilder){

        TeamDto team = teamFacade.getTeam(teamId);
        PlayerDto player = playerFacade.getPlayer(id);

        MembershipDto membership = new MembershipDto();
        membership.setTeam(team);
        membership.setPlayer(player);

//        team.addMembership(membership);
//        player.addMembership(membership);


        membershipFacade.createMembership(membership);
//        teamFacade.updateTeam(team);
//        playerFacade.updatePlayer(player);


        return "redirect:" + uriBuilder.path("/team/" + teamId + "/membership").toUriString();
    }

}
