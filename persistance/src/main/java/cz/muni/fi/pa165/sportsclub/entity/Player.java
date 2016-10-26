package cz.muni.fi.pa165.sportsclub.entity;

import java.util.Collections;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by patrik on 25.10.16.
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String firstName;
    
    @NotNull
    private String lastName;
    
    private int height;
    
    private int weight;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @OneToMany
    private Set<Membership> memberships;

    public Long getId() {
        return id;
    }

    public Player setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Player setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Player setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Player setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Player setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Player setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Set<Membership> getMemberships() {
        return Collections.unmodifiableSet(memberships);
    }

    public Player setMemberships(Set<Membership> memberships) {
        this.memberships = memberships;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + getFirstName().hashCode();
        hash = 89 * hash + getLastName().hashCode();
        hash = 89 * hash + getDateOfBirth().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Player)) {
            return false;
        }
        final Player other = (Player) obj;
        
        if (!getFirstName().equals(other.getFirstName())) {
            return false;
        }
        if (!getLastName().equals(other.getLastName())) {
            return false;
        }
        return getDateOfBirth().equals(other.getDateOfBirth());
    }
    
    
}
