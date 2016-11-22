package cz.muni.fi.pa165.sportsclub.dao.impl;

import cz.muni.fi.pa165.sportsclub.dao.PlayerDao;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * DAO implementation of {@link PlayerDao} for DB.
 * 
 * @author Patrik Novak
 */
@Repository
@Transactional
public class PlayerDaoImpl implements PlayerDao{

    @PersistenceContext
    EntityManager em;

    @Override
    public void create(Player player) {
        em.persist(player);
    }

    @Override
    public Player update(Player player) {
        return em.merge(player);
    }

    @Override
    public void remove(Long id) {
        em.remove(findById(id));
    }

    @Override
    public Player findById(Long id) {
        return em.find(Player.class, id);
    }

    @Override
    public List<Player> getAll() {
        CriteriaQuery<Player> criteria = em.getCriteriaBuilder().createQuery(Player.class);
        return em.createQuery(criteria.select(criteria.from(Player.class))).getResultList();
    }
    
}
