package cz.muni.fi.pa165.sportsclub.mapper;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public static Object[][] teamToDtoDataProvider() {
        return new Object[][] {
                {TeamDto.class},
                {TeamCreateDto.class}
        };
    }

    @Test(dataProvider = "teamToDtoDataProvider")
    public void teamToDtoTest(Class destinationClass) {
        Team team = entityFactoryService.createTeam();

        TeamCreateDto dto = dtoMapper.teamToDto(team, destinationClass);

        Assert.assertNotNull(dto);
        Assert.assertTrue(dto.getClass() == destinationClass);
        if(destinationClass.equals(TeamDto.class)) {
            Assert.assertEquals(((TeamDto) dto).getId(), team.getId());
        }
        Assert.assertEquals(dto.getName(), team.getName());
        Assert.assertEquals(dto.getAgeGroupLabel(), team.getAgeGroup().getLabel());
        Assert.assertEquals(dto.getAgeGroupLabelsList().size(), 6);
    }

    @DataProvider
    public static Object[][] dtoToTeamDataProvider() {
        return new Object[][] {
                {entityFactoryService.createTeamDto()},
                {entityFactoryService.createTeamCreateDto()}
        };
    }

    @Test(dataProvider = "dtoToTeamDataProvider")
    public void dtoToTeamTest(TeamCreateDto dto) {
        Team team = dtoMapper.dtoToTeam(dto);

        Assert.assertNotNull(team);
        if(dto instanceof TeamDto) {
            Assert.assertEquals(team.getId(), ((TeamDto) dto).getId());
        }
        Assert.assertEquals(team.getName(), dto.getName());
        Assert.assertEquals(team.getAgeGroup(), AgeGroup.getByLabel(dto.getAgeGroupLabel()));
    }
}
