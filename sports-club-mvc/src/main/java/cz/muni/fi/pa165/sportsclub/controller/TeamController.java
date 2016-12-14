package cz.muni.fi.pa165.sportsclub.controller;

import java.util.List;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.dao.PlayerDao;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import cz.muni.fi.pa165.sportsclub.facade.PlayerFacade;
import cz.muni.fi.pa165.sportsclub.facade.TeamFacade;
import cz.muni.fi.pa165.sportsclub.facade.TeamManagerFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Fabian Norbert
 */

@Controller
@RequestMapping("/team")
public class TeamController {

    @Inject
    TeamFacade teamFacade;

    @Inject
    TeamManagerFacade teamManagerFacade;

    @Inject
    PlayerFacade playerFacade;

    @Inject
    PlayerDao playerDao;


    @RequestMapping(method = RequestMethod.GET)
    public String getTeams(Model model) {
        model.addAttribute("teams", teamFacade.getAllTeams());
        return "team/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getTeam(@PathVariable("id") long id, Model model) {
        TeamDto team = teamFacade.getTeam(id);

        model.addAttribute("team", team);
        model.addAttribute("teamManager", team.getTeamManager());
        model.addAttribute("memberships", team.getMemberships());

        return "team/detail";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, UriComponentsBuilder uriBuilder) {
        teamFacade.deleteTeam(id);
        return "redirect:" + uriBuilder.path("/team").toUriString();
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createTeam(Model model){
        model.addAttribute("team", new TeamDto());
        return "team/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createTeam(@ModelAttribute("team") TeamDto team, UriComponentsBuilder uriBuilder) {
        team.setTeamManager(teamManagerFacade.getTeamManager(team.getTeamManagerId()));
        teamFacade.createTeam(team);
        return "redirect:" + uriBuilder.path("/team").toUriString();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateTeam(@PathVariable long id, Model model) {
        TeamDto team = teamFacade.getTeam(id);
        if (team == null) {
            return "redirect:/team";
        }
        model.addAttribute("team", team);
        return "team/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateTrip(@ModelAttribute("team") TeamDto team, @PathVariable("id") long id,
                             Model model, UriComponentsBuilder uriBuilder) {
        team.setId(id);
        team.setTeamManager(teamManagerFacade.getTeamManager(team.getTeamManagerId()));
        teamFacade.updateTeam(team);
        return "redirect:" + uriBuilder.path("/team").toUriString();
    }

//    @RequestMapping(value = "/{id}/membership", method = RequestMethod.GET)
    //    public String managePlayers(@PathVariable("id") long id, Model model){
    //        TeamDto team = teamFacade.getTeam(id);
    //        model.addAttribute("team", team);
    //        model.addAttribute("memberships", team.getMemberships());
    //        model.addAttribute("freePlayers", playerFacade.);
    //
    //        return "/membership/manage";
    //    }

    @RequestMapping(value = "/{id}/managePlayers", method = RequestMethod.GET)
    public MembershipController managePlayers(@PathVariable("id") long id, Model model){
        TeamDto team = teamFacade.getTeam(id);
        model.addAttribute("team", team);
        model.addAttribute("memberships", team.getMemberships());
//        model.addAttribute("freePlayers", playerFacade.);

        return new MembershipController();
    }

    @ModelAttribute("teamManagers")
    public List<TeamManagerDto> categories() {
        return teamManagerFacade.getAllTeamManagers();
    }

    @ModelAttribute("ageGroups")
    public List<String> ageGroups() {
        return AgeGroup.getAllLabels();
    }
}
