/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.dao;

import com.sg.flashcardapp.model.Folder;
import com.sg.flashcardapp.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JP
 */
public interface UserRepository extends JpaRepository<User, Integer> {
  
    Integer findByUserId(int id);
    
    User findByUserName(String userName);
    
}
