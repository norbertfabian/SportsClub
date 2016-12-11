package cz.muni.fi.pa165.sportsclub.controller;

import cz.muni.fi.pa165.sportsclub.dao.PlayerDao;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import cz.muni.fi.pa165.sportsclub.facade.TeamFacade;
import cz.muni.fi.pa165.sportsclub.facade.TeamManagerFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.util.List;

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

    @ModelAttribute("teamManagers")
    public List<TeamManagerDto> categories() {
        return teamManagerFacade.getAllTeamManagers();
    }

    @ModelAttribute("ageGroups")
    public List<String> ageGroups() {
        return AgeGroup.getAllLabels();
    }
}
