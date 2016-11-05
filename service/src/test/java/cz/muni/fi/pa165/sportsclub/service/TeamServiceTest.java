package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import org.hibernate.service.spi.ServiceException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.mockito.InjectMocks;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import javax.inject.Inject;

/**
 * Created by norbert on 5.11.16.
 */

@ContextConfiguration(classes = SpringContextConfiguration.class)
public class TeamServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Mock
    TeamDao teamDao;

    @Inject
    @InjectMocks
    TeamService teamService;

    EntityFactoryService entityFactoryService = new EntityFactoryService();

    @BeforeClass
    public void setUpClass() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByIdTeamTest() {
        Mockito.when(teamDao.findById(Mockito.anyLong()))
                .thenReturn(entityFactoryService.createTeam());

        Team result = teamService.findById(1L);

        Mockito.verify(teamDao, Mockito.times(1)).create(Mockito.any());
        Assert.assertNotNull(result);
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

        teamService.removeTeam(team);

        Mockito.verify(teamDao, Mockito.times(1)).remove(Mockito.any());
    }
}
