package cz.muni.fi.pa165.sportsclub.service.impl;

import cz.muni.fi.pa165.sportsclub.dao.TeamManagerDao;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
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
        tmDao.create(tm);
    }

    @Override
    public void removeTeamManager(TeamManager tm) {
        tmDao.remove(tm);
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
    public List<TeamManager> findAll() {
        return tmDao.findAll();
    }

    @Override
    public List<TeamManager> findByName(String name) {
        return tmDao.findByName(name);
    }
    
}
