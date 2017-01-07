package cz.muni.fi.pa165.sportsclub.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 *
 * @author Marian Sulgan
 * 
 * Note: regarding milestone 1/2, this entity is neither necessary nor requested,
 * is placed here merely for future purposes, e.g. authentication of users, and 
 * is created now, because we want to make sure, the overall design makes sense 
 * from the utter beginning.
 * 
 */
@Entity()
@Table(name = "sportsclubsuser")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(unique = true)
    private String username;
    
    @NotNull
    private String password;
    
    @NotNull
    private String role;

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
    
    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
    
    @Override
    public boolean equals(Object obj) {     
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (!(obj instanceof User)) {
            return false;
        }

        User user = (User) obj;

        return this.getUsername().equals(user.getUsername());           
    }
    
}
