/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var cardArray = [];
var cardRatingArray = [];
var deckArray = [];
var folderArray = [];
var catArray = [];
var ratingArray = [];
var currentDeck = [];
var cards = [];
var userId;

$(document).ready(function () {
    getCurrentUser();
    loadUserFoldersToArray(folderArray);
    loadCardsToArray(cardArray);

    $('#create-folder-button').click(function (event) {
        console.log("buttonclicked");
        addFolder();
    });

    $('#create-deck-button').click(function (event) {
        console.log("buttonclicked");
        addDeckToFolder();
    });

    $('#create-card-button').click(function (event) {
        console.log("buttonclicked");
        addCard();
    });

    $('#user-name').append('Username');
    $('#table-div').show();
    $('#card-div').hide();
    $('#card-back').hide();
    $('#toggle-card-button').click(function (event) {
        $('#card-back').toggle();
        $('#card-front').toggle();
    });
    $('#view-deck-button').click(function (event) {
        $('#table-div').toggle();
        $('#card-div').toggle();
        var deckId = $('#deck-id').val();
        var deck = findItemById(deckArray, 'deckId', 1);
        console.log(deck);
        cards = deck.cards;
        console.log(cards);
        cardsLength = cards.length;
        var i = 0;
        $('#left-button').prop('disabled', true);
        $('#card-number').val(i + 1);
//        $('#number-in-deck-front').val(i+1);
        var card = cards[i];
        console.log(card);
        var challenge = card.cardChallenge;
        var answer = card.cardAnswer;
        $('#card-back').hide();
        $('#front-content').append($('<p>')
                .text(challenge));
        $('#back-content').append($('<p>')
                .text(answer));

    });

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

function showCards() {
    $('#cards-list').toggle();
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
    $('#front-content').append($('<p>')
            .text(challenge));
    console.log($('#front-content').text());
    $('#back-content').empty();
    $('#back-content').append($('<p>')
            .text(answer));
    console.log($('#card-back').text());
    console.log(parseInt($('#card-number').val()));

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


function addDeckToFolder() {
    console.log("add deck");
    $('#folder-one-decks').append($('<div>').text($('#add-deck-name').val()));
//            .attr($('#add-deck-name').val())
//            .attr({class: 'card-link', 'data-toggle':'collapse', href: '#collapseOne'}).text($('#add-folder-name').val())))
//            .append($('<div>')
//                    .attr({id: 'collapseOne', class: 'collapse', 'data-parent':'#accordion'}
//                    )
//                    .append($('<div>')
//                            .attr({class: 'card-body'}
//                            )
//                            .text("Decks"))));
//            .attr({class: 'card', id: 'first-folder'}
//            )
//            .append($('<div>')
//                    .attr({class: 'card-header'}
//                    )
//                    .append($('<a>')
//                            .attr({class: 'card-link', 'data-toggle':'collapse', href: '#collapseOne'}
//                            ).text($('#add-folder-name').val())))
//            .append($('<div>')
//                    .attr({id: 'collapseOne', class: 'collapse', 'data-parent':'#accordion'}
//                    )
//                    .append($('<div>')
//                            .attr({class: 'card-body'}
//                            )
//                            .text("Decks"))));
    $('#create-deck-modal').modal('hide');


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
            getAllCards();
//                getCardsListByRating();
        },
        error: function () {
            $('#error-messages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
}

function getAllCards() {
    var cardsList = $('#cards-list');
    var ratingsFeed = $('#card-ratings');
    cardsList.empty();
    cardArray.forEach(card => {
        var id = card.cardId;
        var name = card.cardName;
        var chal = card.cardChallenge;
        var ans = card.cardAnswer;
        var ratings = card.ratings;
        cardsList.append($('<li>')
                .attr({class: 'list-group-item', id: id})
                .text(name));
        ratings.forEach(rating => {
            ratingsFeed.append($('<li>')
                    .attr({class: 'list-group-item', id: id + 'rating'})
                    .text(name + '- ' + rating.rating + '/5'));
        })
    });
}

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

//NEED TO ADD THIS FUNCTION IN CONTROLLER
function getAllCardsByCategory() {

}

function createCard() {

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/FlashCardApp/card',
        data: JSON.stringify({
//            cardName:
//            cardChallenge:
//            cardAnswer:

        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data, status) {
            $('#errorMessages').empty();
//            Set card values to ('')
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


function getAllDecks() {
//    clearDecksList();
//    CHECK ON ID NAME
    var decksList = $('#decks-list');
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/decks',
        success: function (decksArray, status) {
            $.each(decksArray, function (index, deck) {
                deckArray.push(deck);
                var id = deck.deckId;
                var name = deck.deckName;
                var deck = deck.deckDesc;
                var cards = deck.cards;
                var reviews = deck.reviews;
                var row;
//                HTML FOR WHAT CARD IS GONNA LOOK LIKE

//                decksList.append(use append, attr, text etc.);
            });
        },
        error: function () {
//            CHECK ON ID NAME
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service.  Please try again later.'));
        }
    });
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

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/FlashCardApp/deck',
        data: JSON.stringify({
//            deckName: $('#edit-deck-name').val(),
//            deckDesc: $('#edit-deck-desc').val(),

        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data, status) {
            $('#errorMessages').empty();
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


function getAllUserFolders() {
    var foldersAccordion = $('#accordion');
    foldersAccordion.empty();
    folderArray.forEach(folder => {
        folderId = folder.folderId;
        folderName = folder.folderName;
        foldersAccordion.append($('<div>')
            .attr({class: 'card', id: folderId})
            .append($('<div>')
                    .attr({class: 'card-header'})
                    .append($('<a>')
                            .attr({class: 'card-link', 'data-toggle': 'collapse', href: '#collapseOne'}).text(folderName)))
            .append($('<div>')
                    .attr({id: 'collapseOne', class: 'collapse', 'data-parent': '#accordion'})
                    .append($('<div>')
                            .attr({id: folderName + '-decks', class: 'card-body'}))));
    });
    
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


//            console.log(card);
//            var id = card.cardId;
//            var name = card.cardName;
//            var chal = card.cardChallenge;
//            var ans = card.cardAnswer;
//            var ratings = card.ratings;
//                cardsList.append($('<li>')
//                        .attr({class: 'list-group-item', id: id})
//                        .text(name));


//
//                            .append($('<div>')
//                                   .attr({class: 'card-header'})
//                                   .append($('<a>')
//                                           .attr({class: 'card-link', 'data-toggle':'collapse', href: '#collapseOne'}).text($('#add-folder-name').val())))
//                           .append($('<div>')
//                                   .attr({id: 'collapseOne', class: 'collapse', 'data-parent':'#accordion'})
//                                   .append($('<div>')
//                                          .attr({class: 'card-body'})
//                                          .text("Decks"))));  
//    $('#create-folder-modal').modal('hide');




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

function createFolder(userId) {

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/FlashCardApp/folder/user/' + userId,
        data: JSON.stringify({
            folderName: $('#edit-folder-name').val(),
            userId: userId
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        success: function (data, status) {
            $('#errorMessages').empty();
            //            Set deck values to ('')
            //      WHERE GET USER ID FROM?
            getAllDecksByUser();
        },
        error: function () {
            $('#errorMessages')
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
            getAllFoldersByUser();
        }
    });
}

function addFolderToAccordion(folderName) {
    $('#accordion')
            .append($('<div>')
                    .attr({class: 'card', id: folderName + '-folder'})
                    .append($('<div>')
                            .attr({class: 'card-header'})
                            .append($('<a>')
                                    .attr({class: 'collapsed card-link', 'data-toggle': 'collapse', 'href': '#' + folderName + '-body'})
                                    .text(folderName)))
                    .append($('<div>')
                            .attr({class: 'collapse', id: folderName + '-body', 'data-parent': '#accordion'})
                            .append($('<div>')
                                    .attr({class: 'card-body', id: folderName + '-decks'}))));
}



// =============================================================================
// ==== REVIEW METHODS =========================================================
// =============================================================================
//
//FIX REVIEW OBJECT IN JAVA BEFORE DOING JS METHODS

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