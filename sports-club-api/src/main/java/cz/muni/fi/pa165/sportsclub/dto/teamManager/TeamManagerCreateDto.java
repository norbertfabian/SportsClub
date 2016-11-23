package cz.muni.fi.pa165.sportsclub.dto.teamManager;

import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marian Sulgan
 */


public class TeamManagerCreateDto {
    
    @NotNull
    @Size(min = 2, max = 80)
    private String name;

    @NotNull
    @Size(min = 2, max = 200)
    private String address;

    @NotNull
    @Size(min = 2, max = 60)
    private String contact;
    
    private List<TeamDto> teams;
    
    public TeamManagerCreateDto() {
        
    }

    public TeamManagerCreateDto(TeamManagerDto dto) {
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.contact = dto.getContact();
        this.teams = Collections.unmodifiableList(dto.getTeams());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDto> teams) {
        this.teams = teams;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        
        if ((o == null) || !(o instanceof TeamManagerCreateDto)) 
            return false;

        TeamManagerCreateDto tmCreateDto = (TeamManagerCreateDto) o;

        return getTeams().equals(tmCreateDto.getTeams());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.getName());
        hash = 47 * hash + Objects.hashCode(this.getContact());
        hash = 47 * hash + Objects.hashCode(this.getAddress());
        hash = 47 * hash + Objects.hashCode(this.getTeams().size());
        return hash;
    }
    
    @Override
    public String toString() {
        return "TeamManagerCreateDto{" +
                "name=" + name + 
                ", address=" + address + 
                ", contact=" + contact + 
                ", teamsCount=" + teams.size() + 
                '}';
    }
    
}
