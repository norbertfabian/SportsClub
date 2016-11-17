package cz.muni.fi.pa165.sportsclub.dao.impl;

import cz.muni.fi.pa165.sportsclub.dao.TeamManagerDao;
import cz.muni.fi.pa165.sportsclub.entity.Team;
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
    public void remove(TeamManager tm) {
        em.remove(tm);
    }

    @Override
    public TeamManager findById(Long id) {
        return em.find(TeamManager.class, id);
    }

    @Override
    public List<TeamManager> findAll() {
        CriteriaQuery<TeamManager> criteria = em.getCriteriaBuilder().createQuery(TeamManager.class);
        return em.createQuery(criteria.select(criteria.from(TeamManager.class))).getResultList();
    }
       
    @Override
    public TeamManager findByTeam(String teamName) {
        List<TeamManager> teamManagerList = em.createQuery(
                "SELECT t.teamManager FROM Team t WHERE t.name = :teamName", TeamManager.class)
                    .setParameter("teamName", teamName)
                    .getResultList();
        if (teamManagerList.isEmpty()) 
            return null;
        else 
            return teamManagerList.get(0);
    }
    
    @Override
    public List<TeamManager> findByName(String name) {
        return em.createQuery(
                "SELECT tm FROM TeamManager tm WHERE tm.name = :name", TeamManager.class)
                    .setParameter("name", name)
                    .getResultList();
    }

    @Override
    public List<Team> getAllTeams(TeamManager tm) {
        return em.createQuery(
                "SELECT t FROM Team t WHERE t.teamManager.id = :teamManagerId", Team.class)
                    .setParameter("teamManagerId", tm.getId())
                    .getResultList();
    }

}
