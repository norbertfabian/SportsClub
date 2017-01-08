package cz.muni.fi.pa165.sportsclub.dao;

import java.util.List;

import cz.muni.fi.pa165.sportsclub.entity.Membership;

/**
 * DAO interface prescribing operations for Membership entity.
 * 
 * @author Jakub Smolar
 */
public interface MembershipDao {

    /**
     * Persists Membership.
     * 
     * @param m to be created. 
     */
    void create(Membership m);

    /**
     * Updates changes of a Membership in the database.
     * 
     * @param m to be updated.
     * @return updated Membership. 
     */
    Membership update(Membership m);

    /**
     * Removes Membership.
     * 
     * @param m to be removed.
     */
    void remove(Membership m);

    /**
     * Returns all Memberships from the database.
     *
     * @return List of Memberships.
     */
    List<Membership> findAll();

    /**
     * Finds Membership by provided ID.
     * 
     * @param id ID of Membership.
     * @return Membership with provided ID.
     */
    Membership findById(long id);

}
