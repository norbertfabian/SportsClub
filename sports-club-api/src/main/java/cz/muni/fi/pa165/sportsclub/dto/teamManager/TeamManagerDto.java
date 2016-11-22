package cz.muni.fi.pa165.sportsclub.dto.teamManager;

import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marian Sulgan
 */
public class TeamManagerDto {
  
    private Long id;

    private String name;

    private String address;

    private String contact;

    private List<Team> teams;

    public Long getId() {
        return id;
    }

    public TeamManagerDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TeamManagerDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public TeamManagerDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public TeamManagerDto setContact(String contact) {
        this.contact = contact;
        return this;
    }

    
    public List<Team> getTeams() {
        return Collections.unmodifiableList(teams);
    }
    
    public TeamManagerDto setTeams(List<Team> teams) {
        this.teams = teams;
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
