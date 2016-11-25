package cz.muni.fi.pa165.sportsclub.service.impl;

import java.util.List;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.dao.MembershipDao;
import cz.muni.fi.pa165.sportsclub.entity.Membership;
import cz.muni.fi.pa165.sportsclub.service.MembershipService;
import org.springframework.stereotype.Service;

/**
 * @author Jakub Smolar
 */
@Service
public class MembershipServiceImpl implements MembershipService {

    @Inject
    MembershipDao membershipDao;

    @Override
    public void createMembership(Membership membership) {
        membershipDao.create(membership);
    }

    @Override
    public Membership updateMembership(Membership membership) {
        return membershipDao.update(membership);
    }

    @Override
    public void removeMembership(Membership membership) {
        membershipDao.remove(membership);
    }

    @Override
    public Membership findById(long id) {
        return membershipDao.findById(id);
    }

    @Override
    public List<Membership> findAll() {
        return membershipDao.findAll();
    }

}