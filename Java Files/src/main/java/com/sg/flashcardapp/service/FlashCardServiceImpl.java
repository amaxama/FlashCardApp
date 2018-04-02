/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.service;

import com.sg.flashcardapp.dao.CardRatingRepository;
import com.sg.flashcardapp.dao.CardRepository;
import com.sg.flashcardapp.dao.CategoryRepository;
import com.sg.flashcardapp.dao.DeckRepository;
import com.sg.flashcardapp.dao.FolderRepository;
import com.sg.flashcardapp.model.Card;
import com.sg.flashcardapp.model.CardRating;
import com.sg.flashcardapp.model.Category;
import com.sg.flashcardapp.model.Deck;
import com.sg.flashcardapp.model.Folder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author betzler
 */
@Component
public class FlashCardServiceImpl implements FlashCardService {

    @Autowired
    private CardRepository cards;
    @Autowired
    private CardRatingRepository cardRatings;
    @Autowired
    private CategoryRepository categories;
    @Autowired
    private DeckRepository decks;
    @Autowired
    private FolderRepository folders;

    //CARD
    @Override
    public Card getCard(int id) {
        return cards.findOne(id);
    }

    @Override
    public Card createCard(Card card) {
        return cards.save(card);
    }

    @Override
    public void deleteCard(int id) {
        cards.delete(id);
    }

    @Override
    public Card updateCard(int id, Card card) {
        cards.save(card);

        return card;
    }

    @Override
    public List<Card> getAllCards() {
        return cards.findAll();
    }

    //CARD RATING
    public CardRating getCardRating(int id) {
        return cardRatings.findOne(id);
    }

    @Override
    public CardRating createCardRating(CardRating cardRating) {
        return cardRatings.save(cardRating);
    }

    @Override
    public void deleteCardRating(int id) {
        cardRatings.delete(id);
    }

    @Override
    public CardRating updateCardRating(int id, CardRating cardRating) {
        return cardRatings.save(cardRating);
    }

    @Override
    public List<CardRating> getAllCardRatings() {
        return cardRatings.findAll();
    }

    //CATEGORY
    @Override
    public Category getCategory(int id) {
        return categories.findOne(id);
    }

    @Override
    public Category createCategory(Category category) {
        return categories.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        categories.delete(id);
    }

    @Override
    public Category updateCategory(int id, Category category) {
        return categories.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categories.findAll();
    }

    //DECK
    @Override
    public Deck getDeck(int id) {
        return decks.findOne(id);
    }

    @Override
    public Deck createDeck(Deck deck) {
        return decks.save(deck);
    }

    @Override
    public void deleteDeck(int id) {
        decks.delete(id);
    }

    @Override
    public Deck updateDeck(int id, Deck deck) {
        return decks.save(deck);
    }

    @Override
    public List<Deck> getAllDecks() {
        return decks.findAll();
    }

    //FOLDER
    @Override
    public Folder getFolder(int id) {
        return folders.findOne(id);
    }

    @Override
    public Folder createFolder(Folder folder) {
        return folders.save(folder);
    }

    @Override
    public void deleteFolder(int id) {
        folders.delete(id);
    }

    @Override
    public Folder updateFolder(int id, Folder folder) {
        return folders.save(folder);
    }

    @Override
    public List<Folder> getAllFolders() {
        return folders.findAll();
    }
}
