package cz.muni.fi.pa165.sportsclub.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.muni.fi.pa165.sportsclub.entity.Membership;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jakub Smolar
 */
@Repository
@Transactional
public class MembershipDaoImpl implements MembershipDao {

    @PersistenceContext
    EntityManager em;

    public void create(Membership m) {
        em.persist(m);
    }

    public Membership update(Membership m) {
        return em.merge(m);
    }

    public void remove(Membership m) {
        em.remove(findById(m.getId()));
    }

    public List<Membership> findAll() {
        return em.createQuery("SELECT m FROM Membership m", Membership.class).getResultList();
    }

    public Membership findById(Long id) {
        return em.find(Membership.class, id);
    }

}
