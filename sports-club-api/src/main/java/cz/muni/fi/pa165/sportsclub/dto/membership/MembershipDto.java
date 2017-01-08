package cz.muni.fi.pa165.sportsclub.dto.membership;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;

/**
 * @author Jakub Smolar
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class MembershipDto {

    private long id;

    @NotNull
    @JsonBackReference
    private TeamDto team;

    @NotNull
    private PlayerDto player;

    @Min(1)
    @Max(99)
    private int jerseyNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamDto getTeam() {
        return team;
    }

    public MembershipDto setTeam(TeamDto team) {
        this.team = team;
        return this;
    }

    public PlayerDto getPlayer() {
        return player;
    }

    public MembershipDto setPlayer(PlayerDto player) {
        this.player = player;
        return this;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public MembershipDto setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MembershipDto that = (MembershipDto) o;

        if (getJerseyNumber() != that.getJerseyNumber())
            return false;
        if (!getTeam().equals(that.getTeam()))
            return false;
        return getPlayer().equals(that.getPlayer());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getTeam() == null ? 0 : getTeam().hashCode());
        result = 31 * result + (getPlayer() == null ? 0 : getPlayer().hashCode());
        result = 31 * result + getJerseyNumber();
        return result;
    }

    @Override
    public String toString() {
        return "MembershipDto{" +
            "id=" + id +
            ", team=" + team +
            ", player=" + player +
            ", jerseyNumber=" + jerseyNumber +
            '}';
    }
}
