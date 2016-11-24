package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dao.TeamManagerDao;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
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
    
    private EntityFactoryService entityFactoryService = new EntityFactoryService();
 
    @Test
    public void createTeamManagerIT() {
        TeamManagerDto dto = entityFactoryService.createTeamManagerDto();
        
        tmFacade.createTeamManager(dto);
        
        List<TeamManager> tms = tmDao.getAll();
        TeamManager test = tms.get(0);
        Assert.assertEquals(test.getName(), dto.getName());
    }
    
    @Test
    public void deleteTeamManagerIT() {
    }
    
    @Test
    public void updateTeamManagerIT() {
    }
    
    @Test
    public void getTeamManagerIT() {
        TeamManager tm = entityFactoryService.createPersistedTeamManager("TestName", tmDao);
        
        TeamManagerDto dto = tmFacade.getTeamManager(tm.getId());
        
        Assert.assertEquals(tm, dtoMapper.dtoToTeamManager(dto));
    }
    
}
