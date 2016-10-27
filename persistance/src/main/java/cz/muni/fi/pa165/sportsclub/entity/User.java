/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportsclub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marian Sulgan
 * 
 * Note: regarding milestone 1, this entity is neither necessary nor requested,
 * is placed here merely for future purposes, e.g. authentication of users, and 
 * is created now, because we want to make sure, the overall design makes sense 
 * from the utter beginning.
 * 
 */
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(unique = true)
    private String username;
    
    @NotNull
    @Size(min=6, max=32)
    private String password;
    
    @NotNull
    private String role;
    
    private TeamManager teamManager;

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }

    public User setTeamManager(TeamManager teamManager) {
        this.teamManager = teamManager;
        return this;
    }
    
    @Override
    public int hashCode() {
        return this.getUsername().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {     
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;

        return this.getUsername().equals(user.getUsername());           
    }
    
}
