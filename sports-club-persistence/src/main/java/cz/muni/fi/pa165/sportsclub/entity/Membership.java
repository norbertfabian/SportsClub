package cz.muni.fi.pa165.sportsclub.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Entity class which represents relationshiop between {@link Player} and
 * {@link Team}.
 * 
 * @author Jakub Smolar
 */
@Entity
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @NotNull
    private Team team;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @NotNull
    private Player player;

    @Min(1)
    @Max(99)
    private int jerseyNumber;

    public Long getId() {
        return id;
    }

    public Membership setId(Long id) {
        this.id = id;
        return this;
    }

    public Team getTeam() {
        return team;
    }

    public Membership setTeam(Team team) {
        this.team = team;
        return this;
    }

    public Player getPlayer() {
        return player;
    }

    public Membership setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public Membership setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Membership that = (Membership) o;

        if (getId() != that.getId())
            return false;
        if (getJerseyNumber() != that.getJerseyNumber())
            return false;
        if (getTeam() != null ? !getTeam().equals(that.getTeam()) : that.getTeam() != null)
            return false;
        return getPlayer() != null ? getPlayer().equals(that.getPlayer()) : that.getPlayer() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getTeam() != null ? getTeam().hashCode() : 0);
        result = 31 * result + (getPlayer() != null ? getPlayer().hashCode() : 0);
        result = 31 * result + getJerseyNumber();
        return result;
    }
}
