/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.dao;

import com.sg.flashcardapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JP
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
  
    Role findByRoleName(String roleName);
}
