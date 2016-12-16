package cz.muni.fi.pa165.sportsclub.dto.team;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.Set;

/**
 * @author Fabian Norbert
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class TeamDto{

    private long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    private Set<MembershipDto> memberships;

    private TeamManagerDto teamManager;

    @JsonIgnore
    private long teamManagerId;

//    private AgeGroupDto ageGroup;

    private String ageGroupLabel;
    
    public TeamDto() {

    }

    public TeamDto(TeamDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.memberships = Collections.unmodifiableSet(dto.getMemberships());
        this.teamManager = dto.getTeamManager();
        this.ageGroupLabel = dto.getAgeGroupLabel();
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getTeamManagerId() {
        return teamManagerId;
    }

    public void setTeamManagerId(long teamManagerId) {
        this.teamManagerId = teamManagerId;
    }

//    public AgeGroupDto getAgeGroup() {
//        return ageGroup;
//    }
//
//    public void setAgeGroup(AgeGroupDto ageGroup) {
//        this.ageGroup = ageGroup;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamDto)) return false;

        TeamDto teamDto = (TeamDto) o;

        return getName() != null ? getName().equals(teamDto.getName()) : teamDto.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}
