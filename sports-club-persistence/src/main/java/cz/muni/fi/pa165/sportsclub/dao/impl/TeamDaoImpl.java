package cz.muni.fi.pa165.sportsclub.dao.impl;

import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public void remove(Team team) {
        em.remove(team);
    }

    @Override
    public Team findById(Long id) {
        return em.find(Team.class, id);
    }
}
