package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marian Sulgan
 */
@Repository
@Transactional
public class TeamManagerDaoImpl implements TeamManagerDao {
    
    @PersistenceContext
    EntityManager em;

    public void create(TeamManager tm) {
        em.persist(tm);
    }

    public TeamManager update(TeamManager tm) {
        return em.merge(tm);
    }

    public void remove(TeamManager tm) {
        em.remove(tm);
    }

    public TeamManager findById(Long id) {
        return em.find(TeamManager.class, id);
    }

    @Override
    public List<TeamManager> findAll() {
        CriteriaQuery<TeamManager> criteria = em.getCriteriaBuilder().createQuery(TeamManager.class);
        return em.createQuery(criteria.select(criteria.from(TeamManager.class))).getResultList();
    }
    
}
