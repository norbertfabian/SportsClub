package cz.muni.fi.pa165.sportsclub.dao.impl;

import cz.muni.fi.pa165.sportsclub.dao.TeamManagerDao;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 *
 * @author Marian Sulgan
 */
@Repository
@Transactional
public class TeamManagerDaoImpl implements TeamManagerDao {
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void create(TeamManager tm) {
        em.persist(tm);
    }

    @Override
    public TeamManager update(TeamManager tm) {
        return em.merge(tm);
    }

    @Override
    public void remove(long id) {
        em.remove(findById(id));
    }

    @Override
    public TeamManager findById(long id) {
        return em.find(TeamManager.class, id);
    }

    @Override
    public List<TeamManager> getAll() {
        CriteriaQuery<TeamManager> criteria = em.getCriteriaBuilder().createQuery(TeamManager.class);
        return em.createQuery(criteria.select(criteria.from(TeamManager.class))).getResultList();
    }
    
    @Override
    public List<TeamManager> findByName(String name) {
        return em.createQuery(
                "SELECT tm FROM TeamManager tm WHERE tm.name = :name", TeamManager.class)
                    .setParameter("name", name)
                    .getResultList();
    }

}
