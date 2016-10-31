/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.EntityFactory;
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
    
    private final EntityFactory entityFactory = new EntityFactory();
    
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    
    private Team t1;
    private Team t2;
    
    @BeforeMethod
    public void createMemberships() {
        p1 = entityFactory.createPlayer("John", "Doe");
        p2 = entityFactory.createPlayer("Jack", "Foo");
        p3 = entityFactory.createPlayer("Lorem", "Ipsum");
        p4 = entityFactory.createPlayer("Dolor", "Sit");
        
        t1 = entityFactory.createTeam("team1");
        t2 = entityFactory.createTeam("team2");
    }
    
    @Test
    public void nullMembershipTest() {
        Membership m1 = entityFactory.createMembership(p1, t1, membershipDao);
        Membership m2 = entityFactory.createMembership(p2, t1, membershipDao);
        Assert.assertNull(membershipDao.findById(123456L));
    }
    
    @Test
    public void createMembershipTest() {
        Membership m1 = entityFactory.createMembership(p1, t1, membershipDao);
        Membership m2 = entityFactory.createMembership(p2, t1, membershipDao);
        Membership m3 = entityFactory.createMembership(p3, t2, membershipDao);
        Membership m4 = entityFactory.createMembership(p4, t2, membershipDao);
        
        Assert.assertEquals(membershipDao.findById(m1.getId()), m1);
        Assert.assertEquals(membershipDao.findById(m2.getId()), m2);
        Assert.assertEquals(membershipDao.findById(m3.getId()), m3);
        Assert.assertEquals(membershipDao.findById(m4.getId()), m4);
    }
    
    @Test (expectedExceptions = ConstraintViolationException.class)
    public void wrongJerseyNumberTest1() {
        Membership m = entityFactory.createMembership(p1, t1);
        m.setJerseyNumber(12345);
        membershipDao.create(m);
    }
    
    @Test (expectedExceptions = ConstraintViolationException.class)
    public void wrongJerseyNumberTest2() {
        Membership m = entityFactory.createMembership(p1, t1);
        m.setJerseyNumber(-123);
        membershipDao.create(m);
    }
    
    @Test void updateMembershipTest() {
        Membership m = entityFactory.createMembership(p1, t1, membershipDao);
        m.setJerseyNumber(42)
                .setPlayer(p3)
                .setTeam(t2);
        membershipDao.update(m);
        
        Membership persistedMem = membershipDao.findById(m.getId());
        
        Assert.assertEquals(persistedMem.getJerseyNumber(), m.getJerseyNumber());
        Assert.assertEquals(persistedMem.getPlayer(), m.getPlayer());
        Assert.assertEquals(persistedMem.getTeam(), m.getTeam());
    }
    
    @Test void deleteMemberShipTest() {
        Membership m1 = entityFactory.createMembership(p1, t1, membershipDao);
        Membership m2 = entityFactory.createMembership(p2, t1, membershipDao);
        Membership m3 = entityFactory.createMembership(p3, t2, membershipDao);
        Membership m4 = entityFactory.createMembership(p4, t2, membershipDao);
        
        membershipDao.remove(m3);
        
        Assert.assertNull(membershipDao.findById(m3.getId()));
        Assert.assertEquals(membershipDao.findById(m1.getId()), m1);
        Assert.assertEquals(membershipDao.findById(m2.getId()), m2);
        Assert.assertEquals(membershipDao.findById(m4.getId()), m4);
    }
    
}
