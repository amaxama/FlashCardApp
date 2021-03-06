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
import com.sg.flashcardapp.dao.QueuedCardRepository;
import com.sg.flashcardapp.dao.ReviewRepository;
import com.sg.flashcardapp.dao.RoleRepository;
import com.sg.flashcardapp.dao.UserRepository;
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
    @Autowired
    private QueuedCardRepository queuedCards;
    @Autowired
    private RoleRepository roles;
    @Autowired
    private UserRepository users;
    @Autowired
    private ReviewRepository reviews;

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
        List<Card> cardsList = cards.findAll();
        for (Card card : cardsList) {
            List<CardRating> ratings = cardRatings.findByCardId(card.getCardId());
            card.setRatings(ratings);
        }
        return cardsList;
    }

    @Override
    public List<Card> getCardsByRating(int rating) {
        return cards.getCardsByRating(rating);
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

//    @Override
//    public List<Deck> findDeckByCategory(int id) {
//        return decks.findDeckByCategory(id);
//    }
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

    //QUEUED CARDS
    @Override
    public QueuedCard getQueuedCard(int id) {
        return queuedCards.findOne(id);
    }

    @Override
    public QueuedCard createQueuedCard(QueuedCard queuedCard) {
        return queuedCards.save(queuedCard);
    }

    @Override
    public void deleteQueueCard(int id) {
        queuedCards.delete(id);
    }

    @Override
    public QueuedCard updateQueuedCard(int id, QueuedCard queuedCard) {
        return queuedCards.save(queuedCard);
    }

    @Override
    public List<QueuedCard> getAllQueuedCards() {
        return queuedCards.findAll();
    }

    //REVIEWS
    @Override
    public Review getReview(int id) {
        return reviews.findOne(id);
    }

    @Override
    public Review createReview(Review review) {
        return reviews.save(review);
    }

    @Override
    public void deleteReview(int id) {
        reviews.delete(id);
    }

    @Override
    public Review updateReview(int id, Review review) {
        return reviews.save(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviews.findAll();
    }

    //ROLES
    @Override
    public Role getRole(int id) {
        return roles.findOne(id);
    }
    
    @Override
    public Role getRoleByName(String roleName) {
        return roles.findByRoleName(roleName);
    }
        
    @Override
    public Role createRole(Role role) {
        return roles.save(role);
    }

    @Override
    public void deleteRole(int id) {
        roles.delete(id);
    }

    @Override
    public Role updateRole(int id, Role role) {
        return roles.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roles.findAll();
    }

    //USERS
    @Override
    public int getUserId(String username) {
        User user = users.findByUserName(username);
        return user.getUserId();
    }

    @Override
    public User getUser(int id) {
        return users.findOne(id);
    }

    @Override
    public User createUser(User user) {
        return users.save(user);
    }

    @Override
    public void deleteUser(int id) {
        users.delete(id);
    }

    @Override
    public User updateUser(int id, User user) {
        return users.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return users.findAll();
    }

    @Override
    public List<Folder> getAllFoldersByUserId(int id) {
        return folders.findByUserId(id);
    }
}
