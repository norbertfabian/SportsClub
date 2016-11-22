package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import cz.muni.fi.pa165.sportsclub.service.TeamManagerService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marian Sulgan
 */

@Transactional
@Service
public class TeamManagerFacadeImpl implements TeamManagerFacade {
    
    @Inject
    private DtoMapper dtoMapper;

    @Inject
    private TeamManagerService tmService;

    @Override
    public void createTeamManager(TeamManagerCreateDto dto) {
        TeamManager tm = dtoMapper.dtoToTeamManager(dto);
        tmService.createTeamManager(tm);
    }

    @Override
    public void deleteTeamManager(long id) {
        tmService.removeTeamManager(id);
    }

    @Override
    public void updateTeamManager(TeamManagerDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TeamManagerDto getTeamManager(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TeamManagerDto> getAllTeamManagers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
