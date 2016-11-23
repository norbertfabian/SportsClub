package cz.muni.fi.pa165.sportsclub.dto.team;

import javax.validation.constraints.NotNull;

/**
 * @author Fabian Norbert
 */
public class TeamDto extends TeamCreateDto {

    @NotNull
    private long id;

    public TeamDto() {

    }

    public TeamDto(TeamDto dto) {
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
        if (!super.equals(o) || !(o instanceof TeamDto))
            return false;
        TeamDto teamDto = (TeamDto) o;
        return (teamDto.getId() == this.getId());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return "TeamDto{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", memberships=" + getMemberships() +
                ", teamManager=" + getTeamManager() +
                ", ageGroupLabel=" + getAgeGroupLabel() +
                '}';
    }
}
