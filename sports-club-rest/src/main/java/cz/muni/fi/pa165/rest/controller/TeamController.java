package cz.muni.fi.pa165.rest.controller;

import cz.muni.fi.pa165.rest.Exception.ResourceAlreadyExistsException;
import cz.muni.fi.pa165.rest.Exception.ResourceNotFoundException;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.exception.SportsClubServiceException;
import cz.muni.fi.pa165.sportsclub.facade.TeamFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;

/**
 * @author Fabian Norbert
 */

@RestController
@RequestMapping("/team")
public class TeamController {

    @Inject
    private TeamFacade teamFacade;

    /**
     * Returns all teams as JSON.
     *
     * @return List of TeamDtos as JSON
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final List<TeamDto> getTeams() {
        return teamFacade.getAllTeams();
    }

    /**
     * Returns Team with the given id as JSON.
     *
     * @param id ID of the team to return
     * @return TeamDto as JSON
     * @throws ResourceNotFoundException Thrown when team with given ID not found
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final TeamDto getTeam(@PathVariable("id") long id) throws ResourceNotFoundException {
        return resolveNotFound(teamFacade.getTeam(id));
    }

    /**
     * Creates a team with the given information.
     *
     * @param team TeamDto
     * @return Created team
     * @throws ResourceAlreadyExistsException Thrown when resource already exists
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final TeamDto createTeam(@RequestBody TeamDto team) throws ResourceAlreadyExistsException {
        return resolveAlreadyExist(team, t -> teamFacade.createTeam(t));
    }

    /**
     * Updates team with the given ID.
     *
     * @param team Team with the updated information
     * @param id ID of the team to update
     * @return Updated team
     * @throws ResourceAlreadyExistsException Thrown when resource already exists
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final TeamDto updateTeam(@RequestBody TeamDto team,
                                    @PathVariable("id") long id) throws ResourceAlreadyExistsException {
        team.setId(id);
        return resolveAlreadyExist(team, t -> teamFacade.updateTeam(t));
    }

    /**
     * Deletes a team with the given ID.
     *
     * @param id ID of the team to delete.
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteTeam(@PathVariable("id") long id) {
        teamFacade.deleteTeam(id);
    }

    /**
     * Throws ResourceNotFoundException if object is null. Otherwise returns object
     *
     * @param object Object to check if null
     * @param <T> Type of the object
     * @return Given object if it's not null
     */
    private <T> T resolveNotFound(T object) {
        if(object == null)
            throw new ResourceNotFoundException();
        return object;
    }

    /**
     * Throws ResourceAlreadyExistsException if SportsClubServiceException is thrown whe function is applied
     *
     * @param object Object to process
     * @param function Function to apply
     */
    private TeamDto resolveAlreadyExist(TeamDto object, Function<TeamDto, TeamDto> function) {
        try {
            return function.apply(object);
        } catch(SportsClubServiceException ex) {
            throw new ResourceAlreadyExistsException();
        }
    }
}
