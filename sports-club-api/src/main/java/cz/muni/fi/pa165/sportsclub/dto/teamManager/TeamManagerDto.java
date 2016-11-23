package cz.muni.fi.pa165.sportsclub.dto.teamManager;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Marian Sulgan
 */
public class TeamManagerDto extends TeamManagerCreateDto {
    
    @NotNull
    private long id;
    
    public TeamManagerDto() {

    }

    public TeamManagerDto(TeamManagerDto dto) {
        super(dto);
        this.id = dto.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o) || !(o instanceof TeamManagerDto))
            return false;
        
        TeamManagerDto tmDto = (TeamManagerDto) o;
        
        return (tmDto.getId() == this.getId());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "TeamManagerDto{" + 
                "id=" + id + 
                "name=" + getName() + 
                ", address=" + getAddress() + 
                ", contact=" + getContact() + 
                ", teamsCount=" + getTeams().size() + 
                '}';
    }
}
