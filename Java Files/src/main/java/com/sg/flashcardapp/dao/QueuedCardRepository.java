/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.dao;

import com.sg.flashcardapp.model.QueuedCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
public interface QueuedCardRepository extends JpaRepository<QueuedCard, Integer> {

}
