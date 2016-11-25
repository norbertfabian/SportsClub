package cz.muni.fi.pa165.sportsclub.mapper;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dto.ageGroup.AgeGroupDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Inject;

/**
 * Created by norbert on 20.11.16.
 */
@ContextConfiguration(classes = SpringContextConfiguration.class)
public class DtoMapperTest extends AbstractTransactionalTestNGSpringContextTests {

    @Inject
    private DtoMapper dtoMapper;

    private static EntityFactoryService entityFactoryService = new EntityFactoryService();

    @Test
    public void teamToDtoTest() {
        Team team = entityFactoryService.createTeam();

        TeamDto dto = dtoMapper.teamToDto(team);

        Assert.assertNotNull(dto);
        Assert.assertEquals(dto.getId(), team.getId());
        Assert.assertEquals(dto.getName(), team.getName());
        Assert.assertEquals(dto.getAgeGroupLabel(), team.getAgeGroup().getLabel());
    }

    @Test
    public void dtoToTeamTest() {
        TeamDto teamDto = entityFactoryService.createTeamDto();

        Team team = dtoMapper.dtoToTeam(teamDto);

        Assert.assertNotNull(team);
        Assert.assertEquals(team.getName(), teamDto.getName());
        Assert.assertEquals(team.getAgeGroup(), AgeGroup.getByLabel(teamDto.getAgeGroupLabel()));
    }

    @Test
    public void mapToTest() {
        AgeGroup ageGroup = AgeGroup.JUNIOR;
        AgeGroupDto dto = new AgeGroupDto();

        dtoMapper.mapTo(ageGroup, dto);

        Assert.assertEquals(dto.getLabel(), ageGroup.getLabel());
        Assert.assertEquals(dto.getAgeFrom(), ageGroup.getAgeFrom());
        Assert.assertEquals(dto.getAgeTo(), ageGroup.getAgeTo());
    }
    
    @Test
    public void teamManagerToDtoTest() {
        TeamManager tm = entityFactoryService.createTeamManager();
        TeamManagerDto tmDto = dtoMapper.teamManagerToDto(tm);
        
        Assert.assertNotNull(tmDto);
        Assert.assertEquals(tm.getId(), tmDto.getId());
        Assert.assertEquals(tm.getName(), tmDto.getName());
        Assert.assertEquals(tm.getContact(), tmDto.getContact());
        Assert.assertEquals(tm.getAddress(), tmDto.getAddress());
    }
    
    @Test
    public void dtoToTeamManager() {
        TeamManagerDto tmDto = entityFactoryService.createTeamManagerDto();
        TeamManager tm = dtoMapper.dtoToTeamManager(tmDto);
        
        Assert.assertNotNull(tm);
        Assert.assertEquals(tm.getName(), tmDto.getName());
        Assert.assertEquals(tm.getContact(), tmDto.getContact());
        Assert.assertEquals(tm.getAddress(), tmDto.getAddress());
    }
}
