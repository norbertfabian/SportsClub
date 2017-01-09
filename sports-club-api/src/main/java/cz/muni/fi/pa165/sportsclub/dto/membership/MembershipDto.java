package cz.muni.fi.pa165.sportsclub.dto.membership;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;

/**
 * @author Jakub Smolar
 */
public class MembershipDto {

    private long id;

    @NotNull
    @JsonBackReference
    private TeamDto team;

    @NotNull
    private PlayerDto player;

    @Min(1)
    @Max(99)
    private Integer jerseyNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamDto getTeam() {
        return team;
    }

    public void setTeam(TeamDto team) {
        this.team = team;
    }

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MembershipDto that = (MembershipDto) o;

        if (!getTeam().equals(that.getTeam()))
            return false;
        if (!getPlayer().equals(that.getPlayer()))
            return false;
        return getJerseyNumber() != null ?
            getJerseyNumber().equals(that.getJerseyNumber()) :
            that.getJerseyNumber() == null;

    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 73 * result + Objects.hashCode(this.getPlayer());
        result = 73 * result + Objects.hashCode(this.getTeam());
        result = 73 * result + Objects.hashCode(this.getJerseyNumber());
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
