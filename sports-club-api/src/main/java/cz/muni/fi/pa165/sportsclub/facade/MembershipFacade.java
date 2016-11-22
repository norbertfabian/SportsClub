package cz.muni.fi.pa165.sportsclub.facade;

import java.util.List;

import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;

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
    void deleteMembership(long id);

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
    List<TeamDto> findAllMemberships();

    /**
     * Returns a membership with the specified id.
     *
     * @param id Id of the membership
     * @return Membership with the given id
     */
    TeamDto getMembership(long id);

}
