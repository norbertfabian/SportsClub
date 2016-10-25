package cz.muni.fi.pa165.sportsclub.entity;

import com.sun.istack.internal.NotNull;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by MarianSulgan on 25.10.16.
 */

@Entity
public class TeamManager {

    @Id
    // TODO: check reasonablity of strategy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String name;
    
    @NotNull
    private String address;
    
    @NotNull
    private String contact;
    
    @OneToMany
    private List<Team> teams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
    
    public void addTeam(Team team) {
        this.teams.add(team);
    }
    
    /* TODO: consider having only one remove function - removeTeam(long id) - 
       following norbert's convention?
    */
    
    public void removeTeam(Team team) {
        this.teams.remove(team);
    }
    
    public void removeTeamById(long id) {
        for (Team t: this.teams) {
            if (t.getId() == id) {
                this.teams.remove(this.teams.indexOf(t));
                return;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        
        if (!(o instanceof TeamManager)) 
            return false;

        TeamManager tm = (TeamManager) o;

        return getId().equals(tm.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
    
}
