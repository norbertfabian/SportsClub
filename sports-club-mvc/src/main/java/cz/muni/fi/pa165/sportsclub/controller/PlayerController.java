package cz.muni.fi.pa165.sportsclub.controller;

import cz.muni.fi.pa165.sportsclub.dao.PlayerDao;
import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import cz.muni.fi.pa165.sportsclub.facade.PlayerFacade;
import cz.muni.fi.pa165.sportsclub.facade.TeamFacade;
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
 * @author Patrik Novak.
 */
@Controller
@RequestMapping("/player")
public class PlayerController {

    @Inject
    PlayerFacade playerFacade;

    @Inject
    TeamFacade teamFacade;

    @Inject
    TeamDao teamDao;

    @Inject
    PlayerDao playerDao;


    @RequestMapping(method = RequestMethod.GET)
    public String getPlayers(Model model) {
        model.addAttribute("players", playerFacade.getAllPlayers());
        return "player/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getPlayer(@PathVariable("id") long id, Model model) {
        PlayerDto player = playerFacade.getPlayer(id);

        model.addAttribute("player", player);
        model.addAttribute("memberships", player.getMemberships());

        return "player/detail";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, UriComponentsBuilder uriBuilder) {
        playerFacade.deletePlayer(id);
        return "redirect:" + uriBuilder.path("/player").toUriString();
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPlayer(Model model){
        model.addAttribute("player", new PlayerDto());
        return "player/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPlayer(@ModelAttribute("player") PlayerDto player, UriComponentsBuilder uriBuilder) {
        playerFacade.createPlayer(player);
        return "redirect:" + uriBuilder.path("/player").toUriString();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updatePlayer(@PathVariable long id, Model model) {
        PlayerDto player = playerFacade.getPlayer(id);
        if (player == null) {
            return "redirect:/player";
        }
        model.addAttribute("player", player);
        return "player/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updatePlayer(@ModelAttribute("player") PlayerDto player, @PathVariable("id") long id,
                             Model model, UriComponentsBuilder uriBuilder) {
        player.setId(id);
        playerFacade.updatePlayer(player);
        return "redirect:" + uriBuilder.path("/player").toUriString();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAvailableTeams(@PathVariable("id") long id, Model model) {
        PlayerDto player = playerFacade.getPlayer(id);
        List<TeamDto> teams = teamFacade.getAllowedTeams(player);

        model.addAttribute("teams", teams);

        return "team/list";
    }
}
