package cz.muni.fi.pa165.sportsclub.facade;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.entity.Membership;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import cz.muni.fi.pa165.sportsclub.service.MembershipService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by jsmolar on 11/25/16.
 */
public class MembershipFacadeTest {

    @Mock
    private MembershipService membershipService;

    @Mock
    private DtoMapper dtoMapper;

    @InjectMocks
    private MembershipFacade membershipFacade = new MembershipFacadeImpl();

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    private MembershipDto membershipDto;

    private Membership m1;

    @BeforeMethod
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        membershipDto = entityFactoryService.createMembershipDto();
        m1 = entityFactoryService.createMembership();
        m1.setId(1L);
    }

    @Test
    public void testCreateMembership(){
        membershipFacade.createMembership(membershipDto);
        Membership m = dtoMapper.mapTo(membershipDto, Membership.class);

        verify(membershipService).createMembership(m);
    }

    @Test
    public void testUpdateMembership(){
        membershipDto.setId(13L);
        membershipDto.setJerseyNumber(99);

        Membership m = dtoMapper.mapTo(membershipDto, Membership.class);
        membershipFacade.updateMembership(membershipDto);
        verify(membershipService).updateMembership(m);
    }

    @Test
    public void testDeleteMembership(){
        Membership m = dtoMapper.mapTo(membershipDto, Membership.class);
        membershipFacade.deleteMembership(membershipDto);
        verify(membershipService).removeMembership(m);
    }

    @Test
    public void testFindById(){
        Membership m = dtoMapper.mapTo(membershipDto, Membership.class);

        when(membershipService.findById(membershipDto.getId())).thenReturn(m);
        when(dtoMapper.mapTo(m, MembershipDto.class)).thenReturn(membershipDto);
        MembershipDto s = membershipFacade.findMembership(membershipDto.getId());

        verify(membershipService).findById(membershipDto.getId());
        verify(dtoMapper).mapTo(m, MembershipDto.class);
    }

    @Test
    public void testFindAll(){
        List<Membership> memberships = new ArrayList<>();
        memberships.add(entityFactoryService.createMembership("membership1"));
        memberships.add(entityFactoryService.createMembership("membership2"));
        when(membershipService.findAll()).thenReturn(memberships);

        membershipFacade.findAllMemberships();

        verify(membershipService).findAll();
    }

}
