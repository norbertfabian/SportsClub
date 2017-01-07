package cz.muni.fi.pa165.sportsclub.service.impl;

import cz.muni.fi.pa165.sportsclub.dao.UserDao;
import cz.muni.fi.pa165.sportsclub.entity.User;
import cz.muni.fi.pa165.sportsclub.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Fabian Norbert
 */

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void remove(long id) {
        userDao.remove(id);
    }
}
