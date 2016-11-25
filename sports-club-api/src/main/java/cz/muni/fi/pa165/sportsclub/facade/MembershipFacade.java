package cz.muni.fi.pa165.sportsclub.facade;

import java.util.List;

import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;

/**
 * Created by jsmolar on 11/22/16.
 */
public interface MembershipFacade {

    /**
     * Creates a new membership.
     *
     * @param dto MembershipDto with the membership data
     */
    void createMembership(MembershipCreateDto dto);

    /**
     * Deletes a membership with the given id.
     *
     * @param id Id of the membership to delete
     */
    void deleteMembership(MembershipDto dto);

    /**
     * Updates the membership data.
     *
     * @param dto MembershipDto with the updated data
     */
    void updateMembership(MembershipDto dto);

    /**
     * Returns a list of all memberships.
     *
     * @return List of all memberships
     */
    List<MembershipDto> findAllMemberships();

    /**
     * Returns a membership with the specified id.
     *
     * @param id Id of the membership
     * @return Membership with the given id
     */
    MembershipDto findMembership(long id);

}
