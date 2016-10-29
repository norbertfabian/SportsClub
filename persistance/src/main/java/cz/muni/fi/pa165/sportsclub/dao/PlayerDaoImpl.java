package cz.muni.fi.pa165.sportsclub.dao;

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
 * @author Patrik Nov�k
 */
@Repository
@Transactional
public class PlayerDaoImpl implements PlayerDao{

    @PersistenceContext
    EntityManager em;
    
    public void create(Player player) {
        em.persist(player);
    }

    public Player update(Player player) {
        return em.merge(player);
    }

    public void remove(Player player) {
        em.remove(player);
    }

    public Player findById(Long id) {
        return em.find(Player.class, id);
    }

    public List<Player> findAll() {
        CriteriaQuery<Player> criteria = em.getCriteriaBuilder().createQuery(Player.class);
        return em.createQuery(criteria.select(criteria.from(Player.class))).getResultList();
    }
    
}
