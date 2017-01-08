package cz.muni.fi.pa165.sportsclub.dao.impl;

import cz.muni.fi.pa165.sportsclub.dao.UserDao;
import cz.muni.fi.pa165.sportsclub.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @author Fabian Norbert
 */

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    public User update(User user) {
        return em.merge(user);
    }

    @Override
    public void remove(long id) {
        em.remove(findById(id));
    }

    @Override
    public User findById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        CriteriaQuery<User> criteria = em.getCriteriaBuilder().createQuery(User.class);
        return em.createQuery(criteria.select(criteria.from(User.class))).getResultList();
    }
}
