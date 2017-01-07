package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.User;

import java.util.List;

/**
 * @author Fabian Norbert
 */
public interface UserDao {

    void create(User user);

    User update(User user);

    void remove(long id);

    User findById(long id);

    List<User> getAll();
}
