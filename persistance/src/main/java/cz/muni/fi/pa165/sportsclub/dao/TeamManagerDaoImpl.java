/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marian Sulgan
 */
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
    
}
