package cz.muni.fi.pa165.sportsclub.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author Jakub Smolar
 */
@Entity
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Team team;

    @ManyToOne(cascade = {CascadeType.ALL})
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
        if (o == null || !(o instanceof Membership))
            return false;

        Membership that = (Membership) o;

        if (getJerseyNumber() != that.getJerseyNumber())
            return false;
        if (getTeam() != null ? !getTeam().equals(that.getTeam()) : that.getTeam() != null)
            return false;
        return getPlayer() != null ? getPlayer().equals(that.getPlayer()) : that.getPlayer() == null;

    }

    @Override
    public int hashCode() {
        int result = getTeam() != null ? getTeam().hashCode() : 0;
        result = 31 * result + (getPlayer() != null ? getPlayer().hashCode() : 0);
        result = 31 * result + getJerseyNumber();
        return result;
    }
}
