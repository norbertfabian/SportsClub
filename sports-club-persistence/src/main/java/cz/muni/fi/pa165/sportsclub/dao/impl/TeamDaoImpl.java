package cz.muni.fi.pa165.sportsclub.dao.impl;

import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.entity.Team;
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
public class TeamDaoImpl implements TeamDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public void create(Team team) {
        em.persist(team);
    }

    @Override
    public Team update(Team team) {
        return em.merge(team);
    }

    @Override
    public void remove(long id) {
        em.remove(findById(id));
    }

    @Override
    public Team findById(long id) {
        return em.find(Team.class, id);
    }

    @Override
    public List<Team> getAll() {
        CriteriaQuery<Team> criteria = em.getCriteriaBuilder().createQuery(Team.class);
        return em.createQuery(criteria.select(criteria.from(Team.class))).getResultList();
    }
}
