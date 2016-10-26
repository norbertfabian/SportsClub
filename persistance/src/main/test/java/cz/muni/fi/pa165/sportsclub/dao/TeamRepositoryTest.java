package cz.muni.fi.pa165.sportsclub.dao;


import cz.muni.fi.pa165.sportsclub.PersistenceSampleApplicationContext;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by norbert on 24.10.16.
 */

@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TeamRepositoryTest extends AbstractTestNGSpringContextTests {

    @Inject
    private TeamDao teamDao;

    @Test
    public void createTest() {
        Team team = new Team();
        team.setName("Team");
        teamDao.create(team);
        Assert.assertEquals("CreateTest Team failed. Id was not assigned", 1L, team.getId());
    }
}
