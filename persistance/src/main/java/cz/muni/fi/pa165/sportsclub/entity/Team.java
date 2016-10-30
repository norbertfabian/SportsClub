package cz.muni.fi.pa165.sportsclub.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;

/**
 * @author Fabian Norbert
 */

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "team")
    private Set<Membership> memberships;

    @ManyToOne
    private TeamManager teamManager;

    @Enumerated
    private AgeGroup ageGroup;

    public Team() {
        this.memberships = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public Team setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }

    public Team setTeamManager(TeamManager teamManager) {
        this.teamManager = teamManager;
        return this;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public Team setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
        return this;
    }

    public void addMembership(Membership membership) {
        memberships.add(membership);
    }

    public void removeMemebership(Membership membership) {
        memberships.remove(membership);
    }

    public Set<Membership> getMemberships() {
        return Collections.unmodifiableSet(memberships);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;

        Team team = (Team) o;

        return getName().equals(team.getName());

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}