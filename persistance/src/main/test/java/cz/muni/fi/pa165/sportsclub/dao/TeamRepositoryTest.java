package cz.muni.fi.pa165.sportsclub.dao;


import cz.muni.fi.pa165.sportsclub.PersistenceSampleApplicationContext;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;

import javax.inject.Inject;

/**
 * Created by norbert on 24.10.16.
 */

@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class TeamRepositoryTest extends AbstractTestNGSpringContextTests {


    private TeamDao teamDao;

    @BeforeMethod
    public void setUp() {
        teamDao = applicationContext.getBean(TeamDaoImpl.class);
    }

    @Test
    public void createTest() {
        Team team = new Team();
        team.setId(1);
        team.setName("Team");
        teamDao.create(team);
    }
}
