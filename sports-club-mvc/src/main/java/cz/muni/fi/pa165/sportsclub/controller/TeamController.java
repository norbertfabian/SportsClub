package cz.muni.fi.pa165.sportsclub.controller;

import cz.muni.fi.pa165.sportsclub.facade.TeamFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * @author Fabian Norbert
 */

@Controller
@RequestMapping("/team")
public class TeamController {

    @Inject
    TeamFacade teamFacade;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getTeams() {
        ModelAndView model = new ModelAndView();
        model.addObject("teams", teamFacade.getAllTeams());
        model.setViewName("team/list");
        return model;
    }
}
