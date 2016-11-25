package cz.muni.fi.pa165.sportsclub.service;

import java.util.List;

import cz.muni.fi.pa165.sportsclub.entity.Membership;
import org.springframework.stereotype.Service;

/**
 * @author Jakub Smolar
 */
@Service
public interface MembershipService {

    /**
     * Method creates new Membership
     *
     * @param membership Membership to create
     */
    void createMembership(Membership membership);

    /**
     * Updates membership
     *
     * @param membership Membership with the updated data
     * @return Updated membership
     */
    Membership updateMembership(Membership membership);

    /**
     * Removes membership
     * @param id Id of the membership to remove
     */
    void removeMembership(Membership membership);

    /**
     * Finds Membership by specified id
     *
     * @param id Id of the Membership
     * @return Return Membership with the given id
     */
    Membership findById(long id);

    /**
     * Returns all Memberships.
     *
     * @return List of all Memberships
     */
    List<Membership> findAll();

}