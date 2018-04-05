/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var cardArray = [];
var cardRatingArray = [];
var deckArray = [];
var reviewArray = [];
var folderArray = [];
var reviewArray = [];
var catArray = [];
var ratingArray = [];
var currentDeck = [];
var cards = [];
var userId;
$(document).ready(function () {
    getCurrentUser();
    loadUserFoldersToArray(folderArray);
    loadCardsToArray(cardArray);
    loadDecksToArray(deckArray);
    loadReviewsToArray(reviewArray);
    loadCategoriesToArray(catArray);
    // change this method so not relying on bringing card array in
    loadDisplayByCategory(cardArray);
//    $('#cards-list').hide();

    $('#create-folder-button').click(function (event) {
        console.log("buttonclicked");
        createFolder();
    });
    $('#create-deck-button').click(function (event) {
        console.log("buttonclicked");
        createDeck();
    });
    $('#create-card-button').click(function (event) {
        console.log("buttonclicked");
        createCard();
    });
    $('#user-name').append('Username');
//    $('#table-div').show();
    $('#card-div').hide();
    $('#card-back').hide();
    $('#toggle-card-button').click(function (event) {
        $('#card-back').toggle();
        $('#card-front').toggle();
    });
//    $('#view-deck-button').click(function (event) {
//        $('#table-div').toggle();
//        $('#card-div').toggle();
//        var deckId = $('#deck-id').val();
//        var deck = findItemById(deckArray, 'deckId', 1);
//        console.log(deck);
//        cards = deck.cards;
//        console.log(cards);
//        cardsLength = cards.length;
//        var i = 0;
//        $('#left-button').prop('disabled', true);
//        $('#card-number').val(i + 1);
////        $('#number-in-deck-front').val(i+1);
//        var card = cards[i];
//        console.log(card);
//        var challenge = card.cardChallenge;
//        var answer = card.cardAnswer;
//        $('#card-back').hide();
//        $('#front-content').append($('<p>')
//                .text(challenge));
//        $('#back-content').append($('<p>')
//                .text(answer));
//
//    });

// =============================================================================
// ==== CARD BUTTONS ===========================================================
// =============================================================================


    $('#right-button').click(function (event) {
        console.log("click");
        var i = parseInt($('#card-number').val());
        console.log(i);
        $('#card-number').val('');
        $('#card-number').val(i + 1);
        console.log($('#card-number').val());
        console.log(cards.length);
        console.log($(this).prop('disabled'));
        if (parseInt($('#card-number').val()) == 1) {
            console.log($('#left-button').prop('disabled'));
            $('#left-button').prop('disabled', true);
        } else if (parseInt($('#card-number').val()) == cards.length) {
            $(this).prop('disabled', true);
            console.log($(this).prop('disabled'));
        } else {
            $('#left-button').prop('disabled', false);
            $('#right-button').prop('disabled', false);
        }
        todoOnClick(i);
    });
    $('#left-button').click(function (event) {
        console.log("click");
        var i = parseInt($('#card-number').val()) - 1;
        console.log(i);
        $('#card-number').val('');
        $('#card-number').val(i);
        console.log($('#card-number').val());
        console.log($(this).prop('disabled'))
        if (parseInt($('#card-number').val()) == 1) {
            console.log($(this).prop('disabled'))
            $(this).prop('disabled', true);
        } else if (parseInt($('#card-number').val()) == cards.length) {
            $('#right-button').prop('disabled', true);
        } else {
            $('#left-button').prop('disabled', false);
            $('#right-button').prop('disabled', false);
        }
        todoOnClick(i - 1);
    });
});
function showDecks() {
    $('#cards-list').toggle();
    $('#decks-list').toggle();
}

function backButton() {
    $('#table-div').show();
    $('#card-div').hide();
}


function todoOnClick(i) {
//    $('#card-number').val(i);
//    console.log(parseInt($('#number-in-deck').val()));
    var card = cards[i];
    console.log(card);
    var challenge = card.cardChallenge;
//    console.log(challenge);
    var answer = card.cardAnswer;
//    console.log(answer);
    $('#card-front').show();
    $('#card-back').hide();
    $('#front-content').empty();
//    $('#card-number').val(i+1);
    $('#front-content').append($('<div>')
            .attr({class: "card cta cta--featured"})
            .append($('<div>')
                    .attr({class: "card-block"})
                    .append($('<h3>')
                            .attr({class: "card-title no-margin-top"})
                            .append('Card Challenge<span class="fa fa-map pull-right"></span></h3>')))
            .append($('<span>')
                    .attr({class: "header-line gradient-color-1"}))
            .append($("<div>")
                    .attr({class: "card-block"})
                    .append($("<p>")
                            .attr({class: "card-text"}).text(challenge))))
    $('.card-text').css({'height': '550px', 'text-align': 'center'});
    $('.card-block').css({'text-align': 'center'});
    $('#back-content').empty();
    $('#back-content').append($('<div>')
            .attr({class: "card cta cta--featured"})
            .append($('<div>')
                    .attr({class: "card-block"})
                    .append($('<h3>')
                            .attr({class: "card-title no-margin-top"})
                            .append('Card Answer<span class="fa fa-map pull-right"></span></h3>')))
            .append($('<span>')
                    .attr({class: "header-line gradient-color-1"}))
            .append($("<div>")
                    .attr({class: "card-block"})
                    .append($("<p>")
                            .attr({class: "card-text"}).text(answer))));
    console.log($('#front-content').text());
    console.log($('#card-back').text());
    console.log(parseInt($('#card-number').val()));
    $('.card-text').css({'height': '550px', 'text-align': 'center'});
    $('.card-block').css({'text-align': 'center'});
}

function findItemById(array, id, idValue) {
    for (var i = 0; i < array.length; i++) {
        if (array[i][id] === idValue) {
            return array[i];
        }
    }
    return null;
}



function addFolder() {
    console.log("add folder");
    $('#accordion').append($('<div>')
            .attr({class: 'card', id: 'first-folder'})
            .append($('<div>')
                    .attr({class: 'card-header'})
                    .append($('<a>')
                            .attr({class: 'card-link', 'data-toggle': 'collapse', href: '#collapseOne'}).text($('#add-folder-name').val())))
            .append($('<div>')
                    .attr({id: 'collapseOne', class: 'collapse', 'data-parent': '#accordion'})
                    .append($('<div>')
                            .attr({id: 'folder-one-decks', class: 'card-body'}))));
    $('#create-folder-modal').modal('hide');
}

// =============================================================================
// ==== USER METHODS ===========================================================
// =============================================================================

function getCurrentUser() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/currentuser/userId',
        success: function (id, status) {
            $('#current-user-id').val(id);
            userId = id;
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}


function getUser(userId) {
    $('#errorMessages').empty();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/user/' + userId,
        success: function (data, status) {
//            set values in id spots
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function createUser() {
    console.log("button regisered");
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/FlashCardApp/user',
        data: JSON.stringify({
            userName: $('#user-name').val(),
            password: $('#user-name').val()
                    //            roles: make their default role User 



        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data, status) {
            $('#signup-error-messages').empty();
            $('#user-name').val('');
            $('#user-name').val('');
        },
        error: function () {
            $('#signup-error-messages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function updateUser(userId) {

    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/FlashCardApp/user/' + userId,
        data: JSON.stringify({
//            userName: $('#____').val(),
//            password: $('#____').val(),
//            roles:
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data, status) {
            $('#errorMessages').empty();
            hideEditCardForm();
//            getAllCards();
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function deleteUser(userId) {

    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/FlashCardApp/user/' + userId,
        success: function (status) {
            showDeleteSuccessBanner();
        }
    });
}


// =============================================================================
// ==== CARD METHODS ===========================================================
// =============================================================================

function loadCardsToArray(cardArray) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/cards',
        success: function (cardsArray) {
            $.each(cardsArray, function (index, card) {
                cardArray.push(card);
            });
//          getAllCards();
            displayCardRatings();
            loadDisplayByCategory();
        },
        error: function () {
            $('#error-messages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function displayCardRatings() {
    var cardsList = $('#cards-list');
    var ratingsFeed = $('#card-ratings');
    cardsList.empty();
    ratingsFeed.empty();
    cardArray.forEach(card => {
        var id = card.cardId;
        var name = card.cardName;
        cardsList.append($('<li>')
                .attr({class: 'list-group-item', id: id})
                .text(name));
    });
    cardsList.hide();
    cardsToDisplayArray = cardArray.slice(0,5);
    cardsToDisplayArray.forEach(card => {
        var id = card.cardId;
        var name = card.cardName;
        var chal = card.cardChallenge;
        var ans = card.cardAnswer;
        var ratings = card.ratings;
        var sum = 0;
        ratings.forEach(rating => {
            sum += rating.rating;
        });
        var avgRating = sum / ratings.length;
        
        ratingsFeed.append($('<li>')
                .attr({class: 'list-group-item', id: id + 'rating'})
                .text(name + ' - ' + avgRating + '/5'));
    });
    
}





function getCard(cardId) {
    $('#errorMessages').empty();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/card/' + cardId,
        success: function (card, status) {
//            var id = card.cardId;
//            var name = card.cardName;
//            var challenege = card.cardChallenge;
//            var answer = card.cardAnswer;
//            set values in id spots
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function createCard() {

    console.log("create card");
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/FlashCardApp/card',
        data: JSON.stringify({
            cardName: $('#card-name').val(),
            cardChallenge: $('#card-challenge').val(),
            cardAnswer: $('#card-answer').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (card, status) {
            $('#errorMessages').empty();
//            Set card values to ('')
            cardArray.push(card);
//            Change this name later!
            displayCardRatings();
            $('#create-card-modal').modal('hide');
            
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function updateCard(cardId) {

    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/FlashCardApp/card/' + cardId,
        data: JSON.stringify({
//            cardName: $('#____').val(),
//            cardChallenge: $('#____').val(),
//            cardAnswer: $('#____').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data, status) {
            $('#errorMessages').empty();
            hideEditCardForm();
            getAllCards();
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function deleteCard(cardId) {

    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/FlashCardApp/card/' + cardId,
        success: function (status) {
            showDeleteSuccessBanner();
            getAllCards();
        }
    });
}

function showEditCardForm(cardId) {
    $('#errorMessages').empty();
    getCard(cardId);
//    CHECK IDs!!
    $('#main-div').hide();
    $('#edit-card-form-div').show();
}

function hideEditCardForm() {
    $('#errorMessages').empty();
//    $('#______').val('');
//    $('#______').val('');
//      ETC.....
//CHECK ID NAME
    $('#edit-card-form-div').hide();
    $('#main-div').show();
}

function clearCardsList() {
//    CHECK IDS!
    $('#cards-list').empty();
}



// =============================================================================
// ==== CATEGORY METHODS FROM MIKE =======================================================
// =============================================================================
function loadCategoriesToArray(catArray) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/categories',
        success: function (categoryArray, status) {
            $.each(categoryArray, function (index, category) {
                catArray.push(category);
                $('#category-dropdown-list')
                        .append($('<button>')
                                .attr({class: 'dropdown-item', type: 'button', onclick: 'filterDisplayByCategory(' + category.categoryId + ')'})
                                .text(category.categoryName));
            });
        },
        error: function () {
            $('#error-messages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function loadDisplayByCategory() {
    clearDisplayByCategory();
    var displayByCategory = $('#displayByCategory');
    cardArray.forEach(card => {
        displayByCategory
                .append($('<tr>')
                        .append($('<td>')
                                .text(card.cardName))
                        .append($('<td>')
                                .text(card.cardChallenge)))
    });
}

function filterDisplayByCategory(categoryId) {
    var displayByCategory = $('#displayByCategory');
    if (categoryId == 0) {
        loadDisplayByCategory();
    } else {
        clearDisplayByCategory();
        catArray.forEach(category => {
            if (category.categoryId == categoryId) {
//                console.log("catid: " + category.categoryId);
                var cards = category.cards;
                cards.forEach(card => {
                    displayByCategory
                            .append($('<tr>')
                                    .append($('<td>')
                                            .text(card.cardName))
                                    .append($('<td>')
                                            .text(card.cardChallenge)))
                })
            }
        });
    }
}

function clearDisplayByCategory() {
    $('#displayByCategory').empty();
}



// =============================================================================
// ==== CATEGORY METHODS =======================================================
// =============================================================================

function getAllCategories() {
    clearCategoriesList();
//    CHECK ON ID NAME
    var categoriesList = $('#categories-list');
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/ca',
        success: function (categoryArray, status) {
            $.each(categoryArray, function (index, category) {
                var id = category.categoryId;
//                OTHER VARS


                var row;
//                HTML FOR WHAT CATEGORY IS GONNA LOOK LIKE

//                catgoriesList.append(use append, attr, text etc.);

            });
        },
        error: function () {
            $('#error-messages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function getCategory(categoryId) {
    $('#error-messages').empty();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/category/' + categoryId,
        success: function (data, status) {
//            set values in id spots
        },
        error: function () {
            $('#error-messages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

// COULD PUT IN CREATE/UPDATE/DELETE CATEGORY FUNCTIONS LATER


// =============================================================================
// ==== DECK METHODS ===========================================================
// =============================================================================


//Need to be able to get decks 

function loadDecksToArray(deckArray) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/decks',
        success: function (decksArray, status) {
            $.each(decksArray, function (index, deck) {
                deckArray.push(deck);
            });
            getAllDecks();
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}


function getAllDecks() {
    var decksList = $('#decks-list');
    decksList.empty();
    deckArray.forEach(deck => {
        var id = deck.deckId;
        var name = deck.deckName;
        var deck = deck.deckDesc;
        var cards = deck.cards;
        var reviews = deck.reviews;
        decksList.append($('<li>')
                .attr({class: 'list-group-item', id: id})
                .text(name));
        
    });
    decksList.hide();
  
}

function getDeck(deckId) {
    $('#errorMessages').empty();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/deck/' + deckId,
        success: function (deck, status) {
            currentDeck = deck.cards;
            console.log(currentDeck);
            deckLength = currentDeck.length;
            console.log(deckLength);
            return currentDeck;
//            var id = deck.deckId;
//            var name = deck.deckName;
//            var desc = deck.desc;
//            var reviews = deck.reviews;
//            set values in id spots
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function createDeck() {

//id= $('#current-user-id').val();
//    console.log("create folder");
//    $.ajax({
//        type: 'POST',
//        url: 'http://localhost:8080/FlashCardApp/folder/user/' + id,
//        data: JSON.stringify({
//            folderName: $('#add-folder-name').val(),
//            userId: $('#current-user-id').val()
//        }),




    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/FlashCardApp/deck',
        data: JSON.stringify({
            deckName: $('#deck-name').val(),
            deckDesc: $('#deck-desc').val()
//            cards: $('#deck-cards').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data, status) {
            $('#errorMessages').empty();
            $('#deck-name').val('');
            $('#deck-desc').val('');
//            $('#deck-cards').val('');
//            Set deck values to ('')
//      WHERE GET USER ID FROM?
//                getAllDecksByUser();
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function updateDeck(deckId) {

    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/FlashCardApp/deck/' + deckId,
        data: JSON.stringify({
//            deckName: $('#____').val(),
//            deckDesc: $('#____').val(),

        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data, status) {
            $('#errorMessages').empty();
            hideEditCardForm();
            getAllCards();
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function deleteDeck(deckId) {

    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/FlashCardApp/deck/' + deckId,
        success: function (status) {
            showDeleteSuccessBanner();
            getAllDecksByUser();
        }
    });
}

// =============================================================================
// ==== FOLDER METHODS =========================================================
// =============================================================================

function loadUserFoldersToArray(folderArray) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/folders/user',
        success: function (foldersArray, status) {
            $.each(foldersArray, function (index, folder) {
                folderArray.push(folder);
            });
            getAllUserFolders();
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}


function studyDeck(deck) {
    $('#front-content').empty();
    $('#back-content').empty();
    $('#table-div').hide();
    $('#card-div').show();
//        var deckId = $('#deck-id').val();
//        console.log(deckId);
//        var deck = findItemById(deckArray, 'deckId', deckId);
    console.log(deck);
    cards = deck.cards;
    cardsLength = cards.length;
    var i = 0;
    $('#left-button').prop('disabled', true);
    $('#card-number').val(i + 1);
//        $('#number-in-deck-front').val(i+1);
    var card = cards[i];
    var challenge = card.cardChallenge;
    var answer = card.cardAnswer;
    $('#card-back').hide();
    $('#front-content').append($('<div>')
            .attr({class: "card cta cta--featured"})
            .append($('<div>')
                    .attr({class: "card-block"})
                    .append($('<h3>')
                            .attr({class: "card-title no-margin-top"})
                            .append('Card Challenge<span class="fa fa-map pull-right"></span></h3>')))
            .append($('<span>')
                    .attr({class: "header-line gradient-color-1"}))
            .append($("<div>")
                    .attr({class: "card-block"})
                    .append($("<p>")
                            .attr({class: "card-text"}).text(challenge))));
    $('#back-content').append($('<div>')
            .attr({class: "card cta cta--featured"})
            .append($('<div>')
                    .attr({class: "card-block"})
                    .append($('<h3>')
                            .attr({class: "card-title no-margin-top"})
                            .append('Card Answer<span class="fa fa-map pull-right"></span></h3>')))
            .append($('<span>')
                    .attr({class: "header-line gradient-color-1"}))
            .append($("<div>")
                    .attr({class: "card-block"})
                    .append($("<p>")
                            .attr({class: "card-text"}).text(answer))));
    $('.card-text').css({'height': '550px', 'text-align': 'center'});
    $('.card-block').css({'text-align': 'center'});
}


function getAllUserFolders() {
    var foldersAccordion = $('#accordion');
    foldersAccordion.empty();
    folderArray.forEach((folder) => {
        console.log(folder);
        folderId = folder.folderId;
        folderName = folder.folderName;
        foldersAccordion.append($('<div>').attr({class: 'card', id: folderId})
                .append($('<div>')
                        .attr({class: 'card-header'})
                        .append($('<a>')
                                .attr({class: 'card-link', 'data-toggle': 'collapse', href: '#' + folderId + 'deckMenu'}).text(folderName)))
                .append($('<div>')
                        .attr({id: folderId + 'deckMenu', class: 'collapse', 'data-parent': '#accordion'})
                        .append($('<div>')
                                .attr({id: folderId + '-decks', class: 'card-body'}))));
        //                    
        decks = folder.decks;
        decks.forEach(deck => {
            deckId = deck.deckId;
            deckName = deck.deckName;
            cards = deck.cards;
            $('#' + folderId + '-decks').append($('<div>')
                    .attr({class: 'card', id: deckId})
                    .append($('<div>')
                            .attr({class: 'card-header'})
                            .append($('<a>')
                                    .attr({class: 'card-link', 'data-toggle': 'collapse', href: '#' + deckId + 'cardMenu'}).text(deckName))
                            .append('<input type="hidden" id=' + deckId + '><button type="button" id="view-deck-button' + deckId + '"class="btn btn-primary study-deck">Study Deck</button>'))
                    .append($('<div>')
                            .attr({id: folderId + 'cardMenu', class: 'collapse', 'data-parent': '#' + folderId})
                            .append($('<div>')
                                    .attr({id: deckId + '-cards', class: 'card-body'}))));
            cards.forEach(card => {
                cardId = card.cardId;
                cardName = card.cardName;
                $('#' + deckId + '-cards').append('<li id="' + cardId + '" class="list-group-item"><span><text>' + cardName +
                        '</text></span>        <span id="edit-delete-buttons"> <button onclick=showEditCardModal(' + cardId +
                        ') class="btn ED edit-button"  id="edit-card" style="font-size:14px"></button> <button onclick="deleteCard(' + cardId +
                        ') class="btn ED trash-button btn-hover-alt" id="delete-card" style="font-size:14px"></button></span></li>');
            });

            $('#view-deck-button' + deckId).click(function (event) {
                studyDeck(deck);
            });
        });


    });
}

function getFolder(folderId) {
    $('#errorMessages').empty();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/folder/' + folderId,
        success: function (folder, status) {
            var id = folder.folderId;
            var name = folder.folderName;
            var user = folder.user;
            var decks = folder.decks;
//            set values in id spots


        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function createFolder() {
    id= $('#current-user-id').val();
    console.log("create folder");
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/FlashCardApp/folder/user/' + id,
        data: JSON.stringify({
            folderName: $('#add-folder-name').val(),
            userId: $('#current-user-id').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (folder, status) {
            $('#errorMessages').empty();
            $('#add-folder-name').val('');
            folderArray.push(folder);
            getAllUserFolders();
            $('#create-folder-modal').modal('hide');
        },
        error: function () {
            $('#error-messages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function updateFolder(folderId) {

    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/FlashCardApp/folder/' + folderId,
        data: JSON.stringify({
//            folderName: $('#____').val(),
//            user: usersArray[$('#current-userId').val() - 1],

        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data, status) {
            $('#errorMessages').empty();
            hideEditCardForm();
            getAllCards();
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function deleteFolder(folderId) {

    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/FlashCardApp/folder/' + folderId,
        success: function (status) {
            showDeleteSuccessBanner();
//            getAllFoldersByUser();
        }
    });
}

//function addFolderToAccordion(folderName) {
//    $('#accordion')
//            .append($('<div>')
//                    .attr({class: 'card', id: folderName + '-folder'})
//                    .append($('<div>')
//                            .attr({class: 'card-header'})
//                            .append($('<a>')
//                                    .attr({class: 'collapsed card-link', 'data-toggle': 'collapse', 'href': '#' + folderName + '-body'})
//                                    .text(folderName)))
//                    .append($('<div>')
//                            .attr({class: 'collapse', id: folderName + '-body', 'data-parent': '#accordion'})
//                            .append($('<div>')
//                                    .attr({class: 'card-body', id: folderName + '-decks'}))));
//}



// =============================================================================
// ==== REVIEW METHODS =========================================================
// =============================================================================

function loadReviewsToArray(reviewArray) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/reviews',
        success: function (reviewsArray) {
            $.each(reviewsArray, function (index, review) {
                reviewArray.push(review);
            });
            //loadDecksToArray(deckArray);
            getAllReviews();


        },
        error: function () {
            $('#error-messages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function getAllReviews() {
    var reviewList = $('#deck-reviews');
    reviewList.empty();
    reviewsToDisplayArray = reviewArray.slice(0, 6);
    reviewsToDisplayArray.forEach(review => {
        var reviewId = review.reviewId;
        var deckId = review.deckId;
        var name = review.reviewName;
        var content = review.reviewContent;
        reviewList.append($('<li>')
                .attr({class: 'list-group-item', id: reviewId})
                .text(content));
    });
}

function getReview(reviewId) {
    $('#errorMessages').empty();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/review/' + reviewId,
        success: function (review, status) {
//            set values in id spots
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}











//    loadCardRatingsToArray(cardRatingArray);
//    getAllCardRatings();
//    getAllDecksByUser();


//function getCardsListByRating() {
//var topCardsList = $('#card-ratings');
//        topCardsList.empty();
//        cardArray.forEach(card => {
//            var id = card.cardId;
//            var name = card.cardName;
////            var chal = card.cardChallenge;
////            var ans = card.cardAnswer;
//            var ratings = card.ratings;
//                topCardsList.append($('<li>')
//                        .attr({class: 'list-group-item', id: id})
//                        .text(name)
//                        .text(ratings));
//        });
//}


//buttons += 'Item #' + id + '<br/>';
//                buttons += name + '<br/>';
//                itemDiv.append(buttons);
//                
//         

// =============================================================================
// ==== RATING METHODS ===========================================================
// =============================================================================

//function loadCardRatingsToArray(cardRatingArray) {
//$.ajax({
//type: 'GET',
//        url: 'http://localhost:8080/FlashCardApp/cardratings',
//        success: function (cardRatingsArray) {
//        $.each(cardRatingsArray, function (index, cardRating) {
//        cardRatingArray.push(cardRating);
//        });
//        getAllCardRatings();
//        
////                getAllCards();
////                getCardsListByRating();
//        },
//        error: function () {
//        $('#error-messages')
//                .append($('<li>')
//                        .attr({class: 'list-group-item list-group-item-danger'})
//                        .text('Error calling web service.  Please try again later.'));
//        }
//});
//}
//
//function getAllCardRatings() {
//    var cardRatingList = $('#card-ratings');
//        cardRatingList.empty();
//        console.log(cardRatingArray);
//        cardRatingArray.forEach(cardRating => {
//            console.log(cardRating);
//            var userId = cardRating.userId;
//            var cardId = cardRating.cardId;
//            var rating = cardRating.rating;
//            console.log(cardArray);
//            console.log(cardId);
//            var card = findItemById(cardArray, "cardId", cardId);
//            console.log(cardId);
//            console.log(card);
//            var cardName = card.cardName;
//            console.log(rating);
//                cardRatingList.append($('<li>')
//                        .attr({class: 'list-group-item', id: cardId})
//                        .text(cardName + ' - ' + rating + '/5'));
//        });
//        
//}


//function getAllCardsByDeckId(deckId) {
//    currentDeck.empty();
//    $.ajax({
//        type: 'GET',
//        url: 'http://localhost:8080/FlashCardApp/cards/deck/' + deckId,
//        success: function (cardsArray) {
//            $.each(cardsArray, function (index, card) {
//                currentDeck.push(card);
//            });
////            getAllCards();
//        },
//        error: function () {
//            $('#error-messages')
//                    .append($('<li>')
//                            .attr({class: 'list-group-item list-group-item-danger'})
//                            .text('Error calling web service.  Please try again later.'));
//        }
//    });
//}