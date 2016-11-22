package cz.muni.fi.pa165.sportsclub.dto.teamManager;

import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marian Sulgan
 */


public class TeamManagerCreateDto {
    
    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String contact;
    
    private List<TeamDto> teams;
    
    public TeamManagerCreateDto() {
        
    }

    public TeamManagerCreateDto(TeamManagerCreateDto dto) {
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.contact = dto.getContact();
        this.teams = dto.getTeams();
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
    
//    @Override
//    public boolean equals(Object o) {
//        if (!super.equals(o) || !(o instanceof TeamManagerDto))
//            return false;
//        TeamManagerDto tmDto = (TeamManagerDto) o;
//        return (tmDto.getId() == this.getId());
//    }
//
//    @Override
//    public int hashCode() {
//    }
//    
//    @Override
//    public String toString() {
//        return "TeamManagerDto{" + 
//                "id=" + id + 
//                ", name=" + name + 
//                ", address=" + address + 
//                ", contact=" + contact + 
//                ", teams=" + teams + 
//                '}';
//    }
    
}
