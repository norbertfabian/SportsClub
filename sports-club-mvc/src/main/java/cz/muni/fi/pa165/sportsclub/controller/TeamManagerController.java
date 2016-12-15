package cz.muni.fi.pa165.sportsclub.controller;

import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.facade.TeamFacade;
import cz.muni.fi.pa165.sportsclub.facade.TeamManagerFacade;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Marian Sulgan
 */
@Controller
@RequestMapping("/team-manager")
public class TeamManagerController {
    
    @Inject
    TeamManagerFacade tmFacade;
    
    @Inject
    TeamFacade teamFacade;
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createTeamManager(Model model) {
        model.addAttribute("teamManager", new TeamManagerDto());
        return "team-manager/create";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createTeamManager(@ModelAttribute("teamManager") TeamManagerDto tm, UriComponentsBuilder uriBuilder) {
        tmFacade.createTeamManager(tm);
        return "redirect:" + uriBuilder.path("/team-manager").toUriString();
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTeamManager(@PathVariable long id, UriComponentsBuilder uriBuilder) {
        tmFacade.deleteTeamManager(id);
        return "redirect:" + uriBuilder.path("/team-manager").toUriString();
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateTeamManager(@PathVariable long id, Model model) {
        TeamManagerDto tm = tmFacade.getTeamManager(id);
        if (tm == null)
            return "redirect:/team-manager";
        model.addAttribute("teamManager", tm);
        return "team-manager/update";
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateTeamManager(@ModelAttribute("teamManager") TeamManagerDto tm, @PathVariable("id") long id, Model model, UriComponentsBuilder uriBuilder) {
        tm.setId(id);
        tmFacade.updateTeamManager(tm);
        return "redirect:" + uriBuilder.path("/team-manager").toUriString();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getTeamManager(@PathVariable("id") long id, Model model) {
        TeamManagerDto tmDto = tmFacade.getTeamManager(id);
        model.addAttribute("teamManager", tmDto);
        return "team-manager/detail";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String getTeamManagers(Model model) {
        model.addAttribute("teamManagers", tmFacade.getAllTeamManagers());
        return "team-manager/list";
    }
    
}
