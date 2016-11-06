package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.Team;

/**
 * DAO interface prescribing operations for Team entity.
 *
 * @author Fabian Norbert
 */
public interface TeamDao {

    /**
     * Persists Team.
     *
     * @param team Team to persist.
     */
    void create(Team team);

    /**
     * Updates changes of a Team in the database.
     *
     * @param team Updated Team.
     * @return updated Team
     */
    Team update(Team team);

    /**
     * Removes a team from the database.
     *
     * @param team Team to remove.
     */
    void remove(Team team);

    /**
     * Returns Team with the specified ID.
     *
     * @param id ID of the Team to return.
     * @return Team with the specified ID.
     */
    Team findById(Long id);
}
