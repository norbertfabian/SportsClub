package cz.muni.fi.pa165.sportsclub.service;

import static org.testng.Assert.*;

import java.util.List;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dao.MembershipDao;
import cz.muni.fi.pa165.sportsclub.entity.Membership;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Jakub Smolar
 */
@ContextConfiguration(classes = SpringContextConfiguration.class)
public class MembershipServiceIT extends AbstractTransactionalTestNGSpringContextTests {

    @Inject
    private MembershipDao membershipDao;

    @Inject
    private MembershipService membershipService;

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    private Membership membership;

    @BeforeMethod
    public void setUp(){
        membership = entityFactoryService.createPersistedMembership(membershipDao);
    }

    @Test
    public void createMembershipIT(){
        Membership membership1 = entityFactoryService.createMembership();
        membershipService.createMembership(membership1);

        assertNotNull(membershipDao.findById(membership1.getId()));
    }

    @Test
    public void updateMembershipIT(){
        membership.setJerseyNumber(99);
        Membership result = membershipService.updateMembership(membership);
        assertNotNull(result);
        assertEquals(99 , membershipDao.findById(membership.getId()).getJerseyNumber());
    }

    @Test
    public void removeTeamIT() {
        membershipService.removeMembership(membership);
        assertNull(membershipDao.findById(membership.getId()));
    }

    @Test
    public void findByIdIT() {
        assertNotNull(membershipService.findById(membership.getId()));
    }

    @Test
    void getAllIT() {
        Membership membership1 = entityFactoryService.createPersistedMembership("membership1", membershipDao);

        List<Membership> result = membershipDao.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(membership));
        assertTrue(result.contains(membership1));
    }
}
