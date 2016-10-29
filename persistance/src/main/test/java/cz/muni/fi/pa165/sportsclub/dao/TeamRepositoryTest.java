package cz.muni.fi.pa165.sportsclub.dao;


import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.PersistenceSampleApplicationContext;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by norbert on 24.10.16.
 */

@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class TeamRepositoryTest extends AbstractTestNGSpringContextTests {

    @Inject
    private TeamDao teamDao;

    @Test
    public void createTest() {
        Team team = new Team();
        team.setName("Team");
        teamDao.create(team);
        Assert.assertEquals(1L, team.getId());
    }
}