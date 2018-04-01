/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.service;

import com.sg.flashcardapp.model.Card;
import com.sg.flashcardapp.model.CardRating;
import com.sg.flashcardapp.model.Category;
import com.sg.flashcardapp.model.Deck;
import com.sg.flashcardapp.model.Folder;
import java.util.List;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
public interface FlashCardService {

    //CARD
    Card getCard(int id);

    Card createCard(Card card);

    void deleteCard(int id);

    Card updateCard(int id, Card card);

    List<Card> getAllCards();

    //CARD RATING
    CardRating getCardRating(int id);

    CardRating createCardRating(CardRating cardRating);

    void deleteCardRating(int id);

    CardRating updateCardRating(int id, CardRating cardRating);

    List<CardRating> getAllCardRatings();

    //CATEGORY
    Category getCategory(int id);

    Category createCategory(Category category);

    void deleteCategory(int id);

    Category updateCategory(int id, Category category);

    List<Category> getAllCategories();

    //DECK
    Deck getDeck(int it);

    Deck createDeck(Deck deck);

    void deleteDeck(int id);

    Deck updateDeck(int id, Deck deck);

    List<Deck> getAllDecks();

    //FOLDER
    Folder getFolder(int id);

    Folder createFolder(Folder folder);

    void deleteFolder(int idd);

    Folder updateFolder(int id, Folder folder);

    List<Folder> getAllFolders();
}
