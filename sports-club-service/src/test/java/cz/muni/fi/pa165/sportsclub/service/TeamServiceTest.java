package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import cz.muni.fi.pa165.sportsclub.service.impl.TeamServiceImpl;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Fabian Norbert
 */

public class TeamServiceTest {

    @Mock
    private TeamDao teamDao;

    @InjectMocks
    private TeamService teamService = new TeamServiceImpl();

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    @BeforeClass
    public void setUpClass() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByIdTeamTest() {
        Mockito.when(teamDao.findById(Mockito.anyLong()))
                .thenReturn(entityFactoryService.createTeam());

        Team result = teamService.findById(1L);

        Mockito.verify(teamDao, Mockito.times(1)).findById(Mockito.anyLong());
        Assert.assertNotNull(result);
    }

    @Test
    public void getAllTest() {
        List<Team> toReturn = new ArrayList<>();
        toReturn.add(entityFactoryService.createTeam());
        Mockito.when(teamDao.getAll()).thenReturn(toReturn);

        List<Team> result = teamService.getAll();

        Mockito.verify(teamDao, Mockito.times(1)).getAll();
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void createTeamTest() {
        teamService.createTeam(entityFactoryService.createTeam());

        Mockito.verify(teamDao, Mockito.times(1)).create(Mockito.any());
    }

    @Test
    public void updateTeamTest() {
        Team team = entityFactoryService.createTeam();
        Mockito.when(teamDao.update(Mockito.any())).thenReturn(team);

        Team result = teamService.updateTeam(team);

        Mockito.verify(teamDao, Mockito.times(1)).update(Mockito.any());
        Assert.assertEquals(team, result);
    }

    @Test
    public void removeTeamTest() {
        Team team = entityFactoryService.createTeam();

        teamService.removeTeam(team.getId());

        Mockito.verify(teamDao, Mockito.times(1)).remove(Mockito.anyLong());
    }
}
