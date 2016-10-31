package cz.muni.fi.pa165.sportsclub.dao;

import java.util.List;

import cz.muni.fi.pa165.sportsclub.entity.Membership;

/**
 * @author Jakub Smolar
 */
public interface MembershipDao {

    void create(Membership m);

    Membership update(Membership m);

    void remove(Membership m);

    List<Membership> findAll();

    Membership findById(Long id);

}
