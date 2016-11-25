package cz.muni.fi.pa165.sportsclub.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.dao.MembershipDao;
import cz.muni.fi.pa165.sportsclub.entity.Membership;
import cz.muni.fi.pa165.sportsclub.service.impl.MembershipServiceImpl;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Jakub Smolar
 */
public class MembershipServiceTest {

    @Mock
    private MembershipDao membershipDao;

    @InjectMocks
    private  MembershipService membershipService = new MembershipServiceImpl();

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    private Membership membership1;
    private Membership membership2;

    @BeforeClass
    public void setUpClass() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void setUp(){
        membership1 = entityFactoryService.createMembership("testMembership1");
        membership2 = entityFactoryService.createMembership("testMembership2");
    }

    @Test
    public void testCreateMembership() {
        membershipService.createMembership(membership1);

        verify(membershipDao).create(membership1);
    }

    @Test
    public void testUpdateMembership(){
        membership1.setJerseyNumber(membership1.getJerseyNumber() + 10);
        membershipService.updateMembership(membership1);

        verify(membershipDao).update(membership1);
    }

    @Test
    public void testDeleteMembership(){
        membershipService.removeMembership(membership2);

        verify(membershipDao).remove(membership2);
    }

    @Test
    public void testFindById(){
        membership1.setId(13L);
        when(membershipService.findById(membership1.getId())).thenReturn(membership1);

        Membership result = membershipService.findById(membership1.getId());

        verify(membershipDao).findById(membership1.getId());
        assertNotNull(result);
    }

    @Test
    public void testFindByIdNotExisting() {
        when(membershipDao.findById(Long.MIN_VALUE)).thenReturn(null);
        assertNull(membershipService.findById(Long.MIN_VALUE));
    }

    @Test
    public void testFindAll(){
        when(membershipDao.findAll()).thenReturn(new ArrayList<>());
        assertEquals(membershipService.findAll().size(), 0);

        when(membershipDao.findAll()).thenReturn(Collections.singletonList(membership1));
        assertEquals(membershipService.findAll().size(), 1);

        when(membershipDao.findAll()).thenReturn(Arrays.asList(membership1, membership2));
        assertEquals(membershipService.findAll().size(), 2);
    }

}
