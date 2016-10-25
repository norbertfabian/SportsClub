/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.TeamManager;

/**
 *
 * @author Marian Sulgan
 */
public interface TeamManagerDao {
    
    void create(TeamManager tm);

    TeamManager update(TeamManager tm);

    void remove(TeamManager tm);

    TeamManager findById(Long id);
    
}
