package cz.muni.fi.pa165.sportsclub.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

import com.sun.istack.internal.NotNull;
import cz.muni.fi.pa165.sportsclub.enumeration.AgeGroup;

/**
 * Created by norbert on 24.10.16.
 */

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(unique = true)
    private String name;

//    TODO: Remove Transient annotation and uncomment OneToMany annotation when Player class is implemented
//    @OneToMany(mappedBy = "team")
    @Transient
    private List<Membership> memberships;

//    TODO: Remove Transient annotation and uncomment OneToMany annotation when Player class is implemented
//    @OneToMany(mappedBy = "team")
    @Transient
    private List<TeamManager> teamManagers;

    private AgeGroup ageGroup;

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

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public void addMembership(Membership membership) {
        memberships.add(membership);
    }

    public void removeMemebership(long id) {
        //TODO: implement when Membership ID exists
    }

    public void addTeamManager(TeamManager teamManager) {
        teamManagers.add(teamManager);
    }

    public void removeTeamManager(long id) {
        //TODO: implement when TeamManager ID exists
    }

    public List<Membership> getMemberships() {
        return Collections.unmodifiableList(memberships);
    }

    public List<TeamManager> getTeamManagers() {
        return Collections.unmodifiableList(teamManagers);
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
        return getName().hashCode();
    }
}
