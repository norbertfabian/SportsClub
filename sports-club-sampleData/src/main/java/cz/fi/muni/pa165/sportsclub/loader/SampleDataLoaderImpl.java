package cz.fi.muni.pa165.sportsclub.loader;

import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.entity.*;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import cz.muni.fi.pa165.sportsclub.service.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Fabian Norbert
 */

@Component
@Transactional
public class SampleDataLoaderImpl implements SampleDataLoader {

    @Inject
    private TeamService teamService;

    @Inject
    private PlayerService playerService;

    @Inject
    private TeamManagerService teamManagerService;

    @Inject
    private MembershipService membershipService;

    @Inject
    private UserService userService;

    @Override
    public void loadData() throws IOException, ParseException {
        //TEAMS
        Team team1 = new Team().setName("Team1").setAgeGroup(AgeGroup.JUNIOR);
        Team team2 = new Team().setName("Team2").setAgeGroup(AgeGroup.SENIOR);
        TeamDto team = new TeamDto();
        team.setName("Team3");

        //TEAM MANAGERS
        TeamManager teamManager1 = new TeamManager().setName("Chuck Norris").setAddress("World")
                .setContact("chuck.norris@norris.com");
        TeamManager teamManager2 = new TeamManager().setName("Norbert Fabian").setAddress("Brno, Botanicka 15")
                .setContact("MyPersonalEmail@gmail.com");

        //PLAYERS
        Player player1 = new Player().setFirstName("Norbert").setLastName("Fabian").setHeight(190).setWeight(110)
                .setDateOfBirth(createDate("03/08/2005"));
        Player player2 = new Player().setFirstName("David").setLastName("Foser").setHeight(183).setWeight(98)
                .setDateOfBirth(createDate("15/01/2007"));
        Player player3 = new Player().setFirstName("Roland").setLastName("Keen").setHeight(1730).setWeight(85)
                .setDateOfBirth(createDate("28/02/1963"));
        Player player4 = new Player().setFirstName("Frank").setLastName("Kuzo").setHeight(195).setWeight(112)
                .setDateOfBirth(createDate("02/10/1950"));
        Player player5 = new Player().setFirstName("Adam").setLastName("Rezen").setHeight(166).setWeight(80)
                .setDateOfBirth(createDate("02/10/1950"));
        Player player6 = new Player().setFirstName("Jozef").setLastName("Salat").setHeight(167).setWeight(89)
            .setDateOfBirth(createDate("04/12/1959"));

        PlayerDto player = new PlayerDto();
        player.setFirstName("Norbert");
        player.setLastName("Fabian");
        player.setHeight(190);
        player.setWeight(110);
        player.setDateOfBirth(createDate("03/08/2005"));

        //MEMBERSHIPS
        Membership membership1 = new Membership().setTeam(team1).setPlayer(player1).setJerseyNumber(1);
        Membership membership2 = new Membership().setTeam(team1).setPlayer(player2).setJerseyNumber(7);
        Membership membership3 = new Membership().setTeam(team2).setPlayer(player3).setJerseyNumber(10);
        Membership membership4 = new Membership().setTeam(team2).setPlayer(player4).setJerseyNumber(8);

        //ASSIGNING
        team1.setTeamManager(teamManager1);
        team2.setTeamManager(teamManager2);
        teamManager1.addTeam(team1);
        teamManager2.addTeam(team2);
        team1.setTeamManager(teamManager1);
        team2.setTeamManager(teamManager2);
        team1.addMembership(membership1);
        team1.addMembership(membership2);
        team2.addMembership(membership3);
        team2.addMembership(membership4);
        teamManager1.addTeam(team1);
        teamManager2.addTeam(team2);
        player1.addMembership(membership1);
        player2.addMembership(membership2);
        player3.addMembership(membership3);
        player4.addMembership(membership4);

        //PERSISTING
        teamManagerService.createTeamManager(teamManager1);
        teamManagerService.createTeamManager(teamManager2);
        teamService.createTeam(team1);
        teamService.createTeam(team2);
        playerService.createPlayer(player1);
        playerService.createPlayer(player2);
        playerService.createPlayer(player3);
        playerService.createPlayer(player4);
        playerService.createPlayer(player5);
        playerService.createPlayer(player6);
        membershipService.createMembership(membership1);
        membershipService.createMembership(membership2);
        membershipService.createMembership(membership3);
        membershipService.createMembership(membership4);

        User user = new User().setUsername("user").setPassword("user").setRole("USER");
        User admin = new User().setUsername("admin").setPassword("admin").setRole("ROLE");
        userService.create(user);
        userService.create(admin);
    }

    /**
     * Creates Date instance from the given string
     *
     * @param date
     * @return
     * @throws ParseException
     */
    private Date createDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(date);
    }

}
