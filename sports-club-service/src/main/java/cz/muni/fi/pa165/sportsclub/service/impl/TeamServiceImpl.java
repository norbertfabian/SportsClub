package cz.muni.fi.pa165.sportsclub.service.impl;

import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.exception.SportsClubServiceException;
import cz.muni.fi.pa165.sportsclub.service.TeamService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by norbert on 5.11.16.
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
    public List<Team> getAll() {
        return teamDao.getAll();
    }

    @Override
    public void createTeam(Team team) {
        Team persistedTeam = teamDao.getByName(team.getName());
        if(persistedTeam != null) {
            throw new SportsClubServiceException("Team name already exists.");
        }
        teamDao.create(team);
    }

    @Override
    public Team updateTeam(Team team) {
        Team persistedTeam = teamDao.getByName(team.getName());
        if(persistedTeam != null && persistedTeam.getId() != team.getId()) {
            throw new SportsClubServiceException("Team name already exists.");
        }
        return teamDao.update(team);
    }

    @Override
    public void removeTeam(long id) {
        teamDao.remove(id);
    }
}
