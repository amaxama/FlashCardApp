/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
    
    
    
    
    
}

function loadAllCards() {
    clearCardsList();
    var cardsList = $('#cards-list');
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/FlashCardApp/cards',
        success: 
    })
})


function clearCardsList() {
    $('#cards-list').empty();
}


