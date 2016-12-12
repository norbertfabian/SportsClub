package cz.muni.fi.pa165.sportsclub.dto.membership;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;

/**
 * @author Jakub Smolar
 */
public class MembershipDto {

    private Long id;

    @NotNull
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

    public void setTeam(TeamDto team) {
        this.team = team;
    }

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
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
        if (!getId().equals(that.getId()))
            return false;
        if (!getTeam().equals(that.getTeam()))
            return false;
        return getPlayer().equals(that.getPlayer());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getTeam().hashCode();
        result = 31 * result + getPlayer().hashCode();
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
