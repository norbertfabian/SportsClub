package cz.muni.fi.pa165.sportsclub.controller;

import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.facade.TeamFacade;
import cz.muni.fi.pa165.sportsclub.facade.TeamManagerFacade;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(method = RequestMethod.POST)
    public String createTeamManager(Model model) {
        return null;
    }
    
    
    public String deleteTeamManager(Model model) {
        return null;
    }
    
    
    public String updateTeamManager(Model model) {
        return null;
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
