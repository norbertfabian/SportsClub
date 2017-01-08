package cz.muni.fi.pa165.sportsclub.facade;

import java.util.List;

import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;

/**
 * @author Jakub Smolar
 */
public interface MembershipFacade {

    /**
     * Creates a new membership.
     *
     * @param dto MembershipDto with the membership data
     */
    void createMembership(MembershipDto dto);

    /**
     * Deletes a membership with the given id.
     *
     * @param dto Membership dto to be deleted
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

    /**
     * Create a new membership with assigned team and player
     *
     * @param dto MembershipDto with the membership data
     * @param teamId Id of assigned team
     * @param playerId Id of assigned player
     */
    void createAndAssignMembership(MembershipDto dto, long teamId, long playerId);

}
