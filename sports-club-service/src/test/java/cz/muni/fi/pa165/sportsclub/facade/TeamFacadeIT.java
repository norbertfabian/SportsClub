package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by norbert on 19.11.16.
 */

@ContextConfiguration(classes = SpringContextConfiguration.class)
public class TeamFacadeIT extends AbstractTransactionalTestNGSpringContextTests {

    @Inject
    private TeamFacade teamFacade;

    @Inject
    private TeamDao teamDao;

    @Inject
    private DtoMapper dtoMapper;

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    @Test
    public void getTeamIT() {
        Team persistedTeam = entityFactoryService.createPersistedTeam(teamDao);

        TeamDto result = teamFacade.getTeam(persistedTeam.getId());

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getId(), persistedTeam.getId());
        Assert.assertEquals(result.getName(), persistedTeam.getName());
        Assert.assertEquals(result.getAgeGroupLabel(), persistedTeam.getAgeGroup().getLabel());
    }

    @Test
    public void createTeamIT() {
        TeamCreateDto teamCreateDto = entityFactoryService.createTeamCreateDto();

        teamFacade.createTeam(teamCreateDto);

        List<Team> allTeams = teamDao.getAll();
        Assert.assertTrue(allTeams.size() == 1);
        Team team = allTeams.get(0);
        Assert.assertNotNull(team.getId());
        Assert.assertEquals(teamCreateDto.getName(), team.getName());
        Assert.assertEquals(team.getAgeGroup(), AgeGroup.getByLabel(teamCreateDto.getAgeGroupLabel()));

    }

    @Test
    public void deleteTeamIT() {
        Team teamToDelete = entityFactoryService.createPersistedTeam(teamDao);

        teamFacade.deleteTeam(teamToDelete.getId());

        Assert.assertNull(teamDao.findById(teamToDelete.getId()));
    }

    @Test
    public void updateTeamIT() {
        Team persistedTeam = entityFactoryService.createPersistedTeam(teamDao);
        TeamDto updatedTeamDto = dtoMapper.teamToDto(persistedTeam, TeamDto.class);
        updatedTeamDto.setName("UpdatedName");
        updatedTeamDto.setAgeGroupLabel(AgeGroup.SENIOR.getLabel());

        teamFacade.updateTeam(updatedTeamDto);

        Team updateResult = teamDao.findById(persistedTeam.getId());
        Assert.assertEquals(updateResult.getName(), "UpdatedName");
        Assert.assertEquals(updateResult.getAgeGroup(), AgeGroup.SENIOR);
    }

    @Test
    public void getAllTeamsIT() {
        entityFactoryService.createPersistedTeam("Team1", teamDao);
        entityFactoryService.createPersistedTeam("Team2", teamDao);

        List<TeamDto> result = teamFacade.getAllTeams();

        Assert.assertEquals(result.size(), 2);
        Assert.assertTrue(result.get(0) instanceof  TeamDto);
        Assert.assertTrue(result.get(1) instanceof  TeamDto);
        Assert.assertEquals(result.get(0).getName(), "Team1");
        Assert.assertEquals(result.get(1).getName(), "Team2");
        Assert.assertEquals(result.get(0).getAgeGroupLabel(), AgeGroup.JUNIOR.getLabel());
        Assert.assertEquals(result.get(1).getAgeGroupLabel(), AgeGroup.JUNIOR.getLabel());
    }
}
