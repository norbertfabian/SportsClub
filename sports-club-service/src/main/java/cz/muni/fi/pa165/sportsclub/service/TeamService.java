package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fabian Norbert
 */

@Service
public interface TeamService {

    /**
     * Finds team by specified id
     *
     * @param id Id of the team
     * @return Return team with the given id
     */
    Team findById(long id);

    /**
     * Returns all teams.
     *
     * @return List of all teams
     */
    List<Team> getAll();

    /**
     * Method creates new team
     *
     * @param team Team to create
     */
    void createTeam(Team team);

    /**
     * Updates team
     *
     * @param team Team with the updated data
     * @return Updated team
     */
    Team updateTeam(Team team);

    /**
     * Removes team
     * @param id Id of the team to remove
     */
    void removeTeam(long id);

    /**
     * Returns teams in which can player participate along to his age group
     *
     * @param player to be queried
     * @return Teams
     */
    List<Team> getAllowedTeams(Player player);
}
