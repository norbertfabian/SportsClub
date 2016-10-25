package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.Team;

/**
 * Created by norbert on 24.10.16.
 */
public interface TeamDao {

    void create(Team team);

    Team update(Team team);

    void remove(Team team);

    Team findById(Long id);
}
