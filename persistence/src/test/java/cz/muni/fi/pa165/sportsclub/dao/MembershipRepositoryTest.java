package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.EntityFactoryPersistence;
import cz.muni.fi.pa165.sportsclub.PersistenceSampleApplicationContext;
import cz.muni.fi.pa165.sportsclub.entity.Membership;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Marian Sulgan
 */

@ContextConfiguration(classes=PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class MembershipRepositoryTest extends AbstractTestNGSpringContextTests {
    
    @Inject
    private MembershipDao membershipDao;
    
    @Inject
    private TeamDao teamDao;
    
    @Inject
    private PlayerDao playerDao;
    
    private final EntityFactoryPersistence entityFactoryPersistence = new EntityFactoryPersistence();
    
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    
    private Team t1;
    private Team t2;
    
    @BeforeMethod
    public void setUp() {
        p1 = entityFactoryPersistence.createPlayer("John", "Doe");
        p2 = entityFactoryPersistence.createPlayer("Jack", "Foo");
        p3 = entityFactoryPersistence.createPlayer("Lorem", "Ipsum");
        p4 = entityFactoryPersistence.createPlayer("Dolor", "Sit");
        
        t1 = entityFactoryPersistence.createTeam("team1");
        t2 = entityFactoryPersistence.createTeam("team2");
    }
    
    @Test
    public void shouldCreateMembership() {
        Membership m1 = entityFactoryPersistence.createMembership(p1, t1, membershipDao);
        Assert.assertEquals(membershipDao.findById(m1.getId()), m1);
    }
    
    @Test (expectedExceptions = ConstraintViolationException.class)
    public void shouldNotCreateMembershipTooBigNumber() {
        Membership m = entityFactoryPersistence.createMembership(p1, t1);
        m.setJerseyNumber(12345);
        membershipDao.create(m);
    }
    
    @Test (expectedExceptions = ConstraintViolationException.class)
    public void shouldNotCreateMembershipNegativeNumber() {
        Membership m = entityFactoryPersistence.createMembership(p1, t1);
        m.setJerseyNumber(-123);
        membershipDao.create(m);
    }
    
    @Test 
    public void shouldUpdateMembership() {
        Membership m = entityFactoryPersistence.createMembership(p1, t1, membershipDao);
        m.setJerseyNumber(42)
                .setPlayer(p3)
                .setTeam(t2);
        membershipDao.update(m);
        
        Membership persistedMem = membershipDao.findById(m.getId());
        
        Assert.assertEquals(persistedMem.getJerseyNumber(), m.getJerseyNumber());
        Assert.assertEquals(persistedMem.getPlayer(), m.getPlayer());
        Assert.assertEquals(persistedMem.getTeam(), m.getTeam());
    }
    
    @Test 
    public void shouldDeleteMembership() {
        Membership m1 = entityFactoryPersistence.createMembership(p1, t1, membershipDao);
        Membership m2 = entityFactoryPersistence.createMembership(p2, t1, membershipDao);
        Membership m3 = entityFactoryPersistence.createMembership(p3, t2, membershipDao);
        
        membershipDao.remove(m2);
        
        Assert.assertNull(membershipDao.findById(m2.getId()));
        Assert.assertEquals(membershipDao.findById(m1.getId()), m1);
        Assert.assertEquals(membershipDao.findById(m3.getId()), m3);
    }
    
    @Test 
    public void shouldFindAllMemberships() {
        entityFactoryPersistence.createMembership(p1, t1, membershipDao);
        entityFactoryPersistence.createMembership(p2, t1, membershipDao);
        entityFactoryPersistence.createMembership(p3, t2, membershipDao);
        Assert.assertEquals(3, membershipDao.findAll().size());
    }
    
}
