package cz.muni.fi.pa165.sportsclub.dto.membership;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;

/**
 * @author Jakub Smolar
 */
public class MembershipCreateDto {

    @NotNull
    private Team team;

    @NotNull
    private Player player;

    @Min(1)
    @Max(99)
    private int jerseyNumber;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
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

        MembershipCreateDto that = (MembershipCreateDto) o;

        if (getJerseyNumber() != that.getJerseyNumber())
            return false;
        if (!getTeam().equals(that.getTeam()))
            return false;
        return getPlayer().equals(that.getPlayer());

    }

    @Override
    public int hashCode() {
        int result = getTeam().hashCode();
        result = 31 * result + getPlayer().hashCode();
        result = 31 * result + getJerseyNumber();
        return result;
    }

    @Override
    public String toString() {
        return "MembershipCreateDto{" +
            "team=" + team +
            ", player=" + player +
            ", jerseyNumber=" + jerseyNumber +
            '}';
    }
}
