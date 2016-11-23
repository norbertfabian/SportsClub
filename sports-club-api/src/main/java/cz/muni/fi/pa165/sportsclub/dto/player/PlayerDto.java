/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportsclub.dto.player;

import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import java.util.Date;
import java.util.Set;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Patrick
 */
public class PlayerDto {
    
    @NotNull
    private long id;
    
    @NotNull
    @Size(min = 3, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 50)
    private String lastName;
    
    @Min(0)
    private int height;

    @Min(0)
    private int weight;

    @NotNull
    private Date dateOfBirth;

    private Set<MembershipDto> memberships;

    public PlayerDto() {
    }

    public PlayerDto(PlayerDto dto) {
        this.id = dto.getId();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.height = dto.getHeight();
        this.weight = dto.getWeight();
        this.dateOfBirth = dto.getDateOfBirth();
        this.memberships = dto.getMemberships();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<MembershipDto> getMemberships() {
        return memberships;
    }

    public void setMemberships(Set<MembershipDto> memberships) {
        this.memberships = memberships;
    }   
}
