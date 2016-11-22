package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by norbert on 5.11.16.
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
}
