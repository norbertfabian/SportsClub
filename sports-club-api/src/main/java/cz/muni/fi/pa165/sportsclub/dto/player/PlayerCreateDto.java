/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportsclub.dto.player;

import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Patrick
 */
public class PlayerCreateDto {
    
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
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Past
    private Date dateOfBirth;

    public PlayerCreateDto() {
    }

    public PlayerCreateDto(PlayerDto dto) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.height = dto.getHeight();
        this.weight = dto.getWeight();
        this.dateOfBirth = dto.getDateOfBirth();
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.getFirstName());
        hash = 73 * hash + Objects.hashCode(this.getLastName());
        hash = 73 * hash + Objects.hashCode(this.getDateOfBirth());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || !(obj instanceof PlayerCreateDto)) {
            return false;
        }
        final PlayerCreateDto other = (PlayerCreateDto) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return Objects.equals(this.dateOfBirth, other.dateOfBirth);
    }
    
    
}
