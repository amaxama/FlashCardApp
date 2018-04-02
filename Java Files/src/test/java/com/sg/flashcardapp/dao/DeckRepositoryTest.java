/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.flashcardapp.model.Deck;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author annamaxam
 */
public class DeckRepositoryTest {
    
    public DeckRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetDeck() throws JsonProcessingException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-persistence.xml");
        DeckRepository dr = ctx.getBean("deckRepository", DeckRepository.class);
        
        Deck result = dr.findOne(1);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        assertEquals(1, result.getCards().size());
        
//        dr.findOne(1);
        
        
    }
    
}
