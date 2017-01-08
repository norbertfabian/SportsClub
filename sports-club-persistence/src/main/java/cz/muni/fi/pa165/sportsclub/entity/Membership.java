package cz.muni.fi.pa165.sportsclub.entity;

import java.util.Objects;

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
    private Integer jerseyNumber;

    public long getId() {
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

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public Membership setJerseyNumber(Integer jerseyNumber) {
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
}
