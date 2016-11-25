/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportsclub.dto.player;

import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Patrik Novak
 */
public class PlayerDto extends PlayerCreateDto{
    
    private long id;

    private Set<MembershipDto> memberships;

    public PlayerDto() {
    }

    public PlayerDto(PlayerDto dto) {
        super(dto);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<MembershipDto> getMembershipIds() {
        return memberships;
    }

    public void setMemberships(Set<MembershipDto> memberships) {
        this.memberships = memberships;
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
        if (!super.equals(obj) || !(obj instanceof PlayerDto))
            return false;
        final PlayerDto other = (PlayerDto) obj;
        return this.getId() == other.getId();
    }
}
