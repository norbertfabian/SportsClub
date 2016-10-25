package cz.muni.fi.pa165.sportsclub.entity;

import java.util.Collections;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author novaakpatrik
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
    
//    @OneToMany
    @Transient
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
        return getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Player)) {
            return false;
        }
        final Player other = (Player) obj;
        return getId().equals(other.getId());
    }
    
}
