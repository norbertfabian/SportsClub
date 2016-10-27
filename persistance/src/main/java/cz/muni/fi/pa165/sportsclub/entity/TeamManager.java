package cz.muni.fi.pa165.sportsclub.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
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
    private List<Team> teams;

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

    public List<Team> getTeams() {
        return teams;
    }

    // Not necessary, in fact only addTeam will be used in reality
//    public void setTeams(List<Team> teams) {
//        this.teams = teams;
//    }
    
    public TeamManager addTeam(Team team) {
        this.teams.add(team);
        return this;
    }
    
    /* TODO: consider having only one remove function - removeTeam(long id) - 
       following norbert's convention?
    */
    
    public TeamManager removeTeam(Team team) {
        this.teams.remove(team);
        return this;
    }
    
    public TeamManager removeTeamById(long id) {
        for (Team t: this.teams) {
            if (t.getId() == id) {
                this.teams.remove(this.teams.indexOf(t));
                break;
            }
        }
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + getName().hashCode();
        hash = 67 * hash + getAddress().hashCode();
        hash = 67 * hash + getContact().hashCode();
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
        
        if (getClass() != obj.getClass()) {
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
