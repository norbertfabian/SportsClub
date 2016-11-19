package cz.muni.fi.pa165.sportsclub.dto.team;

import cz.muni.fi.pa165.sportsclub.dto.ageGroup.AgeGroupDto;
import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.Set;

/**
 * Created by norbert on 19.11.16.
 */
public class TeamCreateDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    private Set<MembershipDto> memberships;

    private TeamManagerDto teamManager;

    private AgeGroupDto ageGroup;

    public TeamCreateDto() {

    }

    public TeamCreateDto(TeamDto dto) {
        this.name = dto.getName();
        this.memberships = Collections.unmodifiableSet(dto.getMemberships());
        this.teamManager = dto.getTeamManager();
        this.ageGroup = dto.getAgeGroup();
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

    public AgeGroupDto getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroupDto ageGroup) {
        this.ageGroup = ageGroup;
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
                ", ageGroup=" + ageGroup +
                '}';
    }
}
