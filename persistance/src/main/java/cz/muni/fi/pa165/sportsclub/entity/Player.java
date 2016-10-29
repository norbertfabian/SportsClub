package cz.muni.fi.pa165.sportsclub.entity;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Entity class which represents a player in SportsClub. Player can be a member
 * of multiple teams, which is represented via {@link Membership}
 * 
 * @author Patrik Nov�k
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private int height;

    private int weight;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Past
    private Date dateOfBirth;

    @OneToMany
    @Transient
    private Set<Membership> memberships = new HashSet<Membership>();

    /**
     * Nonparametric constructor.
     */
    public Player() {
   
    }

    /**
     * Constructor assigning specified ID.
     * 
     * @param id ID to be set.
     */
    public Player(Long id) {
        this.id = id;
    }

    /**
     * Gets ID of Player.
     * 
     * @return ID of Player.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets ID of Player.
     * 
     * @param id to be set.
     * @return this Player.
     */
    public Player setId(long id) {
        this.id = id;
        return this;
    }

    /**
     * Gets first name of Player.
     * 
     * @return first name of Player.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name of Player.
     * 
     * @param firstName to be set.
     * @return this Player.
     */
    public Player setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Gets last name of Player.
     * 
     * @return last name of Player.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name of Player.
     * 
     * @param lastName to be set.
     * @return this Player.
     */
    public Player setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Gets height of Player.
     * 
     * @return height of Player.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height of Player.
     * 
     * @param height to be set.
     * @return this Player.
     */
    public Player setHeight(int height) {
        this.height = height;
        return this;
    }

    /**
     * Gets weight of Player.
     * 
     * @return weight of Player.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets weight of Player.
     * 
     * @param weight to be set.
     * @return this Player.
     */
    public Player setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    /**
     * Gets birth date of Player.
     * 
     * @return birth date of Player.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets birth date of Player.
     * 
     * @param dateOfBirth to be set.
     * @return this Player.
     */
    public Player setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * Gets memberships of Player.
     * 
     * @return memberships of Player.
     */
    public Set<Membership> getMemberships() {
        return Collections.unmodifiableSet(memberships);
    }

    /**
     * Adds a membership to Player.
     * 
     * @param membership to be added
     */
    public void addMembership(Membership membership) {
        memberships.add(membership);
    }

    /**
     * Removes a membership from Player.
     * 
     * @param membership to be removed
     */
    public void removeMembership(Membership membership) {
        memberships.remove(membership);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(getFirstName());
        hash = 89 * hash + Objects.hashCode(getLastName());
        hash = 89 * hash + Objects.hashCode(getDateOfBirth());
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
