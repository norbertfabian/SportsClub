package cz.muni.fi.pa165.sportsclub.facade;

import static org.testng.Assert.*;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.service.MembershipService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by jsmolar on 11/25/16.
 */
@ContextConfiguration(classes = SpringContextConfiguration.class)
public class MembershipFacadeIT extends AbstractTransactionalTestNGSpringContextTests {

    @Inject
    private MembershipFacade membershipFacade;

    @Inject
    private TeamFacade teamFacade;

    @Inject
    private PlayerFacade playerFacade;

    @Inject
    private MembershipService membershipService;

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    private TeamDto team1;

    private PlayerDto player1;

    private MembershipDto membership1;

    @BeforeMethod
    public void setUp(){
        team1 = entityFactoryService.createTeamDto("team1Dto");
        player1 = entityFactoryService.createPlayerDto("firstName1", "lastName1");
        teamFacade.createTeam(team1);
        playerFacade.createPlayer(player1);

        membership1 = entityFactoryService.createMembershipDto(team1, player1, 13);

        membershipFacade.createAndAssignMembership(membership1, getTeamId(team1), getPlayerId(player1));
        membership1.setTeam(team1);
        membership1.setPlayer(player1);
    }

    @Test
    public void createMembershipIT(){
        assertTrue(membershipFacade.findAllMemberships().contains(membership1));
    }

    @Test
    public void updateMembershipIT(){
        MembershipDto found = membershipFacade.findMembership(getMembershipId(membership1));
        int sizeBefore = membershipFacade.findAllMemberships().size();

        assertTrue(found.getJerseyNumber() == 13);
        found.setJerseyNumber(99);
        membershipFacade.updateMembership(found);
        assertEquals(sizeBefore, membershipFacade.findAllMemberships().size());
        assertTrue(membershipFacade.findMembership(found.getId()).getJerseyNumber() == 99);
    }

    private long getTeamId(TeamDto team){
        int index = teamFacade.getAllTeams().indexOf(team);
        return teamFacade.getAllTeams().get(index).getId();
    }

    private long getPlayerId(PlayerDto player){
        int index = playerFacade.getAllPlayers().indexOf(player);
        return playerFacade.getAllPlayers().get(index).getId();
    }

    private long getMembershipId(MembershipDto membership){
        int index = membershipFacade.findAllMemberships().indexOf(membership);
        return membershipFacade.findAllMemberships().get(index).getId();
    }
}
