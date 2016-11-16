package cz.muni.fi.pa165.sportsclub.service.impl;

import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.service.TeamService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author Fabian Norbert
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Inject
    TeamDao teamDao;

    @Override
    public Team findById(long id) {
        return teamDao.findById(id);
    }

    @Override
    public void createTeam(Team team) {
        teamDao.create(team);
    }

    @Override
    public Team updateTeam(Team team) {
        return teamDao.update(team);
    }

    @Override
    public void removeTeam(Team team) {
        teamDao.remove(team);
    }
}
