package cz.muni.fi.pa165.sportsclub.dto.team;

import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Fabian Norbert
 */
public class TeamCreateDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    private Set<MembershipDto> memberships;

    private TeamManagerDto teamManager;

    private String ageGroupLabel;

    private List<String> ageGroupLabelsList;

    public TeamCreateDto() {

    }

    public TeamCreateDto(TeamDto dto) {
        this.name = dto.getName();
        this.memberships = Collections.unmodifiableSet(dto.getMemberships());
        this.teamManager = dto.getTeamManager();
        this.ageGroupLabel = dto.getAgeGroupLabel();
        this.ageGroupLabelsList = dto.getAgeGroupLabelsList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MembershipDto> getMemberships() {
        return memberships;
    }

    public void setMemberships(Set<MembershipDto> memberships) {
        this.memberships = memberships;
    }

    public TeamManagerDto getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(TeamManagerDto teamManager) {
        this.teamManager = teamManager;
    }

    public String getAgeGroupLabel() {
        return ageGroupLabel;
    }

    public void setAgeGroupLabel(String ageGroupLabel) {
        this.ageGroupLabel = ageGroupLabel;
    }

    public List<String> getAgeGroupLabelsList() {
        return ageGroupLabelsList;
    }

    public void setAgeGroupLabelsList(List<String> ageGroupLabelsList) {
        this.ageGroupLabelsList = ageGroupLabelsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || !(o instanceof TeamCreateDto)) return false;

        TeamCreateDto teamCreateDto = (TeamCreateDto) o;

        return getName().equals(teamCreateDto.getName());

    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return "TeamCreateDto{" +
                "name='" + name + '\'' +
                ", memberships=" + memberships +
                ", teamManager=" + teamManager +
                ", ageGroup=" + ageGroupLabel +
                '}';
    }
}
