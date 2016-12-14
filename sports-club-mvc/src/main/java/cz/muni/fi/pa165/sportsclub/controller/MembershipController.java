package cz.muni.fi.pa165.sportsclub.controller;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.facade.MembershipFacade;
import cz.muni.fi.pa165.sportsclub.facade.TeamFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by jsmolar on 12/13/16.
 */
@Controller
//@RequestMapping("/team/{idTeam}/membership")
@RequestMapping("/")
public class MembershipController {

    @Inject
    TeamFacade teamFacade;

    @Inject
    MembershipFacade membershipFacade;

    @RequestMapping(method = RequestMethod.GET)
    public String getTeams() {
        return "membership/managePlayers";
    }

//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String deletePlayer(@PathVariable("id") long id, UriComponentsBuilder uriBuilder){
//
//        return "redirect:" + uriBuilder.path("/team/" + id + "/membership").toUriString();
//    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deletePlayer(@PathVariable("id") long id, @PathVariable("teamId") long teamId, UriComponentsBuilder uriBuilder){

        return "redirect:" + uriBuilder.path("/team/" + id + "/membership").toUriString();
    }

}
