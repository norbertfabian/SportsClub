package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dao.TeamDao;
import cz.muni.fi.pa165.sportsclub.dao.TeamManagerDao;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Marian Sulgan
 */
@ContextConfiguration(classes = SpringContextConfiguration.class)
public class TeamManagerFacadeIT extends AbstractTransactionalTestNGSpringContextTests {
    
    @Inject
    private TeamManagerFacade tmFacade;
    
    @Inject
    private TeamManagerDao tmDao;
    
    @Inject
    private DtoMapper dtoMapper;
    
    @Inject
    private TeamDao teamDao;
    
    private EntityFactoryService entityFactoryService = new EntityFactoryService();
 
    @Test
    public void createTeamManagerIT() {
        TeamManagerDto tmDto = entityFactoryService.createTeamManagerDto();
        
        tmFacade.createTeamManager(tmDto);
        
        Assert.assertEquals(tmDao.getAll().size(), 1);
        TeamManager tm = tmDao.getAll().get(0);
        Assert.assertNotNull(tm.getId());
        Assert.assertEquals(tm.getName(), tmDto.getName());
        Assert.assertEquals(tm.getAddress(), tmDto.getAddress());
        Assert.assertEquals(tm.getContact(), tmDto.getContact());
    }
    
    @Test
    public void deleteTeamManagerIT() {
        TeamManager tm = entityFactoryService.createPersistedTeamManager("Test", tmDao);
        
        tmFacade.deleteTeamManager(tm.getId());
        
        Assert.assertNull(tmDao.findById(tm.getId()));
    }
    
    @Test
    public void updateTeamManagerIT() {
        TeamManager tm = entityFactoryService.createPersistedTeamManager("TestName", tmDao);
        TeamManagerDto tmDto = dtoMapper.teamManagerToDto(tm);
        tmDto.setAddress("TestAddress2");
        
        tmFacade.updateTeamManager(tmDto);
        
        Assert.assertEquals(tmDao.findById(tmDto.getId()).getAddress(), "TestAddress2");
    }
    
    @Test
    public void getTeamManagerIT() {
        TeamManager tm = entityFactoryService.createPersistedTeamManager("TestName", tmDao);
        
        TeamManagerDto dto = tmFacade.getTeamManager(tm.getId());
        
        Assert.assertEquals(tm, dtoMapper.dtoToTeamManager(dto));
    }
    
    @Test
    public void getAllTeamManagersTest() {
        TeamManager tm = entityFactoryService.createPersistedTeamManager("TestName1", tmDao);
        TeamManager tm2 = entityFactoryService.createPersistedTeamManager("TestName2", tmDao);
        
        List<TeamManagerDto> dtos = tmFacade.getAllTeamManagers();
        
        Assert.assertEquals(dtos.size(), 2);
        Assert.assertEquals(dtos.get(0).getName(), "TestName1");
        Assert.assertEquals(dtos.get(1).getName(), "TestName2");
    }
    
    @Test
    public void removeTeamFromTeamManagerTest() {
        TeamManager tm = entityFactoryService.createPersistedTeamManager("TestName1", tmDao);
        
        Team team1 = entityFactoryService.createPersistedTeam("TestTeam1", teamDao);
        Team team2 = entityFactoryService.createPersistedTeam("TestTeam2", teamDao);
        tm.addTeam(team1);
        tm.addTeam(team2);
        
        List<Team> teams = new ArrayList<>(tm.getTeams());
        
        Assert.assertEquals(teams.size(), 2);
        
        TeamManagerDto tmDto = tmFacade.getTeamManager(tm.getId());
        
        Assert.assertEquals(tmDto.getName(), tm.getName());
        
        Assert.assertEquals(tmFacade.getTeamManager(tm.getId()).getTeams().size(), 2);
        
        tmFacade.removeTeamFromTeamManager(tm.getId(), team1.getId());
        
        Assert.assertEquals(tmFacade.getTeamManager(tm.getId()).getTeams().size(), 1);
        Assert.assertEquals(tmFacade.getTeamManager(tm.getId()).getTeams().get(0).getName(), team2.getName());
    }
    
}
