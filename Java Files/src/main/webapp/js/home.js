/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    $('[data-toggle="popover"]').popover();   

    $('#user-name').append('Username');
    
//    Check id
    $('#add-button').click(function(event) {
        
        
    });
    

//    $('#name-button').onclick(function)

                });
// =============================================================================
// ==== USER METHODS ===========================================================
// =============================================================================

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

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/FlashCardApp/user',
                data: JSON.stringify({
//            userName: 
//            password:
//                map from role object on page to - index -1 = id
//              roles: [{role[id of form element]  : #div , role 2 }]

                }),
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                'dataType': 'json',
                success: function (data, status) {
                    $('#errorMessages').empty();
//            Set user values to ('')
                },
                error: function () {
                    $('#errorMessages')
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

        function getAllCards() {
            clearCardsList();
//    CHECK ON ID NAME
            var cardsList = $('#cards-list');
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/FlashCardApp/cards',
                success: function (cardArray, status) {
                    $.each(cardArray, function (index, card) {
                        var id = card.cardId;
                        var name = card.cardName;
                        var chal = card.cardChallenge;
                        var ans = card.cardAnswer;
                        var ratings = card.ratings;
                        var row;
//                HTML FOR WHAT CARD IS GONNA LOOK LIKE

//                cardsList.append(use append, attr, text etc.);

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


        function getAllDecksByUser() {
            clearDecksList();
//    CHECK ON ID NAME
            var decksList = $('#decks-list');
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/FlashCardApp/decks',
                success: function (deckArray, status) {
                    $.each(deckArray, function (index, deck) {
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
                    var id = deck.deckId;
                    var name = deck.deckName;
                    var desc = deck.desc;
                    var reviews = deck.reviews;
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

// GET THIS FUNCTION IN CONTROLLER
        function getAllFoldersByUser(userId) {

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

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/FlashCardApp/deck',
                data: JSON.stringify({
//            folderName: $('#edit-folder-name').val(), 
//            user: usersArray[$('#current-userId').val() - 1], 


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




        function toggleCard() {
            $('#toggle-card').click(function (event) {
                $('#front').toggle();
                $('#back').toggle();
            });
        }

