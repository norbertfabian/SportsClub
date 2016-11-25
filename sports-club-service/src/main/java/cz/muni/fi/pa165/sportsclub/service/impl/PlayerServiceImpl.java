package cz.muni.fi.pa165.sportsclub.service.impl;

import cz.muni.fi.pa165.sportsclub.dao.PlayerDao;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.service.PlayerService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Patrik Novak
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Inject
    PlayerDao playerDao;

    @Override
    public Player findById(long id) {
        return playerDao.findById(id);
    }

    @Override
    public List<Player> getAll() {
        return playerDao.getAll();
    }

    @Override
    public void createPlayer(Player player) {
        playerDao.create(player);
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerDao.update(player);
    }

    @Override
    public void removePlayer(long id) {
        playerDao.remove(id);
    }

}
