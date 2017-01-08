package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.entity.User;

import java.util.List;

/**
 * @author Fabian Norbert
 */
public interface UserService {

    User findById(long id);

    List<User> getAll();

    void create(User user);

    User update(User user);

    void remove(long id);
}
