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
import com.sg.flashcardapp.model.QueuedCard;
import com.sg.flashcardapp.model.Review;
import com.sg.flashcardapp.model.Role;
import com.sg.flashcardapp.model.User;
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
    
    List<Card> getCardsByRating(int rating);

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
    
//    List<Deck> findDeckByCategory(int id);

    //FOLDER
    Folder getFolder(int id);

    Folder createFolder(Folder folder);

    void deleteFolder(int id);

    Folder updateFolder(int id, Folder folder);

    List<Folder> getAllFolders();
    
    List<Folder> getAllFoldersByUserId(int id);

    //QUEUED CARDS
    QueuedCard getQueuedCard(int it);

    QueuedCard createQueuedCard(QueuedCard queuedCard);

    void deleteQueueCard(int id);

    QueuedCard updateQueuedCard(int id, QueuedCard queuedCard);

    List<QueuedCard> getAllQueuedCards();
    
    //REVIEWS
    Review getReview(int id);
    
    Review createReview(Review review);
    
    void deleteReview(int id);
    
    Review updateReview(int id, Review review);
    
    List<Review> getAllReviews();

    //ROLES
    Role getRole(int id);

    Role createRole(Role role);

    void deleteRole(int id);

    Role updateRole(int id, Role role);

    List<Role> getAllRoles();

    //USERS
    int getUserId(String username);
    
    User getUser(int id);

    User createUser(User user);

    void deleteUser(int id);

    User updateUser(int id, User user);

    List<User> getAllUsers();

}
