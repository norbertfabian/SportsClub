package cz.muni.fi.pa165.sportsclub.facade;

import java.util.List;

import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;

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
     * Updates membership data, when Team and Player stays the same. Usable when pulling data from one instance
     * to the new. Because of lazy fetching updateMembership(MembershipDto dto) is not working properly
     *
     * @param dto MembershipDto with the updated data
     * @param oldMembershipId Old membership id to be pulled from database
     */
    void updateMembership(MembershipDto dto, long oldMembershipId);

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

    /**
     * Returns all memberships assigned to player
     *
     * @param id Id of Player
     * @return List of all memberships assigned to player
     */
    List<MembershipDto> getAllMembershipsForPlayer(long id);

    /**
     * Returns all memberships assigned to team
     *
     * @param id Id of Team
     * @return List of all memberships assigned to team
     */
    List<MembershipDto> getAllMembershipsForTeam(long id);

    /**
     * Returns all available teams for player
     *
     * @param id Id of Player
     * @return List of all available teams for player
     */
    List<TeamDto> getAllAvailableTeamsForPlayer(long id);

}
