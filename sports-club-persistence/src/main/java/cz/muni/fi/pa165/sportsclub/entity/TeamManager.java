package cz.muni.fi.pa165.sportsclub.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Entity class which represents a team manager in SportsClub. Team manager 
 * can manage multiple teams.
 * 
 * @author Marian Sulgan
 */

@Entity
public class TeamManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String contact;

    @OneToMany(mappedBy = "teamManager")
    private Set<Team> teams = new HashSet<Team>();
    
    public TeamManager() {
        
    }

    public Long getId() {
        return id;
    }

    public TeamManager setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TeamManager setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public TeamManager setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public TeamManager setContact(String contact) {
        this.contact = contact;
        return this;
    }

    
    /**
     * Get list of teams that belong to Team manager
     * 
     * @return list of teams
     */
    public Set<Team> getTeams() {
        return Collections.unmodifiableSet(teams);
    }
    
    /**
     * Adds a team to Team manager.
     * 
     * @param team to be added
     * @return this TeamManager
     */
    public TeamManager addTeam(Team team) {
        this.teams.add(team);
        return this;
    }

    /**
     * Removes a team from Team manager.
     * 
     * @param team to be removed
     * @return this TeamManager
     */
    public TeamManager removeTeam(Team team) {
        this.teams.remove(team);
        return this;
    }

    /**
     * Removes a team from Team manager.
     * 
     * @param id of team to be removed
     * @return this TeamManager
     */
    public TeamManager removeTeamById(long id) {
        for (Iterator<Team> iterator = this.teams.iterator(); iterator.hasNext();) {
            Team team =  iterator.next();
            if (team.getId() == id) {
                iterator.remove();
            }
        }
        
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(getName());
        hash = 67 * hash + Objects.hashCode(getAddress());
        hash = 67 * hash + Objects.hashCode(getContact());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof TeamManager)) {
            return false;
        }

        final TeamManager other = (TeamManager) obj;

        if (!getName().equals(other.getName()))
            return false;

        if (!getAddress().equals(other.getAddress()))
            return false;

        return (getContact().equals(other.getContact()));
    }

}