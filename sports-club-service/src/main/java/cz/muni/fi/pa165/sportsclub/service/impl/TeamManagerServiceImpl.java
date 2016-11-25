package cz.muni.fi.pa165.sportsclub.service.impl;

import cz.muni.fi.pa165.sportsclub.dao.TeamManagerDao;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.exception.SportsClubServiceException;
import cz.muni.fi.pa165.sportsclub.service.TeamManagerService;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marian Sulgan
 */

@Service
public class TeamManagerServiceImpl implements TeamManagerService {
    
    @Inject
    TeamManagerDao tmDao;

    @Override
    public void createTeamManager(TeamManager tm) {
        TeamManager testTm = tmDao.findById(tm.getId());
        if (testTm != null) {
            throw new SportsClubServiceException("Team manager with given ID already exists.");
        }
        tmDao.create(tm);
    }

    @Override
    public void removeTeamManager(long id) {
        tmDao.remove(id);
    }

    @Override
    public TeamManager updateTeamManager(TeamManager tm) {
        return tmDao.update(tm);
    }

    @Override
    public TeamManager findById(long id) {
        return tmDao.findById(id);
    }

    @Override
    public List<TeamManager> getAll() {
        return tmDao.getAll();
    }

    @Override
    public List<TeamManager> findByName(String name) {
        return tmDao.findByName(name);
    }
    
}
