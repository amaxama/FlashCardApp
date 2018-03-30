/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
    
    
    
    
    
});





// =============================================================================
// ==== USER METHODS ==========================================================
// =============================================================================

function getUser(userId) {
    $('#errorMessages').empty();
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/user/' + userId,
        success: function(data, status) {
//            set values in id spots
        },
        error: function() {$('#errorMessages')
                    .append($('<li>')
                    .attr({class: 'list-group-item list-group-item-danger'})
                    .text('Error calling web service.  Please try again later.'));
        }
    });
}



// =============================================================================
// ==== CARD METHODS ==========================================================
// =============================================================================

function getAllCards() {
    clearCardsList();
//    CHECK ON ID NAME
    var cardsList = $('#cards-list');
    
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/cards',
        success: function(cardArray, status) {
            $.each(cardArray, function(index, card) {
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
        error: function() {
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
        success: function(data, status) {
//            set values in id spots
        },
        error: function() {
            $('#errorMessages')
                    .append($('<li>')
                    .attr({class: 'list-group-item list-group-item-danger'})
                    .text('Error calling web service.  Please try again later.'));
        }
    });
}

function createCard() {
    
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/FlashCardApp/card', 
        data: JSON.stringify({
//            cardName: 
//            cardChallenge:
//            cardAnswer:
            
        })
    })
}

function updateCard(cardId) {
    
}

function deleteCard(cardId) {
    
}

function clearCardsList() {
    $('#cards-list').empty();
}

// =============================================================================
// ==== CATEGORY METHODS =======================================================
// =============================================================================


function getCategory(categoryId) {
    $('#errorMessages').empty();
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/category/' + categoryId,
        success: function(data, status) {
//            set values in id spots
        },
        error: function() {
            $('#errorMessages')
                    .append($('<li>')
                    .attr({class: 'list-group-item list-group-item-danger'})
                    .text('Error calling web service.  Please try again later.'));
        }
    });
}



// =============================================================================
// ==== DECK METHODS =========================================================
// =============================================================================


function getDeck(deckId) {
    $('#errorMessages').empty();
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/deck/' + deckId,
        success: function(data, status) {
//            set values in id spots
        },
        error: function() {
            $('#errorMessages')
                    .append($('<li>')
                    .attr({class: 'list-group-item list-group-item-danger'})
                    .text('Error calling web service.  Please try again later.'));
        }
    });
}




// =============================================================================
// ==== FOLDER METHODS =========================================================
// =============================================================================


function getFolder(folderId) {
    $('#errorMessages').empty();
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/folder/' + folderId,
        success: function(data, status) {
//            set values in id spots
        },
        error: function() {
            $('#errorMessages')
                    .append($('<li>')
                    .attr({class: 'list-group-item list-group-item-danger'})
                    .text('Error calling web service.  Please try again later.'));
        }
    });
}



// =============================================================================
// ==== REVIEW METHODS =========================================================
// =============================================================================


function getReview(reviewId) {
    $('#errorMessages').empty();
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/review/' + reviewId,
        success: function(data, status) {
//            set values in id spots
        },
        error: function() {
            $('#errorMessages')
                    .append($('<li>')
                    .attr({class: 'list-group-item list-group-item-danger'})
                    .text('Error calling web service.  Please try again later.'));
        }
    });
}




function toggleCard() {
    $('#toggle-card').click(function(event) {
        $('#front').toggle();
        $('#back').toggle();
    });
}

