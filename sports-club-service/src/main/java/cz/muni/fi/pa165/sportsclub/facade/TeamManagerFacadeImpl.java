package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import cz.muni.fi.pa165.sportsclub.service.TeamManagerService;
import java.util.ArrayList;
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
        TeamManager tm = dtoMapper.dtoToTeamManager(dto);
        tmService.updateTeamManager(tm);
    }

    @Override
    public TeamManagerDto getTeamManager(long id) {
        TeamManager tm = tmService.findById(id);
        return dtoMapper.teamManagerToDto(tm, TeamManagerDto.class);
    }

    @Override
    public List<TeamManagerDto> getAllTeamManagers() {
        List<TeamManager> tms = tmService.getAll();
        List<TeamManagerDto> dtos = new ArrayList<>();
        
        tms.forEach((TeamManager tm) -> {
            dtos.add(dtoMapper.teamManagerToDto(tm, TeamManagerDto.class));
        });
        
        return dtos;
    }
    
}
